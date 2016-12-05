package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ross Byrne on 05/12/16.
 * Implementation of StringService interface
 */
public class StringServiceImpl extends UnicastRemoteObject implements StringService {

    private static final long serialVersionUID = 1L;
    private Resultator result;

    public StringServiceImpl() throws RemoteException{

    } // contructor()

    // compare the two strings with specified string comparison algorithm
    // returns the result in a Resultator object
    public Resultator compare(String s, String t, String algo) throws RemoteException {

        // insert stringCompareFractory here

        // compare the strings

        // create Resultator object with result
        result = new ResultatorImpl();

        // return result object
        return result;

    } // Resultator()

} // class
