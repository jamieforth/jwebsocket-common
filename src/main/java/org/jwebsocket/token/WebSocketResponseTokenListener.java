//    ---------------------------------------------------------------------------
//    jWebSocket - jWebSocket Client Response Listener Interface
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
public interface WebSocketResponseTokenListener {

    /**
     * Returns the timeout of the request.
     * @return
     */
    long getTimeout();

    /**
     * Specifies the timeout of the request.
     * @param aTimeout
     */
    void setTimeout(long aTimeout);

    /**
     * Is fired when the given response timeout is exceeded.
     * @param aToken
     */
    void OnTimeout(Token aToken);

    /**
     * Is fired on any response to a send token.
     * @param aToken
     */
    void OnResponse(Token aToken);

    /**
     *  Is fired if token.code equals 0 (zero).
     * @param aToken
     */
    void OnSuccess(Token aToken);

    /**
     * Is fired if token.code does not equal 0 (zero).
     * @param aToken
     */
    void OnFailure(Token aToken);
}
