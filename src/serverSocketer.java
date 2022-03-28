import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverSocketer implements Runnable{
    ArrayList<Socket> Sockets = new ArrayList<Socket>();
    ArrayList<PrintWriter> printWriters = new ArrayList<PrintWriter>();
    ArrayList<ListenerThreadServer> ListenerThreadServers = new ArrayList<ListenerThreadServer>();
    ArrayList<Thread> Threads = new ArrayList<Thread>();

    ServerSocket serverSocket;

    public serverSocketer(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (true) {
            Socket socket1 = null;
            Sockets.add(new Socket());
            try {
                Sockets.get(Sockets.size()) = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
