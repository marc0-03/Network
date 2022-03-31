import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverSocketer implements Runnable{
    ArrayList<Socket> Sockets = new ArrayList<Socket>();
    ArrayList<PrintWriter> printWriters = new ArrayList<PrintWriter>();
    private ListenerThreadServer list;
    private Thread server;
    private ArrayList<Thread> Threads = new ArrayList<Thread>();

    ServerSocket serverSocket;

    public serverSocketer(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
        list = new ListenerThreadServer();
        server = new Thread(list);
        server.start();
    }

    @Override
    public void run() {
        Socket socket;
        PrintWriter temp1;
        BufferedReader temp2;
        while (true) {
            try {
                socket = serverSocket.accept();
                temp1 = new PrintWriter(socket.getOutputStream(), true);
                temp2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                list.add(temp2, temp1);
                System.out.println("New user connected");
            } catch (IOException e) {
            }

        }
    }
}
