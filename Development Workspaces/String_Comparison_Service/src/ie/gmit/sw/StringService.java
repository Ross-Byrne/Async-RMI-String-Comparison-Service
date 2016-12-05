package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Ross Byrne on 27/11/16.
 */
public interface StringService extends Remote {

    public Resultator compare(String s, String t, String algo) throws RemoteException;

} // interface
