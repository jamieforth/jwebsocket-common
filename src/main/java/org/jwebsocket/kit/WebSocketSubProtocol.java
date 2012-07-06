//  ---------------------------------------------------------------------------
//  jWebSocket Sub Protocol - Copyright (c) 2011 Innotrade GmbH
//  ---------------------------------------------------------------------------
//  This program is free software; you can redistribute it and/or modify it
//  under the terms of the GNU Lesser General Public License as published by the
//  Free Software Foundation; either version 3 of the License, or (at your
//  option) any later version.
//  This program is distributed in the hope that it will be useful, but WITHOUT
//  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
//  FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
//  more details.
//  You should have received a copy of the GNU Lesser General Public License along
//  with this program; if not, see <http://www.gnu.org/licenses/lgpl.html>.
//  ---------------------------------------------------------------------------
package org.jwebsocket.kit;

import org.jwebsocket.config.JWebSocketCommonConstants;

/**
 *
 * @author aschulze
 */
public class WebSocketSubProtocol {

    private String mSubProt = null;
    private String mNameSpace = null;
    private String mFormat = null;
    private WebSocketEncoding mEncoding;

    public WebSocketSubProtocol(String aSubProt, WebSocketEncoding aEncoding) {
        this.mSubProt = aSubProt;
        this.mEncoding = aEncoding;

        if (JWebSocketCommonConstants.WS_SUBPROT_JSON.equals(aSubProt)) {
            mNameSpace = JWebSocketCommonConstants.WS_SUBPROT_PREFIX;
            mFormat = JWebSocketCommonConstants.WS_FORMAT_JSON;
        } else if (JWebSocketCommonConstants.WS_SUBPROT_XML.equals(aSubProt)) {
            mNameSpace = JWebSocketCommonConstants.WS_SUBPROT_PREFIX;
            mFormat = JWebSocketCommonConstants.WS_FORMAT_XML;
        } else if (JWebSocketCommonConstants.WS_SUBPROT_CSV.equals(aSubProt)) {
            mNameSpace = JWebSocketCommonConstants.WS_SUBPROT_PREFIX;
            mFormat = JWebSocketCommonConstants.WS_FORMAT_CSV;
        } else if (JWebSocketCommonConstants.WS_SUBPROT_TEXT.equals(aSubProt)) {
            mNameSpace = JWebSocketCommonConstants.WS_SUBPROT_PREFIX;
            mFormat = JWebSocketCommonConstants.WS_FORMAT_TEXT;
        } else if (JWebSocketCommonConstants.WS_SUBPROT_BINARY.equals(aSubProt)) {
            mNameSpace = JWebSocketCommonConstants.WS_SUBPROT_PREFIX;
            mFormat = JWebSocketCommonConstants.WS_FORMAT_BINARY;
        }
    }

    @Override
    public int hashCode() {
        return mSubProt.hashCode() + mEncoding.getEncoding();
    }

    @Override
    public boolean equals(Object aObj) {
        if (aObj instanceof WebSocketSubProtocol) {
            WebSocketSubProtocol lOther = (WebSocketSubProtocol) aObj;
            return mSubProt.equals(lOther.mSubProt) && mEncoding.equals(lOther.mEncoding);
        } else {
            return super.equals(aObj);
        }
    }

    @Override
    public String toString() {
        StringBuilder lBuff = new StringBuilder();
        lBuff.append(mSubProt).append('[').append(mEncoding.name()).append("]");
        return lBuff.toString();
    }

    /**
     * @return the mSubProt
     */
    public String getSubProt() {
        return mSubProt;
    }

    /**
     * @return the mEncoding
     */
    public WebSocketEncoding getEncoding() {
        return mEncoding;
    }

    /**
     * @return the namespace of the sub protocol
     */
    public String getNameSpace() {
        return mNameSpace;
    }

    /**
     * @return the format of the sub protocol
     */
    public String getFormat() {
        return mFormat;
    }
}
