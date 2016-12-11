Readme

Link to the GitHub repository: https://github.com/Ross-Byrne/Async-RMI-String-Comparison-Service

#################################
#Running Application

#Get Tomcat, which can be found here: https://tomcat.apache.org/download-90.cgi

#Run String Service

#Run string-service.jar using the following command:

java -cp ./string-service.jar ie.gmit.sw.Servant

#Add comparator.war to TomCat's webapps folder

#################################
Start Tomcat & Load Website

Start the TomCct server and navigate to the website.
The website can be found at the address localhost:8080/comparator

#################################
#How it Works

The project is made up of two components. A servlet that runs in TomCat and a RMI String comparison service that runs independently.

The String Service registers a remote object that can then be looked up and used by the servlet running in Tomcat. Once the servlet starts, it gets a handle on the remote object using the RMI registry lookup.
When a request is sent to the server, the request is added to a request object and put on a queue. This queue is polled by a request processing thread. It checks for requests in the queue and processes them by using the remote String Service object to compare two strings. This returns a Result that is then places on a out queue.
The website then polls the server to see if the result in the out queue is finished being processed by the String Comparison Service.

The String Service contains a compare method. This method creates a result object, adds a new thread to a thread pool and returns the result object. Because the work is being done on a thread, the result object is returned straight away. The new thread uses a factory to get the correct algorithm, runs the algorithm and then flags the result as processed.

#################################
#String Comparison Algorithms

The list of implemented string comparison algorithms are as follows:

Hamming Distance.
Levenshtein Distance.
Damerau-Levenshtein Distance.
Jaro-Winkler Distance.
Needleman-Wunsch.
Smith Waterman.

#################################
#Other Notes

#The Remote Interfaces

Due to the required submission format, I was unable to put the RMI remote interfaces into their own JAR file. In the project, the same interfaces are in both components. I feel that a better design would be to put the Remote Interfaces into a JAR and distribute the JAR with any component that needs the Remote Interfaces. This would make sure anyone using the RMI String service has the correct version of the Remote Interfaces.

#################################
#References

Needleman-Wunsch Java Implementation: https://www.ibm.com/developerworks/library/j-seqalign/
Jaro Winkler Java Implementation: https://github.com/tdebatty/java-string-similarity



