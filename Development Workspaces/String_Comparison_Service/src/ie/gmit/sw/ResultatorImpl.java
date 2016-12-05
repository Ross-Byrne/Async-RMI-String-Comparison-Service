package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;

/**
 * Created by Ross Byrne on 05/12/16.
 * Implementation of Resultator interface
 */
public class ResultatorImpl extends UnicastRemoteObject implements Resultator {

    private static final long serialVersionUID = 1L;
    private boolean isProcessed;
    private String result;

    public ResultatorImpl() throws RemoteException {

    } // contructor()

    // returns the result of the string comparison
    public String getResult() throws RemoteException {

        // return the result string
        return this.result;

    } // getResult()

    // sets the result of the string comparison
    public void setResult(String result) throws RemoteException {

        // set the value of the result string
        this.result = result;

    } // setResult()

    // returns boolean indicating whether the result is processed or not
    public boolean isProcessed() throws RemoteException {

        // return isProcessed
        return isProcessed;

    } // isProcessed()

    // sets the boolean indicating if the result is processed or not
    public void setProcessed() throws RemoteException {

        // flag the resultator object as being processed
        this.isProcessed = true;

    } // setProcessed()

} // class
