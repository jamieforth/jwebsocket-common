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

    private int OPCODE_INVALID = -1;
    // default for hybi draft 10
    private int OPCODE_FRAGMENT;
    private int OPCODE_TEXT;
    private int OPCODE_BINARY;
    private int OPCODE_CLOSE;
    private int OPCODE_PING;
    private int OPCODE_PONG;

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

    /**
     * @return the OPCODE_INVALID
     */
    public int getOPCODE_INVALID() {
        return OPCODE_INVALID;
    }

    /**
     * @param OPCODE_INVALID the OPCODE_INVALID to set
     */
    public void setOPCODE_INVALID(int OPCODE_INVALID) {
        this.OPCODE_INVALID = OPCODE_INVALID;
    }

    /**
     * @return the OPCODE_FRAGMENT
     */
    public int getOPCODE_FRAGMENT() {
        return OPCODE_FRAGMENT;
    }

    /**
     * @param OPCODE_FRAGMENT the OPCODE_FRAGMENT to set
     */
    public void setOPCODE_FRAGMENT(int OPCODE_FRAGMENT) {
        this.OPCODE_FRAGMENT = OPCODE_FRAGMENT;
    }

    /**
     * @return the OPCODE_TEXT
     */
    public int getOPCODE_TEXT() {
        return OPCODE_TEXT;
    }

    /**
     * @param OPCODE_TEXT the OPCODE_TEXT to set
     */
    public void setOPCODE_TEXT(int OPCODE_TEXT) {
        this.OPCODE_TEXT = OPCODE_TEXT;
    }

    /**
     * @return the OPCODE_BINARY
     */
    public int getOPCODE_BINARY() {
        return OPCODE_BINARY;
    }

    /**
     * @param OPCODE_BINARY the OPCODE_BINARY to set
     */
    public void setOPCODE_BINARY(int OPCODE_BINARY) {
        this.OPCODE_BINARY = OPCODE_BINARY;
    }

    /**
     * @return the OPCODE_CLOSE
     */
    public int getOPCODE_CLOSE() {
        return OPCODE_CLOSE;
    }

    /**
     * @param OPCODE_CLOSE the OPCODE_CLOSE to set
     */
    public void setOPCODE_CLOSE(int OPCODE_CLOSE) {
        this.OPCODE_CLOSE = OPCODE_CLOSE;
    }

    /**
     * @return the OPCODE_PING
     */
    public int getOPCODE_PING() {
        return OPCODE_PING;
    }

    /**
     * @param OPCODE_PING the OPCODE_PING to set
     */
    public void setOPCODE_PING(int OPCODE_PING) {
        this.OPCODE_PING = OPCODE_PING;
    }

    /**
     * @return the OPCODE_PONG
     */
    public int getOPCODE_PONG() {
        return OPCODE_PONG;
    }

    /**
     * @param OPCODE_PONG the OPCODE_PONG to set
     */
    public void setOPCODE_PONG(int OPCODE_PONG) {
        this.OPCODE_PONG = OPCODE_PONG;
    }
}
