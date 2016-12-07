package ie.gmit.sw;

import java.rmi.Naming;
import java.util.concurrent.*;

/**
 * Created by Ross Byrne on 06/12/16.
 * Processes the requests sent by the user.
 * This includes calling the string comparison service.
 * Encapsulates Resultator, inQueue, outQueue and RMI Service completely.
 *
 * Initialises in queue and out queue.
 * Gets Remote object from remote string service.
 * Starts thread that continuously pulls requests off the inqeue,
 * calls the remote function compare using request details.
 * this returns Resultator object straight away while the comparison work
 * is being completed in a thread of its own.
 * The Resultator is then added to out queue for requests to check
 * if work on comparison is finished.
 */
public class RequestProcesser {

    private int numberOfThreads = 1;
    private BlockingQueue<Request> inQueue;
    private ConcurrentMap<String, Resultator> outQueue;
    private ExecutorService executorService;
    private StringService stringService;
    private String remoteHost = null;
    private String stringCompareRegName = null;

    public RequestProcesser(String remoteHost, String remoteService){

        // set member variables
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
    private void processRequests(){

        System.out.println("Starting to process requests.");

        // create thread to start servicing requests in inQueue using executorService
        executorService.submit(new Runnable() {

            Request request;
            Resultator resultator;

            public void run() {

                boolean doWork = true;

                // contantly try to take requests off inQueue
                while(doWork){

                    try {
                        // take request off inQueue (take() method is blocking if nothing is on queue)
                        request = inQueue.take();

                        // using stringService to call remote method
                        resultator = stringService.compare(request.getTextS(), request.getTextT(), request.getAlgorithm());

                        // add returned resultator to outQueue
                        outQueue.put(request.getTaskNumber(), resultator);

                        System.out.println("Processed request.");

                    } catch(Exception ex){

                        ex.printStackTrace();
                    } // try
                } // while

            } // run()
        }); // runnable()

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
            // check if task is in map
            if(outQueue.containsKey(taskNumber)) {

                // get the resultator from the map
                Resultator r = outQueue.get(taskNumber);

                // delegate resultators method to return result
                return r.getResult();

            } // if

        } catch(Exception ex){

            // print stack trace
            ex.printStackTrace();

            // return empty string
            return "";

        } // try

        return "";

    } // getResult


} // class
