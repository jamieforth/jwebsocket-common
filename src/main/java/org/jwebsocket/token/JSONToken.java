//    ---------------------------------------------------------------------------
//    jWebSocket - JSON Token Implementation
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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javolution.util.FastMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jwebsocket.api.ITokenizable;

/**
 * A token is ...
 * @author aschulze
 */
public class JSONToken extends BaseToken implements Token {

    private JSONObject mData = null;

    /**
     * Creates a new empty instance of a token.
     * The token does not contain any items.
     */
    public JSONToken() {
        mData = new JSONObject();
    }

    /**
     *
     * @param aType
     */
    public JSONToken(String aType) {
        mData = new JSONObject();
        setType(aType);
    }

    /**
     *
     * @param aJSON
     */
    public JSONToken(JSONObject aJSON) {
        mData = aJSON;
    }

    /**
     *
     * @param aNS
     * @param aType
     */
    public JSONToken(String aNS, String aType) {
        mData = new JSONObject();
        setNS(aNS);
        setType(aType);
    }

    @Override
    public void clear() {
        // TODO: implement clear for JSON token
    }

    @Override
    public void set(ITokenizable aTokenizable) {
    }

    /**
     *
     *
     * @return
     */
    @Override
    public Map getMap() {
        // TODO: implement getMap for JSON token
        return null;
    }

    /**
     *
     *
     * @param aMap 
     */
    @Override
    public void setMap(Map aMap) {
        // TODO: implement setMap for JSON token
    }

    /**
     *
     * @param aJSON
     */
    public void setJSONObject(JSONObject aJSON) {
        mData = aJSON;
    }

    /**
     *
     *
     * @return
     */
    public JSONObject getJSONObject() {
        return mData;
    }

    private Object getValue(Object aValue) {
        if (aValue instanceof JSONToken) {
            aValue = ((JSONToken) aValue).getJSONObject();
        } else if (aValue instanceof Collection) {
            JSONArray lJA = new JSONArray();
            for (Object lItem : (Collection) aValue) {
                lJA.put(getValue(lItem));
            }
            aValue = lJA;
        } else if (aValue instanceof Map) {
            JSONObject lJO = new JSONObject();
            for (Entry<Object, Object> lItem : ((Map<Object, Object>) aValue).entrySet()) {
                try {
                    lJO.put(lItem.getKey().toString(), getValue(lItem.getValue()));
                } catch (JSONException lEx) {
                }
            }
            aValue = lJO;
        } else if (aValue instanceof Object[]) {
            JSONArray lJA = new JSONArray();
            Object[] lOA = (Object[]) aValue;
            for (int lIdx = 0; lIdx < lOA.length; lIdx++) {
                lJA.put(getValue(lOA[lIdx]));
            }
            aValue = lJA;
        }
        return aValue;
    }

    /**
     * puts a new key/value pair into the token, in other words it adds a
     * new item to the token.
     * @param aKey key of the the token item.
     * @param aValue value of the token item.
     */
    public void put(String aKey, Object aValue) {
        try {
            mData.put(aKey, getValue(aValue));
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @return
     */
    public Object get(String aKey) {
        try {
            return mData.get(aKey);
        } catch (JSONException lEx) {
            return null;
        }
    }

    /**
     *
     * @param aKey
     */
    @Override
    public void remove(String aKey) {
        mData.remove(aKey);
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public String getString(String aKey, String aDefault) {
        String lResult;
        try {
            lResult = mData.getString(aKey);
        } catch (JSONException lEx) {
            lResult = aDefault;
        }
        return lResult;
    }

    /**
     *
     * @param aKey
     */
    @Override
    public void setString(String aKey, String aValue) {
        try {
            mData.put(aKey, aValue);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public String getString(String aKey) {
        return getString(aKey, null);
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public Integer getInteger(String aKey, Integer aDefault) {
        Integer lResult;
        try {
            lResult = mData.getInt(aKey);
        } catch (JSONException lEx) {
            lResult = aDefault;
        }
        return lResult;
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public Integer getInteger(String aKey) {
        return getInteger(aKey, null);
    }

    @Override
    public void setInteger(String aKey, Integer aValue) {
        try {
            mData.put(aKey, aValue);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public Long getLong(String aKey, Long aDefault) {
        Long lResult;
        try {
            lResult = mData.getLong(aKey);
        } catch (JSONException lEx) {
            lResult = aDefault;
        }
        return lResult;
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public Long getLong(String aKey) {
        return getLong(aKey, null);
    }

    @Override
    public void setLong(String aKey, Long aValue) {
        try {
            mData.put(aKey, aValue);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public Double getDouble(String aKey, Double aDefault) {
        Double lResult;
        try {
            lResult = mData.getDouble(aKey);
        } catch (JSONException lEx) {
            lResult = aDefault;
        }
        return lResult;
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public Double getDouble(String aKey) {
        return getDouble(aKey, null);
    }

    @Override
    public void setDouble(String aKey, Double aValue) {
        try {
            mData.put(aKey, aValue);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public Boolean getBoolean(String aKey, Boolean aDefault) {
        Boolean lResult;
        try {
            lResult = mData.getBoolean(aKey);
        } catch (JSONException lEx) {
            lResult = aDefault;
        }
        return lResult;
    }

    /**
     *
     * @param aArg
     * @return
     */
    @Override
    public Boolean getBoolean(String aArg) {
        return getBoolean(aArg, null);
    }

    /**
     *
     * @param aKey
     */
    @Override
    public void setBoolean(String aKey, Boolean aValue) {
        try {
            mData.put(aKey, aValue);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public List getList(String aKey, List aDefault) {
        // TODO: Implement this
        return null;
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public List getList(String aKey) {
        // TODO: Implement this
        return null;
    }

    /**
     *
     * @param aKey
     * @param aList
     */
    @Override
    public void setList(String aKey, List aList) {
        try {
            mData.put(aKey, aList);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @param aKey
     * @param aTokenizable
     */
    @Override
    public void setToken(String aKey, ITokenizable aTokenizable) {
    }

    /**
     *
     * @param aKey
     * @param aToken
     */
    @Override
    public void setToken(String aKey, Token aToken) {
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public Token getToken(String aKey) {
        return null;
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public Token getToken(String aKey, Token aDefault) {
        return null;
    }

    /**
     *
     * @param aKey
     * @param aDefault
     * @return
     */
    @Override
    public Map getMap(String aKey, Map aDefault) {
        // TODO: Implement this
        return null;
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public Map getMap(String aKey) {
        Map lMap = new FastMap<String, Object>();
        Iterator<String> lIterator = mData.keys();
        while (lIterator.hasNext()) {
            String lKey = (String) lIterator.next();
            try {
                Object lVal = mData.get(lKey);
                lMap.put(lKey, lVal);
            } catch (JSONException lEx) {
                // TODO: process exception
            }
        }
        return lMap;
    }

    /**
     *
     * @param aKey
     */
    @Override
    public void setMap(String aKey, Map aMap) {
        try {
            mData.put(aKey, aMap);
        } catch (JSONException lEx) {
            // TODO: handle exception
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return mData.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<String> getKeyIterator() {
        return mData.keys();
    }

    /**
     *
     * @param aKey
     * @return
     */
    @Override
    public Object getObject(String aKey) {
        Object lObj = null;
        try {
            lObj = mData.get(aKey);
        } catch (JSONException lEx) {
            // 
        }
        return lObj;
    }
}
