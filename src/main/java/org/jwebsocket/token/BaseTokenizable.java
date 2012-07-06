//    ---------------------------------------------------------------------------
//    jWebSocket - BaseTokenizable Class
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
public class BaseTokenizable {

    /**
     *
     */
    public static final String ARG_CLASS_ID = "_jwsClassName";
    private String mClassName = null;

    /**
     *
     */
    public BaseTokenizable() {
        mClassName = this.getClass().getName();
    }

    /**
     *
     * @param aToken
     */
    public void writeToToken(Token aToken) {
        if (aToken != null) {
            // add reserved field _jwsClassName to identify class at target
            aToken.setString(ARG_CLASS_ID, mClassName);
        }
    }

    /**
     *
     * @param aToken
     */
    public void readFromToken(Token aToken) {
        if (aToken != null) {
            // add reserved field _jwsClassName to identify class at target
            mClassName = aToken.getString(ARG_CLASS_ID);
        }
    }

    /**
     * @return the mClassName
     */
    public String getClassName() {
        return mClassName;
    }

    // return the object as a token
    /**
     *
     * @return
     */
    public Token toToken() {
        Token lToken = TokenFactory.createToken();
        writeToToken(lToken);
        return lToken;
    }
}
