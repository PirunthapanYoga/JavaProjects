import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerBreak extends Thread {

    static String br = "break";

    public static void main(String[] args) throws IOException {
        ServerBreak cli = new ServerBreak();
        cli.start();
    }

    public void run() {
        Socket s;
        try {

            s = new Socket("localhost", 6666);
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());

            dataOutputStream.writeUTF(br);
            dataOutputStream.flush();
            dataOutputStream.close();
            dataInputStream.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

