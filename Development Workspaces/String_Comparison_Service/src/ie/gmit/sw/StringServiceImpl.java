package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Ross Byrne on 05/12/16.
 * Implementation of StringService interface
 */
public class StringServiceImpl extends UnicastRemoteObject implements StringService {

    private static final long serialVersionUID = 1L;
    private int numberOfThreads = 100;
    private Resultator result;
    private ExecutorService service;

    public StringServiceImpl() throws RemoteException{

        // initialise the thread pool
        service = Executors.newFixedThreadPool(numberOfThreads);

    } // contructor()

    // compare the two strings with specified string comparison algorithm
    // returns the result in a Resultator object
    public Resultator compare(String s, String t, String algo) throws RemoteException {

        // insert stringCompareFractory here

        // compare the strings

        // create Resultator object with result
        result = new ResultatorImpl();

        result.setResult("Hello");

        // return result object
        return result;

    } // Resultator()

} // class
