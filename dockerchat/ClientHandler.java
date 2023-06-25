import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
// import Client.java;


/**
 * ClientHandler.java
 *
 * <p>This class handles communication between the client
 * and the server.  It runs in a separate thread but has a
 * link to a common list of sockets to handle broadcast.
 */
public class ClientHandler implements Runnable {
  private Client client = null;
  private ArrayList<Client> clientList;

  ClientHandler(Client newClient, ArrayList<Client> clientList) {
    this.client = newClient;
    this.clientList = clientList;  // Keep reference to master list
  }

  /**
   * received input from a client.
   * sends it to other clients.
   */
  public void run() {
    try {
      System.out.println("Connection made with socket " + client.connectionSock);
      BufferedReader clientInput = new BufferedReader(
          new InputStreamReader(client.connectionSock.getInputStream()));
      while (true) {
        // Get data sent from a client
        String clientText = clientInput.readLine();
        if (clientText != null) {

          // If client types 'QUIT'
          if (clientText.equals("QUIT")) {
            System.out.println("Closing connection for user: " + client.username);
            //Inform other user's client has left
            for (Client c : clientList) {
              if (c.connectionSock != client.connectionSock) {
                DataOutputStream clientOutput = 
                      new DataOutputStream(c.connectionSock.getOutputStream());
                clientOutput.writeBytes(client.username + ": has left chatroom. \n");
              }
            }
            // Remove and close socket connection
            clientList.remove(client);
            client.connectionSock.close();
            break;
          } else if (clientText.equals("Who?")) {
            DataOutputStream clientOutput2 = 
                    new DataOutputStream(client.connectionSock.getOutputStream());
            clientOutput2.writeBytes("List of users online: \n");
            for (Client c : clientList) {
              if (c.connectionSock != client.connectionSock) {
                clientOutput2.writeBytes(c.username + "\n");
              }
            }
          } else if (clientText.equals("ADD") && client.username.equals("host")) {
            DataOutputStream clientOutput3 = 
                    new DataOutputStream(client.connectionSock.getOutputStream());
            clientOutput3.writeBytes("Type name of user to add points to: \n");
            String userTooAddPoints = clientInput.readLine();
            // Check if username is in client list else re-promts
            for (Client c : clientList) { // Something to add the points
              if (c.username.equals(userTooAddPoints)) {
                c.score++;
                clientOutput3.writeBytes("Succesfully added a point to " + c.username + "\n");
              }
            }
          } else if (clientText.equals("SCORES") && client.username.equals("host")) {
            for (Client c : clientList) {
              DataOutputStream clientOutput4 =
                      new DataOutputStream(c.connectionSock.getOutputStream());
              clientOutput4.writeBytes("List of users online and points: \n");
              clientOutput4.writeBytes(c.username + " number of points: " + c.score +  "\n");
            }
          } else if (clientText.equals("QUESTION") && client.username.equals("host")) {
            DataOutputStream clientOutput5 =
                    new DataOutputStream(client.connectionSock.getOutputStream());
            clientOutput5.writeBytes("Enter a question: \n");
            String question = clientInput.readLine();

            for (Client c : clientList) {
              if (!c.username.equals("host")) {
                DataOutputStream clientOutput6 =
                        new DataOutputStream(c.connectionSock.getOutputStream());
                clientOutput6.writeBytes(" The question is: " + question +  "\n");
              }
            }
          } else {
            System.out.println("Received: " + clientText);
            // Turn around and output this data
            // to all other clients except the one
            // that sent us this information
            for (Client c : clientList) {
              if (c.connectionSock != client.connectionSock) {
                DataOutputStream clientOut = 
                        new DataOutputStream(c.connectionSock.getOutputStream());
                clientOut.writeBytes(client.username + ": " + clientText + "\n");
              }
            }
          }

          
        } else {
          // Connection was lost
          System.out.println("Closing connection for socket " + client.connectionSock);
          // Remove from arraylist
          clientList.remove(client);
          client.connectionSock.close();
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
      // Remove from arraylist
      clientList.remove(client);
    }
  }
} // ClientHandler for MtServer.java
