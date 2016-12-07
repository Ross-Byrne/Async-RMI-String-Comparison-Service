package ie.gmit.sw;

import java.rmi.Naming;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Ross Byrne on 05/12/16.
 * Runner class for testing sevlet code without running it in Tomcat
 */
public class TestRunner {


    public static void main(String[] args) {


        try {
            // create connect to StringCompareServer

            //Ask the registry running on localhost and listening in port 1099 for the instannce of
            //the MessageService object that is bound to the RMI registry with the name howdayService.
            StringService ss = (StringService) Naming.lookup("rmi://localhost:1099/StringCompareService");
            System.out.println("Service Object ID=======> " + ss);

            //Make the remote method invocation. This results in the Resultator object being transferred
            //to us over the network in serialized form.
            Resultator result = ss.compare("wefwefwf", "wefwefwfww", "" );

            System.out.println("Resultator Object ID: " + result);

            while(!result.isProcessed()){

                // wait for result to be computed
            }

            //Print out the result from the result object.
            System.out.println(result.getResult());

            // test request processer
            // create RequestProcessor, once created, it will start trying to process requests
           // RequestProcesser requestProcesser = new RequestProcesser("localhost", "StringCompareService");

           // requestProcesser.isProcessed("ewfewf");
        } catch (Exception ex){

            ex.printStackTrace();
        }

    } // main()

} // class
