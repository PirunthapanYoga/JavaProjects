import java.math.BigInteger;
import java.util.*;

public class main {

    public static Map<Integer,BigInteger> fib=new TreeMap<>();

    public static BigInteger compute(Integer x) {
        return fib.computeIfAbsent(x, e ->{
            if(x==0){
                return BigInteger.valueOf(0);
            }else if(x==1){
                return BigInteger.valueOf(1);
            }else{
                return compute(x-1).add(compute(x-2));
            }
        });
    }

    public static void main(String[] args){

        fib.put(5,(BigInteger.valueOf(5)));
        fib.put(6,(BigInteger.valueOf(8)));

        int x=7;
        compute(x);
        System.out.println(fib.toString());






    }
}
