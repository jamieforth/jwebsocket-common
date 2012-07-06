//  ---------------------------------------------------------------------------
//  jWebSocket Exceptioon Type Enum - Copyright (c) 2011 Innotrade GmbH
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

/**
 *
 * @author aschulze
 */
public enum WebSocketExceptionType {

    /**  */
    UNDEFINED(-1),
    /**  */
    UNKNOWN_HOST(1),
    /**  */
    UNABLE_TO_CONNECT(2),
    /**  */
    UNABLE_TO_CONNECT_SSL(3),
    /**  */
    PROTOCOL_NOT_SUPPORTED(4);
    private int mExceptionType;

    WebSocketExceptionType(int aExceptionType) {
        mExceptionType = aExceptionType;
    }

    /**
     * @return the exception type's int value
     */
    public int getExceptionType() {
        return mExceptionType;
    }
}
