package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Ross Byrne on 27/11/16.
 * Remote Interface for a remote object related to processing a result.
 */
public interface Resultator extends Remote {

    public String getResult() throws RemoteException;

    public void setResult(String result) throws RemoteException;

    public boolean isProcessed() throws RemoteException;

    public void setProcessed() throws RemoteException;

} // interface
