//    ---------------------------------------------------------------------------
//    jWebSocket - FrameType to OpCode Implementation
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

/**
 *
 * @author aschulze
 */
public class WebSocketOpcode {

    public int OPCODE_INVALID = -1;
    // default for hybi draft 10
    public int OPCODE_FRAGMENT = 0x00;
    public int OPCODE_TEXT = 0x01;
    public int OPCODE_BINARY = 0x02;
    public int OPCODE_CLOSE = 0x08;
    public int OPCODE_PING = 0x09;
    public int OPCODE_PONG = 0x0A;

    public WebSocketOpcode(int aVersion) {
        if (aVersion >= 7) {
            // tested for hybi draft 10
            OPCODE_FRAGMENT = 0x00;
            OPCODE_TEXT = 0x01;
            OPCODE_BINARY = 0x02;
            OPCODE_CLOSE = 0x08;
            OPCODE_PING = 0x09;
            OPCODE_PONG = 0x0A;
        } else {
            // tested for hybi drafts < 7 
            OPCODE_FRAGMENT = 0x00;
            OPCODE_CLOSE = 0x01;
            OPCODE_PING = 0x02;
            OPCODE_PONG = 0x03;
            OPCODE_TEXT = 0x04;
            OPCODE_BINARY = 0x05;
        }
    }
}
