package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Ross Byrne on 05/12/16.
 * Implementation of StringService interface
 * Service that creates the Resultator object
 * Gets the string comparison algorithm from a singleton factory
 * Starts string comparison in a thread that is submitted to thread pool
 * Returns Resultator straight away (because work is being done in a thread)
 */
public class StringServiceImpl extends UnicastRemoteObject implements StringService {

    private static final long serialVersionUID = 1L;
    private int numberOfThreads = 100;
    private StringComparisonFactory stringFactory;
    private ExecutorService executorService;

    public StringServiceImpl() throws RemoteException{

        // initialise the thread pool
        executorService = Executors.newFixedThreadPool(numberOfThreads);

        // get instance of string comparison factory
        stringFactory = StringComparisonFactory.getInstance();

        System.out.println("String Service has been created");

    } // contructor()

    // compare the two strings with specified string comparison algorithm
    // returns the result in a Resultator object
    public Resultator compare(String s, String t, String algo) throws RemoteException {

        Resultator result = new ResultatorImpl();

        // get string comparison algorithm
        StringComparator comparisonAlgo = stringFactory.getComparisonAlgorithm(algo);

        System.out.println("Submitting string comparison work to thread");

        // create thread and submit it to the executor service
        // this allows for the remote object to be returned before the work is complete
        executorService.submit(new Runnable() {

            public void run() {

                try {

                    // to simulate time, make thread sleep
                    Thread.sleep(3000);

                    // compare the strings
                    result.setResult(comparisonAlgo.preformComparison(s, t));

                    // work is complete, flag it as processed
                    result.setProcessed();

                    System.out.println("Thread finished Work.");

                }catch (Exception ex){

                    ex.printStackTrace();

                } // try

            } // run()
        });

        System.out.println("Returning resultator");

        // return resultator object reference while result is still bring worked on
        return result;

    } // Resultator()

} // class
