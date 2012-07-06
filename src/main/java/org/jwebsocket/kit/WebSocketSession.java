//    ---------------------------------------------------------------------------
//    jWebSocket - Connector API
//    Copyright (c) 2010 Alexander Schulze, Innotrade GmbH
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

import java.util.Map;

/**
 *
 * @author aschulze
 * @author kyberneees (Persistent storage support for each connector session)
 */
public class WebSocketSession {

    private String mSessionId = null;
    private Map<String, Object> mStorage;

    public WebSocketSession() {
    }

    /**
     *
     * @param aSessionId a session identifier
     */
    public WebSocketSession(String aSessionId) {
        mSessionId = aSessionId;
    }

    /**
     * @return the session identifier
     */
    public String getSessionId() {
        return mSessionId;
    }

    /**
     * @param aSessionId the session identifier to set
     */
    public void setSessionId(String aSessionId) {
        if (null == mSessionId) {
            this.mSessionId = aSessionId;
        } else {
            throw new UnsupportedOperationException("The session identifier property is in read-only state!");
        }
    }

    /**
     *
     * @return the session persistent storage instance
     */
    public Map<String, Object> getStorage() {
        return mStorage;
    }

    /**
     *
     * @param aStorage the session persistent storage instance to set
     */
    public void setStorage(Map<String, Object> aStorage) {
        if (null == mStorage) {
            mStorage = aStorage;
        } else {
            throw new UnsupportedOperationException("The storage property is in read-only state!!");
        }
    }
}
