//    ---------------------------------------------------------------------------
//    jWebSocket - Copyright (c) 2012 jwebsocket.org
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
package org.jwebsocket.api;

/**
 * Provides the getStorage method to obtain a persistence 
 * storage with a given name.
 * @author kyberneees, aschulze
 */
public interface ICacheStorageProvider {

    /**
     * Get a cache storage instance for a giving a name
     * 
     * @param aName 
     * @return The storage instance
     * @throws Exception  
     */
    IBasicCacheStorage<String, Object> getCacheStorage(String aName) throws Exception;

    /**
     * Remove a cache storage from a given name
     * 
     * @param aName
     * @throws Exception 
     */
    void removeCacheStorage(String aName) throws Exception;
}
