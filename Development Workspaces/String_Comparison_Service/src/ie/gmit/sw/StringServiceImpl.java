package ie.gmit.sw;

import java.rmi.RemoteException;

/**
 * Created by Ross Byrne on 05/12/16.
 * Implementation of StringService interface
 */
public class StringServiceImpl implements StringService {

    // compare the two strings with specified string comparison algorithm
    // returns the result in a Resultator object
    public Resultator compare(String s, String t, String algo) throws RemoteException {

        // compare the strings

        // create Resultator object with result
        Resultator result = new ResultatorImpl();

        // return result object
        return result;

    } // Resultator()

} // class
