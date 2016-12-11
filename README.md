# Asynchronous RMI String Comparison Service
4th Year Distributed Systems Project. Written in Java using RMI.

#Technologies Used

Apache TomCat 9.0.0.M13

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

###Get TomCat
Get TomCat, which can be found here: https://tomcat.apache.org/download-90.cgi

###Add comparator.war to TomCat's webapps folder

###Run String Service
Run string-service.jar using the folding command
```
java –cp ./string-service.jar ie.gmit.sw.Servant
```
###Start TomCat & Load Website
Start the TomCat server and navigate to the website.<br>
The website can be found at the address localhost:8080/comparator<br>

