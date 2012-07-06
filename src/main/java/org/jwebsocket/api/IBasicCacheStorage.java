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

/**
 * Basic storages with simple expiration capability 
 * 
 * @author kyberneees
 */
public interface IBasicCacheStorage<K, V> extends IBasicStorage<K, V> {
    
    /**
     * put a value in the storage and indicate it expiration time 
     * 
     * @param key
     * @param value
     * @param expTime The value expiration time
     */
    public V put(K key, V value, int expTime);
}
