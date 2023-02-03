import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {


    public static void main(String[] args) throws IOException {
        System.out.println("Server Running");
        ServerSocket serverSocket = new ServerSocket(5000);
        BufferedReader br;
        PrintWriter out;
        try (Socket socket = serverSocket.accept()) {
            while(true){
                System.out.println("Server Running");
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = br.readLine();
                System.out.println("Input is : " + br.readLine());
                out = new PrintWriter(socket.getOutputStream(), true);
                out.write(str.toUpperCase());
                out.flush();
            }
        }catch(Exception e){
            System.out.println("Not Connected");
        }

    }
}
