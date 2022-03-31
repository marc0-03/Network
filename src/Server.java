import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author magnus
 */
public class Server {
    public static void main(String[] args){
        int port = 5884;
        boolean run = true;
        ServerSocket serverSocket;
        Socket socket1;
        Socket socket2;
        System.out.println("Server started.");

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for connections!");
                serverSocketer serv = new serverSocketer(serverSocket);

                Thread listener = new Thread(serv);
                listener.start();
                /*
                socket1 = serverSocket.accept();
                socket2 = serverSocket.accept();
                // Go
                PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
                PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);

                ListenerThreadServer in1 = new ListenerThreadServer(new BufferedReader(new InputStreamReader(socket1.getInputStream())), out2);
                ListenerThreadServer in2 = new ListenerThreadServer(new BufferedReader(new InputStreamReader(socket2.getInputStream())), out1);

                Thread listener1 = new Thread(in1);
                Thread listener2 = new Thread(in2);

                listener1.start();
                listener2.start();
                 */

                System.out.println("Client connected!");
                //Protocol
                while (run) {

                }
                /*
                out1.close();
                out2.close();
                socket1.close();
                socket2.close();
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server fail");
        }
    }
}