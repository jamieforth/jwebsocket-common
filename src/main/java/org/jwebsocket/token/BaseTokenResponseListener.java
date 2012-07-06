//    ---------------------------------------------------------------------------
//    jWebSocket - jWebSocket Client Response Listener Adapter Implementation
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
public class BaseTokenResponseListener implements WebSocketResponseTokenListener {

    private long mTimeout = 0;

    public BaseTokenResponseListener() {
    }

    public BaseTokenResponseListener(long aTimeout) {
        setTimeout(aTimeout);
    }

    /**
     * Returns the timeout of the request.
     * @return
     */
    @Override
    public final long getTimeout() {
        return mTimeout;
    }

    /**
     * Specifies the timeout of the request.
     * @param aTimeout
     */
    @Override
    public final void setTimeout(long aTimeout) {
        mTimeout = aTimeout;
    }

    /**
     * Is fired when the given response timeout is exceeded.
     * @param aToken
     */
    @Override
    public void OnTimeout(Token aToken) {
    }

    /**
     * Is fired on any response to a send token.
     * @param aToken
     */
    @Override
    public void OnResponse(Token aToken) {
    }

    /**
     *  Is fired if token.code equals 0 (zero).
     * @param aToken
     */
    @Override
    public void OnSuccess(Token aToken) {
    }

    /**
     * Is fired if token.code does not equal 0 (zero).
     * @param aToken
     */
    @Override
    public void OnFailure(Token aToken) {
    }
}
