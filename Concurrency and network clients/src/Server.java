import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class Server extends Thread {

    public static ConcurrentHashMap<String, AtomicInteger> map=new ConcurrentHashMap<>();
    private static boolean br = true;
    private Socket s;

    public Server(Socket s) {
        this.s = s;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);

        while (br) {
            Socket s = ss.accept();
            Server svr = new Server(s);
            svr.start();
        }
    }

    public void run() {
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        try {

            dataInputStream = new DataInputStream(s.getInputStream());
            dataOutputStream = new DataOutputStream(s.getOutputStream());
            String str = dataInputStream.readUTF();
            if (str.equals("break")) {
                br = false;
            }
            assign(str, dataOutputStream);
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void assign(String str, DataOutputStream dataOutputStream) throws IOException {
        if (!map.containsKey(str.toLowerCase())) {
            map.put(str.toLowerCase(), new AtomicInteger(1));
        } else {
            map.replace(str.toLowerCase(),new AtomicInteger(map.get(str).incrementAndGet()));
        }
        AtomicInteger x= map.get(str);
        System.out.println("Input Message : " + " " + str + " " + x);
        dataOutputStream.writeUTF(str.toUpperCase() + "\t\t" + "Count : " + x);
    }
}
