//    ---------------------------------------------------------------------------
//    jWebSocket - Copyright (c) 2010 Innotrade GmbH
//    ---------------------------------------------------------------------------
//    This program is free software; you can redistribute it and/or modify it
//    under the terms of the GNU Lesser General Public License as published by the
//    Free Software Foundation; either version 3 of the License, or (at your
//    option) any later version.
//    This program is distributed in the hope that it will be useful, but WITHOUT
//    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
//    FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
//    more details.
//    You should have received a copy of the GNU Lesser General Public License along
//    with this program; if not, see <http://www.gnu.org/licenses/lgpl.html>.
//    ---------------------------------------------------------------------------
package org.jwebsocket.kit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javolution.util.FastMap;

/**
 *
 * @author alexanderschulze
 */
public class Headers {

    public static final String HOST = "Host";
    public static final String UPGRADE = "Upgrade";
    public static final String CONNECTION = "Connection";
    public static final String SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
    public static final String SEC_WEBSOCKET_ORIGIN = "Sec-WebSocket-Origin";
    public static final String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    public static final String SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
    public static final String SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private Map<String, String> mFields = new FastMap<String, String>();
    private String mFirstLine = null;
    private byte[] mTrailingBytes = null;

    /**
     * 
     * @param aVersion
     * @param aIS
     * @throws WebSocketException
     */
    public void readFromStream(int aVersion, InputStream aIS) throws WebSocketException {
        // the header is complete when the first empty line is detected
        boolean lHeaderComplete = false;

        // signal if we are still within the header
        boolean lInHeader = true;
        int lLineNo = 0;
        ByteArrayOutputStream lBuffer = new ByteArrayOutputStream(512);
        ByteArrayOutputStream lTrailing = new ByteArrayOutputStream(16);

        int lA, lB = -1;
        while (!lHeaderComplete) {
            lA = lB;
            try {
                lB = aIS.read();
            } catch (IOException ex) {
                throw new WebSocketException("Error on reading stream: " + ex.getMessage());
            }
            if (lB < 0) {
                return;
            }
            lBuffer.write(lB);
            if (!lInHeader) {
                lTrailing.write(lB);
                if (lTrailing.size() == 16) {
                    lHeaderComplete = true;
                }
            } else if (0x0D == lA && 0x0A == lB) {
                String lLine;
                try {
                    lLine = lBuffer.toString("UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    throw new WebSocketException("Error on on converting string: " + ex.getMessage());
                }
                // if the line is empty, the header is complete
                if (lLine.trim().equals("")) {
                    // the header is finished
                    lInHeader = false;
                    // if not hixie the header is complete now
                    lHeaderComplete = !WebSocketProtocolAbstraction.isHixieVersion(aVersion);
                } else {
                    if (0 == lLineNo) {
                        mFirstLine = lLine;
                    } else {
                        String[] lKeyVal = lLine.split(":", 2);
                        if (2 == lKeyVal.length) {
                            mFields.put(lKeyVal[0].trim(), lKeyVal[1].trim());
                        }
                    }
                    lLineNo++;
                }
                // if end of line reset the line buffer
                lBuffer.reset();
            }
        }
    }

    /**
     * @return the mFields
     */
    public Map<String, String> getFields() {
        return mFields;
    }

    /**
     * 
     * @param aField
     * @return
     */
    public String getField(String aField) {
        if (null != mFields) {
            return mFields.get(aField);
        }
        return null;
    }

    /**
     * @return the mFirstLine
     */
    public String getFirstLine() {
        return mFirstLine;
    }

    /**
     * Returns the trailing bytes of the hixie header. Kept for backward 
     * compatibility with older browsers, flash-bridge and other clients.
     * @return the trailing bytes (16) of the header.
     */
    public byte[] getTrailingBytes() {
        // FindBug: This variable is only ever null
        return mTrailingBytes;
    }

    public boolean isValid() {
        // TODO: improve header validation based on protocol version and header content!
        return (mFirstLine != null && mFields.size() > 0);
    }
}
