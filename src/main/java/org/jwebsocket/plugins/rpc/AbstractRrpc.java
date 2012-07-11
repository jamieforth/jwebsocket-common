package org.jwebsocket.plugins.rpc;

import java.util.List;
import javolution.util.FastList;
import org.jwebsocket.token.Token;

/**
 * Class used to call a Rrpc method (S2C)
 * Example: new Rrpc.Call("aClass", "aMethod").send("hello", "it's a rrpc call", 123).from(aConnector).to(anotherConnector)
 *       or new Rrpc.Call("aClass", "aMethod").send(SomethingToSend).to(anotherConnector) (in this case, the sender will be the server)
 * @author Quentin Ambard
 */
public abstract class AbstractRrpc extends AbstractRpc{
    //private String mConnectorIdFrom = null;
    protected List<String> mConnectorsIdTo ;
    
    public AbstractRrpc (String aClassname, String aMethod) {
        super(aClassname, aMethod);
    }

    public AbstractRrpc (String aClassname, String aMethod, boolean aSpawnTread) {
        super(aClassname, aMethod, aSpawnTread);
    }
    
    /**
     * The token should contains all the necessary informations. 
     * Can be usefull to create a direct call from an already-created token
     * @param aToken
     * @throws RrpcRightNotGrantedException
     * @throws RrpcConnectorNotFoundException
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public AbstractRrpc (Token aToken) {
        super (aToken);
        String lConnectorToId= aToken.getString(CommonRpcPlugin.RRPC_KEY_TARGET_ID);
        to (lConnectorToId);        
    }
        
//    /**
//     * Eventually, the connectorId the rrpc comes from.
//     * If this method is not called during the rrpc, the server will be the source.
//     * @param aConnector
//     */
//    public AbstractRrpc from (String aConnectorId) {
//        mConnectorIdFrom = aConnectorId ; 
//        return this ;
//    }
    
    /**
     * The connectors you want to send the rrpc
     * @param aConnector
     */
    public AbstractRrpc to (List<String> aConnectors) {
        mConnectorsIdTo = aConnectors;
        return this ;
    }
    
    /**
     * A connectorId you want to send the rrpc
     * @param aConnector
     * @throws RrpcConnectorNotFoundException
     */
    public AbstractRrpc to (String aConnectorId) {
        if (mConnectorsIdTo == null) {
            mConnectorsIdTo = new FastList<String>();
        }
        mConnectorsIdTo.add(aConnectorId);    
        return this ;
    }
        
    public Token call () {
        Token lToken = super.call();
        lToken.setType(CommonRpcPlugin.RRPC_TYPE);
        return lToken;
    }
}