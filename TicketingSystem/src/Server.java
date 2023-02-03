import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Server {
    static void openGate() throws IOException {
        InetAddress receiverAddress = InetAddress.getByName("192.168.1.58");
        byte[] buffer = "Open".getBytes();
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, 42);
        datagramSocket.send(packet);
        datagramSocket.close();
    }

    public static void main(String[] args){
        LinkedList<String> token = new LinkedList<>();
        try{
            while (true){
                ServerSocket ss=new ServerSocket(6666);
                Socket s=ss.accept();//establishes connection
                DataInputStream dis=new DataInputStream(s.getInputStream());
                String  str=(String)dis.readUTF();
                if(str.length()==13){
                    System.out.print("New Token Added From Counter : ");
                    System.out.println(str);
                    token.add(str);
                }else{
                    System.out.print("Request from Platform : ");
                    System.out.println(str);
                    String x = str.split(" ")[1];
                    if(token.contains(x)){
                        openGate();
                    }
                }
                ss.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}