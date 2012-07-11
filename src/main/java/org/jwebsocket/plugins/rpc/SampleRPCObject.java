//    ---------------------------------------------------------------------------
//    jWebSocket - jWebSocket Sample tokenizable RPC Object
//    Copyright (c) 2010 jWebSocket.org, Alexander Schulze, Innotrade GmbH
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
package org.jwebsocket.plugins.rpc;

import org.jwebsocket.api.ITokenizable;
import org.jwebsocket.token.BaseTokenizable;
import org.jwebsocket.token.Token;

/**
 *
 * @author aschulze
 */
public class SampleRPCObject extends BaseTokenizable implements ITokenizable {

    private String mFirstName = null;
    private String mLastName = null;
    private String mAddress = null;
    private String mZipcode = null;
    private String mCity = null;

    // we necessarily need to have a default constructor with no arguments
    // for tokenizable RPC objects
    public SampleRPCObject() {
        // don't miss this call to initialize classname
        super();
    }

    public SampleRPCObject(String aFirstName, String aLastName,
            String aAddress, String aZipcode, String aCity) {

        // don't miss this call to initialize classname
        super();

        mFirstName = aFirstName;
        mLastName = aLastName;
        mAddress = aAddress;
        mZipcode = aZipcode;
        mCity = aCity;
    }

    @Override
    public void writeToToken(Token aToken) {
        if (aToken == null) {
            return;
        }
        aToken.setString("firstname", mFirstName);
        aToken.setString("lastname", mLastName);
        aToken.setString("address", mAddress);
        aToken.setString("zipcode", mZipcode);
        aToken.setString("city", mCity);

        // don't miss this call to write classname to Token
        super.writeToToken(aToken);
    }

    @Override
    public void readFromToken(Token aToken) {
        if (aToken == null) {
            return;
        }
        mFirstName = aToken.getString("firstname");
        mLastName = aToken.getString("lastname");
        mAddress = aToken.getString("address");
        mZipcode = aToken.getString("zipcode");
        mCity = aToken.getString("city");

        // don't miss this call to read classname to Token
        super.readFromToken(aToken);
    }
}
