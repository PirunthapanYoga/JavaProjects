import java.lang.Thread;
public class main {


    public static void main(String[] args){
                Thread t=new Thread();
                t.start();

                t.run();
    }

    public static void t(){
        System.out.println("x ");
    }
}
