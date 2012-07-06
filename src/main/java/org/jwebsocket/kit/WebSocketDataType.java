//  ---------------------------------------------------------------------------
//  jWebSocket Protocol DataType Enum - Copyright (c) 2011 Innotrade GmbH
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
 * These enumeration specifies the supported data types for data exchange 
 * between multiple platforms.
 * @author aschulze
 */
public enum WebSocketDataType {

    /** Invalid data type */
    INVALID(-1),
    /** UTF formatted text */
    TEXT(0),
    /** binary data (byte array) */
    BINARY(1),
    /** 32 bit integer */
    INTEGER(2),
    /** 8 bit byte */
    BYTE(3),
    /** 64 long integer */
    LONG(4),
    /** normal precision float  */
    FLOAT(5),
    /** double precision float  */
    DOUBLE(6),
    /** date without time  */
    DATE(7),
    /** time with outdate */
    TIME(8),
    /** date and date */
    TIMESTAMP(9),
    /** boolean (true/false)  */
    BOOLEAN(10),
    /** list of objects (only WebSocketDataTypes allowed) */
    LIST(11),
    /** map of objects (only WebSocketDataTypes allowed) */
    MAP(12);
    private int mDataType;

    WebSocketDataType(int aDataType) {
        mDataType = aDataType;
    }

    /**
     * @return the status int value
     */
    public int getDataType() {
        return mDataType;
    }
}
