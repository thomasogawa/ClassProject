import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
// import Client.java;

/**
 * MTServer.java
 *
 * <p>This program implements a simple multithreaded chat server.  Every client that
 * connects to the server can broadcast data to all other clients.
 * The server stores an ArrayList of sockets to perform the broadcast.
 *
 * <p>The MTServer uses a ClientHandler whose code is in a separate file.
 * When a client connects, the MTServer starts a ClientHandler in a separate thread
 * to receive messages from the client.
 *
 * <p>To test, start the server first, then start multiple clients and type messages
 * in the client windows.
 *
 */

public class MtServer {
  // Maintain list of all client sockets for broadcast
  private ArrayList<Client> clientList;

  public MtServer() {
    clientList = new ArrayList<Client>();
  }

  private void getConnection() {
    // Wait for a connection from the client
    try {
      System.out.println("Waiting for client connections on port 9002.");
      ServerSocket serverSock = new ServerSocket(9002);
      // This is an infinite loop, the user will have to shut it down
      // using control-c
      while (true) {
        Socket connectionSock = serverSock.accept();
        
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(connectionSock.getInputStream())); //get input
        DataOutputStream clientOutput = new DataOutputStream(connectionSock.getOutputStream());
        String username = "";

        if (clientList.size() == 0) {
          username = "host";
          clientOutput.writeBytes("You are the host!\n");
          clientOutput.writeBytes("Here's a list of host commands:\n");
          clientOutput.writeBytes("Use \"QUESTION\" to ask a question\n");
          clientOutput.writeBytes("Use \"ADD\" to add points to a player\n");
          clientOutput.writeBytes("Use \"SCORES\" to send a the scores of each client to all the clients\n");
        }
        else{
          clientOutput.writeBytes("Enter a username:\n");
          username = clientInput.readLine();
          for (Client c : clientList) {
            if (username.equals(c.username)) {
              clientOutput.writeBytes("Username already taken please enter another: \n");
              username = clientInput.readLine();
              break;
            }
          }
          clientOutput.writeBytes("Succesfully Join Chat Room \n");
          clientOutput.writeBytes("Answer questions to earn points! \n");
        }        

        //Creates client and adds to server
        Client client = new Client(connectionSock, username);
        clientList.add(client);
        clientOutput.writeBytes("All user commands: \n");
        clientOutput.writeBytes("Type \"Who?\" to see users in chat \n");
        clientOutput.writeBytes("Type \"QUIT\" to leave chat \n");
        // Send to ClientHandler the socket and arraylist of all sockets
        ClientHandler handler = new ClientHandler(client, clientList);
        Thread theThread = new Thread(handler);
        theThread.start();
      }
      // Will never get here, but if the above loop is given
      // an exit condition then we'll go ahead and close the socket
      //serverSock.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    MtServer server = new MtServer();
    server.getConnection();
  }
} // MtServer
