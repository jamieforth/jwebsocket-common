// ---------------------------------------------------------------------------
// jWebSocket - JSON Token Processor
// Copyright (c) 2010 jWebSocket.org, Alexander Schulze, Innotrade GmbH
// ---------------------------------------------------------------------------
// This program is free software; you can redistribute it and/or modify it
// under the terms of the GNU Lesser General Public License as published by the
// Free Software Foundation; either version 3 of the License, or (at your
// option) any later version.
// This program is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
// FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
// more details.
// You should have received a copy of the GNU Lesser General Public License along
// with this program; if not, see <http://www.gnu.org/licenses/lgpl.html>.
// ---------------------------------------------------------------------------
package org.jwebsocket.packetProcessors;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jwebsocket.api.ITokenizable;
import org.jwebsocket.api.WebSocketPacket;
import org.jwebsocket.kit.RawPacket;
import org.jwebsocket.token.MapToken;
import org.jwebsocket.token.Token;
import org.jwebsocket.token.TokenFactory;

/**
 * converts JSON formatted data packets into tokens and vice versa.
 *
 * @author Alexander Schulze, Roderick Baier (improvements regarding JSON
 * array), Quentin Ambard (add support for Map and List for PacketToToken and
 * tokeToPacket).
 */
@SuppressWarnings("rawtypes")
public class JSONProcessor {

    /**
     * Convert a json string to a token. If the json string isn't a valid one,
     * return an empty token. Note that if you need a more generic conversion
     * (other sub protocol than json), you may also use the following: Token
     * lToken = TokenServer.packetToToken(aConnector, new
     * RawPacket(aJsonString)) Depending of the SubProtocol of aConnector, the
     * token will be automatically created (if the SubProtocol is
     * WS_SUBPROT_JSON, the conversion will be done internally using this
     * method)
     *
     * @param aJsonString a json string
     * @return the token corresponding to the json string, or an empty token
     */
    public static Token jsonStringToToken(String aJsonString) {
        Token lToken = new MapToken();
        try {
            ObjectMapper lMapper = new ObjectMapper();
            Map<String, Object> lTree = lMapper.readValue(aJsonString, Map.class);
            lToken.setMap(lTree);
        } catch (IOException lEx) {
            // // TODO: process exception
            // log.error(ex.getClass().getSimpleName() + ": " +
            // ex.getMessage());
        }
        return lToken;
    }

    /**
     * converts a JSON formatted data packet into a token.
     *
     * @param aDataPacket
     * @return
     */
    public static Token packetToToken(WebSocketPacket aDataPacket) {
        Token lToken = null;
        try {
            lToken = jsonStringToToken(aDataPacket.getString("UTF-8"));
        } catch (IOException lEx) {
            // // TODO: process exception
            // log.error(ex.getClass().getSimpleName() + ": " +
            // ex.getMessage());
        }
        return lToken;
    }

    public static WebSocketPacket tokenToPacket(Token aToken) {
        WebSocketPacket lPacket = null;
        try {
            // use Jackson for JSON conversion here, since 1.0 beta 5
            // is quicker and less memory consuming
            // can reuse, share globally
            ObjectMapper lMapper = new ObjectMapper();
            String lData = lMapper.writeValueAsString(aToken.getMap());
            lPacket = new RawPacket(lData, "UTF-8");
        } catch (IOException lEx) {
            // System.out.println(lEx.getMessage());
            // TODO: process exception
            // log.error(ex.getClass().getSimpleName() + ": " +
            // ex.getMessage());
        }
        return lPacket;
    }

    /**
     * transform a list to a JSONArray
     *
     * @param aList
     * @return a JSONArray which represents aList
     * @throws JSONException
     */
    public static JSONArray listToJsonArray(List aList) throws JSONException {
        JSONArray lArray = new JSONArray();
        for (Object item : aList) {
            lArray.put(convertObjectToJson(item));
        }
        return lArray;
    }

    /**
     * transform a list of objects to a JSONArray
     *
     * @param aObjectList
     * @return a JSONArray which represents aObjectList
     * @throws JSONException
     */
    public static JSONArray objectListToJsonArray(Object[] aObjectList)
            throws JSONException {
        JSONArray lArray = new JSONArray();
        for (int lIdx = 0; lIdx < aObjectList.length; lIdx++) {
            Object lObj = aObjectList[lIdx];
            lArray.put(convertObjectToJson(lObj));
        }
        return lArray;
    }

    /**
     * transform a map to a JSONObject
     *
     * @param aMap
     * @return a JSONObject which represents aMap. All the keys values are
     * passed as String using the toString method of the key.
     * @throws JSONException
     */
    public static JSONObject mapToJsonObject(Map<?, ?> aMap)
            throws JSONException {
        JSONObject lObject = new JSONObject();
        for (Entry<?, ?> lEntry : aMap.entrySet()) {
            String lKey = lEntry.getKey().toString();
            Object lValue = convertObjectToJson(lEntry.getValue());
            lObject.put(lKey, lValue);
        }
        return lObject;
    }

    /**
     * transform an object to another JSON object (match all possibilities)
     *
     * @param aObject
     * @return an Object which represents aObject (looks for List, Token and
     * Maps)
     * @throws JSONException
     */
    public static Object convertObjectToJson(Object aObject)
            throws JSONException {
        if (aObject instanceof List) {
            return listToJsonArray((List) aObject);
        } else if (aObject instanceof ITokenizable) {
            Token lToken = TokenFactory.createToken();
            ((ITokenizable) aObject).writeToToken(lToken);
            return tokenToJSON(lToken);
        } else if (aObject instanceof Token) {
            return tokenToJSON((Token) aObject);
        } else if (aObject instanceof Object[]) {
            return objectListToJsonArray((Object[]) aObject);
        } else if (aObject instanceof Map) {
            return mapToJsonObject((Map<?, ?>) aObject);
        } else {
            return aObject;
        }
    }

    /**
     * transform a token to a json object
     *
     * @param aToken
     * @return a JSONObject which represents aToken (looks for List, Token and
     * Maps)
     * @throws JSONException
     */
    public static JSONObject tokenToJSON(Token aToken) throws JSONException {
        JSONObject lJSO = new JSONObject();
        Iterator<String> iterator = aToken.getKeyIterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = aToken.getObject(key);
            lJSO.put(key, convertObjectToJson(value));
        }
        return lJSO;
    }
}
