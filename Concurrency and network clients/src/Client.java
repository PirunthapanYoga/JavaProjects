import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {

    static String[] str = "this is my java socket program with concurrency. this site is the client site".split(" ");
    int counter;

    public Client(int i) {
        this.counter = i;
    }

    public static void main(String[] args) throws IOException {
        int x = 0;
        while (x < 14) {
            Client cli = new Client(x);
            x++;
            cli.start();
        }

    }

    public void run() {
        Socket s;
        try {

            s = new Socket("localhost", 6666);
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());

            dataOutputStream.writeUTF(str[counter]);
            String str = dataInputStream.readUTF();
            String[] st = str.split("\t\t");

            System.out.printf("%-15s %10s %n", st[0], st[1]);

            dataOutputStream.flush();
            dataOutputStream.close();
            dataInputStream.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
