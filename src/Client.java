import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author magnus
 */
public class Client {

    public static void main(String[] args) {
        //String ip = (String) JOptionPane.showInputDialog(null,"IP?\nCould be localhost","Connect to..",JOptionPane.QUESTION_MESSAGE);
        String ip = "localhost";
        int port = 4423;
        //int port = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?\nFor example 4823","Connect to..",JOptionPane.QUESTION_MESSAGE));
        String name = (String) JOptionPane.showInputDialog(null,"Name?","Connect to..",JOptionPane.QUESTION_MESSAGE);
        String id = ""+Math.random();

        Socket socket = null;

        try {
            socket = new Socket(ip,port);
        } catch (IOException e) {
            System.out.println("Client failed to connect");
            System.exit(0);
        }

        // GO
        try {
            Scanner tgb = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ListenerThread in = new ListenerThread(new BufferedReader(new InputStreamReader(socket.getInputStream())), id);
            Thread listener = new Thread(in);
            listener.start();
            boolean run = true;
            System.out.println("Your id is " + id);
            System.out.println("do ['their id'] at the beginning of your message to pm someone");
            while (run) {
                String msg;
                msg = tgb.nextLine();

                    out.println(name + ": " + msg);

            }

            out.close();
            socket.close();
            System.out.println("Done!");
        } catch (Exception e) {
            System.out.println("Client failed to communicate");
        }
    }
}