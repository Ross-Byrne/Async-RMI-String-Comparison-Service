package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Ross Byrne on 27/11/16.
 * Interface for a String Service that compares strings
 */
public interface StringService extends Remote {

    public Resultator compare(String s, String t, String algo) throws RemoteException;

} // interface
