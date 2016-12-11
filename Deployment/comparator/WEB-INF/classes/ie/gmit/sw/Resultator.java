package ie.gmit.sw;

import java.rmi.RemoteException;

/**
 * Created by Ross Byrne on 27/11/16.
 * Remote Interface for RMI Service
 */
public interface Resultator {

    public String getResult() throws RemoteException;

    public void setResult(String result) throws RemoteException;

    public boolean isProcessed() throws RemoteException;

    public void setProcessed() throws RemoteException;

} // interface
