import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
        System.out.println("Client Running");
        while (true) {
            Socket sock=new Socket("localhost",5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
            BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
            String userInput = userInputBR.readLine();
            out.println(userInput);
            System.out.println("User Input  : " + userInput);
            System.out.println("Server Response : " + br.readLine());

        }
    }
}
