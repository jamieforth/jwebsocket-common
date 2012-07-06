//  ---------------------------------------------------------------------------
//  jWebSocket Protocol Frametype Enum - Copyright (c) 2011 Innotrade GmbH
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
public enum WebSocketEncoding {

    /**  */
    INVALID(-1),
    /**  */
    TEXT(0x00),
    /**  */
    BINARY(0x01);
    private int mEncoding;

    WebSocketEncoding(int aEncoding) {
        mEncoding = aEncoding;
    }

    /**
     * @return the status int value
     */
    public int getEncoding() {
        return mEncoding;
    }
}
