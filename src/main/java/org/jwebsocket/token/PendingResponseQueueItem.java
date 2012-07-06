//    ---------------------------------------------------------------------------
//    jWebSocket - jWebSocket Item in the pending responses queue
//    Copyright (c) 2011 Alexander Schulze, Innotrade GmbH
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
package org.jwebsocket.token;

/**
 *
 * @author aschulze
 */
public class PendingResponseQueueItem {

    private Token mToken = null;
    private WebSocketResponseTokenListener mListener = null;

    public PendingResponseQueueItem(Token aToken,
            WebSocketResponseTokenListener aListener) {
        mToken = aToken;
        mListener = aListener;
    }

    /**
     * @return the mToken
     */
    public Token getToken() {
        return mToken;
    }

    /**
     * @param mToken the mToken to set
     */
    public void setToken(Token aToken) {
        this.mToken = aToken;
    }

    /**
     * @return the mListener
     */
    public WebSocketResponseTokenListener getListener() {
        return mListener;
    }

    /**
     * @param mListener the mListener to set
     */
    public void setListener(WebSocketResponseTokenListener aListener) {
        this.mListener = aListener;
    }
}
