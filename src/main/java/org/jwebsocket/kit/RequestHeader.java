//    ---------------------------------------------------------------------------
//    jWebSocket - RequestHeader Object
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

import java.util.Map;
import javolution.util.FastMap;
import org.jwebsocket.config.JWebSocketCommonConstants;

/**
 * Holds the header of the initial WebSocket request from the client to the
 * server. The RequestHeader internally maintains a FastMap to store key/values
 * pairs.
 *
 * @author aschulze
 * @author jang
 * @version $Id: RequestHeader.java 596 2010-06-22 17:09:54Z fivefeetfurther $
 */
public final class RequestHeader {

    private Map<String, Object> mFields = new FastMap<String, Object>();
    public static final String WS_PROTOCOL = "subprot";
    public static final String WS_DRAFT = "draft";
    public static final String WS_VERSION = "version";
    public static final String WS_ORIGIN = "origin";
    public static final String WS_LOCATION = "location";
    public static final String WS_PATH = "path";
    public static final String WS_SEARCHSTRING = "searchString";
    public static final String WS_HOST = "host";
    public static final String WS_SECKEY = "secKey";
    public static final String WS_SECKEY1 = "secKey1";
    public static final String WS_SECKEY2 = "secKey2";
    public static final String WS_COOKIES = "cookie";
    public static final String URL_ARGS = "args";
    public static final String TIMEOUT = "timeout";
    public static final String USER_AGENT = "User-Agent";

    /**
     * Puts a new object value to the request header.
     *
     * @param aKey
     * @param aValue
     */
    public void put(String aKey, Object aValue) {
        mFields.put(aKey, aValue);
    }

    /**
     * Returns the object value for the given key or {@code null} if the key
     * does not exist in the header.
     *
     * @param aKey
     * @return object value for the given key or {@code null}.
     */
    public Object get(String aKey) {
        return mFields.get(aKey);
    }

    /**
     * Returns the string value for the given key or {@code null} if the key
     * does not exist in the header.
     *
     * @param aKey
     * @return String value for the given key or {@code null}.
     */
    public String getString(String aKey) {
        return (String) mFields.get(aKey);
    }

    /**
     * Returns a Map of the optional URL arguments passed by the client.
     *
     * @return Map of the optional URL arguments.
     */
    public Map getArgs() {
        return (Map) mFields.get(URL_ARGS);
    }

    /**
     * Returns the sub protocol passed by the client or a default value if no
     * sub protocol has been passed either in the header or in the URL
     * arguments.
     *
     * @return Sub protocol passed by the client or default value.
     */
    public String getSubProtocol() {
        return resolveSubprotocol()[0];
    }

    /**
     * Returns the subprotocol format in which messages are exchanged between
     * client and server.
     *
     * @return subprotocol format passed by the client or default value
     */
    public String getFormat() {
        return resolveSubprotocol()[1];
    }

    /**
     * Tries to resolve correct subprotocol & format regardless of client
     * version (old, new, hixie, hybi, browser, java). TODO: deprecate this
     * method once majority of clients switch to new 'subprotocol/format' scheme
     *
     * @return array with two members: protocol and format
     */
    private String[] resolveSubprotocol() {
        String lSubProt = (String) mFields.get(WS_PROTOCOL);
        if (lSubProt == null) {
            lSubProt = JWebSocketCommonConstants.WS_SUBPROT_DEFAULT;
        }
        if (lSubProt.indexOf('/') != -1) {
            // expecting 'subprotocol/format' scheme
            return lSubProt.split("/");
        } else {
            String lFormat = JWebSocketCommonConstants.WS_FORMAT_DEFAULT;
            if (JWebSocketCommonConstants.WS_SUBPROT_JSON.equals(lSubProt)) {
                lFormat = JWebSocketCommonConstants.WS_FORMAT_JSON;
            } else if (JWebSocketCommonConstants.WS_SUBPROT_XML.equals(lSubProt)) {
                lFormat = JWebSocketCommonConstants.WS_FORMAT_XML;
            } else if (JWebSocketCommonConstants.WS_SUBPROT_CSV.equals(lSubProt)) {
                lFormat = JWebSocketCommonConstants.WS_FORMAT_CSV;
            } else if (JWebSocketCommonConstants.WS_SUBPROT_TEXT.equals(lSubProt)) {
                lFormat = JWebSocketCommonConstants.WS_FORMAT_TEXT;
            } else if (JWebSocketCommonConstants.WS_SUBPROT_BINARY.equals(lSubProt)) {
                lFormat = JWebSocketCommonConstants.WS_FORMAT_BINARY;
            }

            return new String[]{lSubProt, lFormat};
        }
    }

    /**
     * Returns the session timeout passed by the client or a default value if no
     * session timeout has been passed either in the header or in the URL
     * arguments.
     *
     * @param aDefault
     * @return Session timeout passed by the client or default value.
     */
    public Integer getTimeout(Integer aDefault) {
        Map lArgs = getArgs();
        Integer lTimeout = null;
        if (lArgs != null) {
            try {
                lTimeout = Integer.parseInt((String) (lArgs.get(TIMEOUT)));
            } catch (RuntimeException lEx) {
            }
        }
        return (lTimeout != null ? lTimeout : aDefault);
    }

    public int getVersion() {
        return (Integer) mFields.get(WS_VERSION);
    }

    public Map getCookies() {
        return (Map) get(WS_COOKIES);
    }
}
