package org.jwebsocket.plugins.rpc.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javolution.util.FastList;

@SuppressWarnings("rawtypes")
public class ListConverter<E> {
    private List mList;
    public ListConverter (List aList) {
        mList = aList;
    }
    /**
     * 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<E> convert() throws Exception {
        List<E> lReturnedList = new FastList<E>();
        for (Object lObject : mList) {
            lReturnedList.add((E)lObject); 
        }
        return lReturnedList ;
    }

    /**
     * Convert a list on a specific type.
     * Throw an exception if one of the parameter of the list is not of the right type.
     * For instance convert(List[12,354,21,"az"], Integer) will throw an exception since the list is not only composed of String.
     * Works with list inside list.
     * @return a FastList<aType>
     * @throws Exception if a parameter of the List can't be cast as aType
     * TODO: souldn't throw a generic Exception exception
     */
    @SuppressWarnings("unchecked")
    public static List convert(List aList, Type aType) throws Exception {
        if(aType instanceof ParameterizedType) {
            ParameterizedType lParameterizedType = (ParameterizedType) aType;
            Type[] parameterArgTypes = lParameterizedType.getActualTypeArguments();
            List lReturnedList = new FastList();
            for (Object lObject : aList) {
                //If it's a list inside another list
                if (parameterArgTypes[0] instanceof ParameterizedType ){//&&
                        //parameterArgTypes[0] instanceof List) {
                        //((ParameterizedType) parameterArgTypes[0]).getActualTypeArguments()[0] == List.class) {
                    lReturnedList.add(convert((List)lObject, (ParameterizedType) parameterArgTypes[0]));
                } else {
                    Class parameterArgClass = (Class) parameterArgTypes[0] ;
                    lReturnedList.add(parameterArgClass.cast(lObject));
                }
            }
            return lReturnedList ;
        } else {
            return aList;
        }
    }
}
