public class MyThread extends Thread {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        Thread x= new Thread(t);
        x.start();
        args.wait();

    }

    public void run(){
        for(int i=0;i<3;i++){
            System.out.print(i + "..");
        }
    }
}
