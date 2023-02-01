import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
            //Parameter Selection , BIT Length, P , Q
            int BIT_LENGTH = 2048;
            Random rand = new SecureRandom();
            BigInteger p = BigInteger.probablePrime(BIT_LENGTH / 2, rand);
            BigInteger q = BigInteger.probablePrime(BIT_LENGTH / 2, rand);

            // Calculate Products for Key Generating
            BigInteger n = p.multiply(q);
            System.out.println("Products P x Q : " + n);
            BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            System.out.println("\nProducts (P-1) x (Q-1) : " + phi);

            // Public Key Generation
            BigInteger e;
            do e = new BigInteger(phi.bitLength(), rand);
            while (e.compareTo(BigInteger.ONE) <= 0
                    || e.compareTo(phi) >= 0
                    || !e.gcd(phi).equals(BigInteger.ONE));


            System.out.println("\nPublic Key pair : {" + e + "," + n +"}\n");

            //Private Key Generation
            BigInteger d = e.modInverse(phi);
            System.out.println("Private Key pair : {" + d + "," + n +"}\n");

            String message ="In Java BigInteger is a well suite data type for RSA Encryption." +
                    "It can handle 2048 bit large RSA key pair." +
                    " So It can transmit large cipher text"+
                    " So It can transmit large cipher text";

            AtomicReference<String> msg = new AtomicReference<>("");
            Stream<String> streamOfMessage= Arrays.stream(message.split("")).sequential();
            streamOfMessage.forEach(s->{
               msg.set(msg + String.valueOf(s.hashCode()));
            });
            System.out.println("Numeric values of Text : " + msg.get()+"\n");

            BigInteger encMsg = new BigInteger(String.valueOf(msg)).modPow(e,n);
            System.out.println("Encrypted Text : " + encMsg+"\n");
            BigInteger decMsg = new BigInteger(String.valueOf(encMsg)).modPow(d,n);
            System.out.println("Decrypted Text : " + decMsg+"\n");

            String plainMsg = "";
            System.out.println("\nTotal characters of message : " + message.length());
            System.out.println("\nFinal Bit length of Numeric message : " + new BigInteger(String.valueOf(msg)).bitLength());
            System.out.println("\nFinal Bit length of Encrypted message : " + encMsg.bitLength());
            System.out.println("\nFinal Bit length of Decrypted message : " + decMsg.bitLength());
            for (int i=0;i<decMsg.toString().length();i++){

                int y = Integer.parseInt(String.valueOf(decMsg.toString().charAt(i)));
                if(y==1){
                    int x = Integer.parseInt(decMsg.toString().substring(i,i+3));
                    plainMsg=plainMsg.concat(String.valueOf((char) x));
                    i=i+2;
                }else{
                    int x = Integer.parseInt(decMsg.toString().substring(i,i+2));
                    plainMsg=plainMsg.concat(String.valueOf((char) x));
                    i=i+1;
                }
            }
            System.out.println(plainMsg+"\n");

    }
}