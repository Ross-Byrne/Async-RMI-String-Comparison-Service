# Asynchronous RMI String Comparison Service
4th Year Distributed Systems Project. Written in Java using RMI.

#Technologies Used

Apache Tomcat 9.0.0.M13

#Repository Folder Structure

###Deployment
Contains all of the files used for deploying the application. EG. Tomcat .WAR file and string comparasion .JAR file

###Development Workspaces
Contains IntelliJ Idea projects for the servlet and comparasion service.  
Using IntelliJ IDEA Community Edition V. 2016.3 IDE for development.

###Resources
Folder containing project resources given to complete the project.

#Running Application
Files needed for running the application can be found in the Deployment folder.

###Get Tomcat
Get Tomcat, which can be found here: https://tomcat.apache.org/download-90.cgi

###Run String Service
Run string-service.jar using the folding command
```
java -cp ./string-service.jar ie.gmit.sw.Servant
```
###Add comparator.war to TomCat's webapps folder

###Start Tomcat & Load Website
Start the TomCct server and navigate to the website.<br>
The website can be found at the address localhost:8080/comparator<br>

#How it Works
The project is made up of two components. A servlet that runs in TomCat and a RMI String comparison service that runs independently.

The String Service registers a remote object that can then be looked up and used by the servlet running in Tomcat. Once the servlet starts, it gets a handle on the remote object using the RMI registry lookup.<br>
When a request is sent to the server, the request is added to a request object and put on a queue. This queue is polled by a request processing thread. It checks for requests in the queue and processes them by using the remote String Service object to compare two strings. This returns a Result that is then places on a out queue.<br>
The website then polls the server to see if the result in the out queue is finished being processed by the String Comparison Service.

The String Service contains a compare method. This method creates a result object, adds a new thread to a thread pool and returns the result object. Because the work is being done on a thread, the result object is returned straight away. The new thread uses a factory to get the correct algorithm, runs the algorithm and then flags the result as processed.

###String Comparison Algorithms
The list of implemented string comparison algorithms are as follows:

Hamming Distance.<br>
Levenshtein Distance.<br>
Damerau-Levenshtein Distance.<br>
Jaro-Winkler Distance.<br>
Needleman-Wunsch.<br>
Smith Waterman.

#Other Notes
###The Remote Interfaces
Due to the required submission format, I was unable to put the RMI remote interfaces into their own JAR file. In the project, the same interfaces are in both components. I feel that a better design would be to put the Remote Interfaces into a JAR and distribute the JAR with any component that needs the Remote Interfaces. This would make sure anyone using the RMI String service has the correct version of the Remote Interfaces.

#References
Needleman-Wunsch Java Implementation: https://www.ibm.com/developerworks/library/j-seqalign/<br>
Jaro Winkler Java Implementation: https://github.com/tdebatty/java-string-similarity

