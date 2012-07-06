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
public enum WebSocketJSONType {

    /** Invalid data type */
    INVALID(-1),
    /** string */
    STRING(0),
    /** number (64 bit float) */
    NUMBER(2),
    /** boolean (true/false)  */
    BOOLEAN(3),
    /** date including time */
    DATE(4),
    /** array */
    ARRAY(5),
    /** object */
    OBJECT(6),
    /** function */
    FUNCTION(7);
    private int mJSONType;

    WebSocketJSONType(int aDataType) {
        mJSONType = aDataType;
    }

    /**
     * @return the status int value
     */
    public int getDataType() {
        return mJSONType;
    }
}
