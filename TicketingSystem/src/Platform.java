import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Platform {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String token;
        try{
            while (true){
                System.out.println("---------------------------------------------------------");
                System.out.println("|\t\tNorthern Railway Ticketing System\t\t\t\t|");
                System.out.println("---------------------------------------------------------");
                System.out.print("Please Enter Your Token : ");
                token = scanner.nextLine();
                System.out.println("---------------------------------------------------------");

                String request = "Check " + token;

                Socket s=new Socket("localhost",6666);
                DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                dout.writeUTF(request);
                dout.flush();
                dout.close();
                s.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}
