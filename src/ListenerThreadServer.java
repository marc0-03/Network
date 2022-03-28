import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a class
 * Created 2021-03-16
 *
 * @author Magnus Silverdal
 */
public class ListenerThreadServer implements Runnable{
    private BufferedReader in;
    private PrintWriter out;

    public ListenerThreadServer(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
            } catch (IOException e) {
                //e.printStackTrace();
            }
            out.println(msg);
            System.out.println(msg);
        }
    }

    public void stop()  {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}