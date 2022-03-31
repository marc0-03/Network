import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-03-16
 *
 * @author Magnus Silverdal
 */
public class ListenerThreadServer implements Runnable{
    private ArrayList<PrintWriter> out = new ArrayList<PrintWriter>();
    private ArrayList<BufferedReader> in = new ArrayList<BufferedReader>();


    public ListenerThreadServer(BufferedReader in, PrintWriter out) {
        this.in.add(in);
        this.out.add(out);
    }
    public ListenerThreadServer() {

    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
                try {
                    for (int i = 0; i < in.size(); i++) {
                        System.out.println(i);
                        msg = in.get(i).readLine();
                        for (int x = 0; x < in.size(); x++) {
                            if (i != x) {
                                out.get(x).println(msg);
                            }
                        }
                    }
                    System.out.println(msg);
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
    }

    public void stop()  {
        try {
            for (int i=0; i<in.size(); i++) {
                in.get(i).close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(BufferedReader in, PrintWriter out) {
        this.in.add(in);
        this.out.add(out);
    }
}