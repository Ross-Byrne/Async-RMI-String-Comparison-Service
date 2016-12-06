package ie.gmit.sw;

import java.rmi.Naming;
import java.util.concurrent.*;

/**
 * Created by Ross Byrne on 06/12/16.
 * Processes the requests sent by the user
 * This includes calling the string comparison service
 */
public class RequestProcesser {

    private int numberOfThreads = 1000;
    private BlockingQueue<Request> inQueue;
    private ConcurrentMap<String, Resultator> outQueue;
    private ExecutorService executorService;
    private StringService stringService;
    private String remoteHost = null;
    private String stringCompareRegName = null;

    public RequestProcesser(String remoteHost, String remoteService){

        this.remoteHost = remoteHost;
        this.stringCompareRegName = remoteService;

        // initialise the inQueue
        inQueue = new LinkedBlockingQueue<Request>();

        // initialise the outQueue
        outQueue = new ConcurrentHashMap<String, Resultator>();

        // initialise thread pool
        executorService = Executors.newFixedThreadPool(numberOfThreads);

        // try to get a handle on remote object
        try {

            // get handle on remote String Comparison Service Object
            stringService = (StringService) Naming.lookup("rmi://" + this.remoteHost + ":1099/" + this.stringCompareRegName);

        } catch (Exception ex){

            // print Stack Trace if exception in thrown
            ex.printStackTrace();

        } // try

        // start service to check queue for results and process them
        processRequests();

    } // contructor()


    // creates a thread to start processing the requests in queue
    public void processRequests(){

        // create thread to start servicing requests in inQueue
        Runnable thread = new Runnable() {

            public void run() {

                boolean doWork = true;

                while(doWork){

                    // take request off inQueue

                    // using stringService to call remote method

                    // add returned resultator to outQueue

                    System.out.println("Work");

                } // while

            } // run()
        }; // runnable()

    } // processRequests


    // add a request to the inQueue
    public void addRequest(Request request){

        // add the request to the in queue
        inQueue.add(request);

    } // addRequest()

    // checks if the task is processed, using taskNumber
    // delegates the resultator method isProcessed
    public boolean isProcessed(String taskNumber){

        // check that the taskNumber is in the map
        if(outQueue.containsKey(taskNumber)){

            // get the resultator for the map
            Resultator r = outQueue.get(taskNumber);

            try { // error handling

                // delegate the method
                return r.isProcessed();

            } catch (Exception ex){

                ex.printStackTrace();

                return false;

            } // try

        } // if

        return false;

    } // isProcessed()

    // gets the result from the resultator in the map
    public String getResult(String taskNumber){

        try{

            // get the resultator from the map
            Resultator r = outQueue.get(taskNumber);

            // delegate resultators method to return result
            return r.getResult();

        } catch(Exception ex){

            // print stack trace
            ex.printStackTrace();

            // return empty string
            return "";

        } // try

    } // getResult


} // class
