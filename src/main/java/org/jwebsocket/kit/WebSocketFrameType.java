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
public enum WebSocketFrameType {

    /**  */
    INVALID(-1),
    /**  */
    FRAGMENT(0x00),
    /**  */
    TEXT(0x01),
    /**  */
    BINARY(0x02),
    /**  */
    CLOSE(0x08),
    /**  */
    PING(0x09),
    /**  */
    PONG(0x0A);
    private int mFrameType;

    WebSocketFrameType(int aFrameType) {
        mFrameType = aFrameType;
    }

    /**
     * @return the status int value
     */
    public int getFrameType() {
        return mFrameType;
    }
}
