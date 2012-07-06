//    ---------------------------------------------------------------------------
//    jWebSocket - Basic Token Implementation
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
package org.jwebsocket.token;

import java.util.List;
import java.util.Map;

/**
 *
 * @author aschulze
 */
public abstract class BaseToken implements Token {

    /**
     *
     */
    public static final String TT_EVENT = "event";

    @Override
    public void setDouble(String aKey, Float aValue) {
        setDouble(aKey, Double.valueOf(aValue));
    }

    @Override
    public boolean setValidated(String aKey, Object aObj) {
        boolean lRes = true;
        if (aObj instanceof BaseTokenizable) {
            Token lToken = TokenFactory.createToken();
            ((BaseTokenizable)aObj).writeToToken(lToken);
            setToken(aKey, lToken);
        } else if (aObj instanceof Boolean) {
            setBoolean(aKey, (Boolean) aObj);
        } else if (aObj instanceof Integer) {
            setInteger(aKey, (Integer) aObj);
        } else if (aObj instanceof Double) {
            setDouble(aKey, (Double) aObj);
        } else if (aObj instanceof String) {
            setString(aKey, (String) aObj);
        } else if (aObj instanceof List) {
            setList(aKey, (List) aObj);
        } else if (aObj instanceof Map) {
            setMap(aKey, (Map) aObj);
        } else {
            lRes = false;
        }
        return lRes;
    }

    /**
     *
     * @return
     */
    @Override
    public final String getType() {
        return getString("type");
    }

    /**
     *
     * @param aType
     */
    @Override
    public final void setType(String aType) {
        setString("type", aType);
    }

    /**
     * Returns the name space of the token. If you have the same token type
     * interpreted by multiple different plug-ins the name space allows to
     * uniquely address a certain plug-in. Each plug-in has its own name space.
     * @return the name space.
     */
    @Override
    public final String getNS() {
        return getString("ns");
    }

    /**
     * Sets the name space of the token. If you have the same token type
     * interpreted by multiple different plug-ins the namespace allows to
     * uniquely address a certain plug-in. Each plug-in has its own namespace.
     * @param aNS the namespace to be set for the token.
     */
    @Override
    public final void setNS(String aNS) {
        setString("ns", aNS);
    }
}
