# dockerchat
An updated verion of dockerchat, in which after asking for a username, displays that username and the messages sent.

This repo contains programs to implement a multi-threaded TCP chat server and client

* MtClient.java handles keyboard input from the user, storinga username.
* ClientListener.java receives responses from the server and displays them
* MtServer.java listens for client connections and creates a ClientHandler for each new client
* ClientHandler.java receives a username and messages from a client and relays it to the other clients.
* Client.java hold a client class which is then used to for the client and server.


## Identifying Information

 Names:
* Thomas Ogawa
* Alexa Zuch
* Samantha Mondragon

 Student IDs:
* 2370770
* 2369080
* 2406434

 Emails:
* togawa@chapman.edu
* zuch@chapman.edu
* mondragonlanderos@chapman.edu

 Contributions:
* Thomas: Client.java, MtServer.Java, MtClient.Java, ClientHandler.Java
* Alexa: Client.java, MtServer.Java, MtClient.Java, ClientHandler.Java 
* Samantha: README.md, also helped with to oversee progress

 Course:
* CPSC 353
 
 Assignment:
* PA 04 - Chat Submission 3


## Source Files

* Client.java
* ClientHandler.java
* ClientListner.java
* MtClient.java
* MtServer.java
 

## References

* Dr. Fahy's notes/ previous DockerChat

## Known Errors



## Build Insructions

 For Server:
* After moving into the server directory
* javac *.java to compile

 For Client:
* After moving into the client directory
* javac *.java to compile

## Execution Instructions

 For Server:
* java MtServer

 For Client:
* java MtClient

