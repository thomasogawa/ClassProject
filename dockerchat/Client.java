import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client.java /CHANGE THE REST OF THIS!!!
 * 
 * <p>This program implements a simple multithreaded chat client.  It connects to the
 * server (assumed ti
 * be localhost on port 7654) and starts two threads:
 * one for listening for data sent from the server, and another that waits
 * for the user to type something in that will be sent to the server.
 * Anything sent to the server is broadcast to all clients.
 * 
 * <p>The MTClient uses a ClientListener whose code is in a separate file.
 * The ClientListener runs in a separate thread, recieves messages form the server,
 * and displays them on the screen.
 *  
 * <p>Data received is sent to the output screen, so it is possible that as
 * a user is typing in information a message from the server will be
 * inserted.
 */


public class Client{
    public Socket connectionSock = null;
    public String username = "";
    public int score;

    Client (Socket sock, String username){
        this.connectionSock = sock;
        this.username = username;
        this.score = 0;
    }

}