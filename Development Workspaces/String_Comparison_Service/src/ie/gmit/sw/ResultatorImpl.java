package ie.gmit.sw;

import java.rmi.RemoteException;

/**
 * Created by Ross Byrne on 05/12/16.
 */
public class ResultatorImpl implements Resultator {

    private boolean isProcessed;
    private String result;

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
