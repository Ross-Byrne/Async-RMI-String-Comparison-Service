package ie.gmit.sw;

import java.rmi.registry.*;
import java.rmi.*;

/**
 * Created by Ross Byrne on 05/12/16.
 */
public class StringCompareServer {


    public static void main(String[] args) {

        try {

            //Create an instance of a StringService.
            StringService stringService = new StringServiceImpl();

            //Start the RMI regstry on port 1099
            LocateRegistry.createRegistry(1099);

            //Bind our remote object to the registry with the human-readable name
            Naming.rebind("StringCompareService", stringService);

            //Print a nice message to standard output
            System.out.println("Server ready.");
        }
        catch (Exception ex){

            ex.printStackTrace();

        } // try

    } // main()

} // class
