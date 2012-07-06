//  ---------------------------------------------------------------------------
//  jWebSocket - IBasicStorage
//  Copyright (c) 2010 Innotrade GmbH, jWebSocket.org
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
package org.jwebsocket.api;

import java.util.Collection;
import java.util.Map;

/**
 * A storage is a named key/value list. This is the basic interface for all 
 * higher level implementations and persistence engines, like EhCache or MongoDB
 * 
 * @param <K> 
 * @param <V> 
 * @author kyberneees, aschulze
 */
public interface IBasicStorage<K, V> extends Map<K, V>, IInitializable {

    /**
     * 
     * @return the IBasicStorage name
     */
    String getName();

    /**
     * 
     * @param aName the IBasicStorage name to set
     * @throws Exception
     */
    void setName(String aName) throws Exception;

    /**
     * 
     * @param aKeys
     * @return 
     */
    Map<K, V> getAll(Collection<K> aKeys);
}
