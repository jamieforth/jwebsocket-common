//    ---------------------------------------------------------------------------
//    jWebSocket - WebSocket Exception
//    Copyright (c) 2010, 2011 Alexander Schulze, Innotrade GmbH
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

/**
 * Exception class to represent jWebSocketServer related exception,
 * extended by unique IDs to identify issue
 * @author Puran Singh, Alexander Schulze
 *
 */
public class WebSocketException extends Exception {

    WebSocketExceptionType mExceptionType = WebSocketExceptionType.UNDEFINED;

    /**
     * creates the exception with given message
     * @param aError the error message
     */
    public WebSocketException(String aError) {
        super(aError);
    }

    /**
     * 
     * @param aError
     * @param aExceptionType
     */
    public WebSocketException(String aError,
            WebSocketExceptionType aExceptionType) {
        super(aError);
        mExceptionType = aExceptionType;
    }

    /**
     * creates the exception with given message
     * @param aError the error message
     * @param aThrowable the cause
     * @param aExceptionType  
     */
    public WebSocketException(String aError,
            WebSocketExceptionType aExceptionType, Throwable aThrowable) {
        super(aError, aThrowable);
        mExceptionType = aExceptionType;
    }

    /**
     * creates the exception with given message
     * @param aError the error message
     * @param throwable the cause 
     */
    public WebSocketException(String aError, Throwable throwable) {
        super(aError, throwable);
    }
    private static final long serialVersionUID = 1L;
}
