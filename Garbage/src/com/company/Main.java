package com.company;


public class Main {

        String message;

        public Main(String msg){
            this.message=msg;
        }

        public void display() {
            print(this.message);
        }

        public void print(String message){
            Main msg =new Main("The message : " + message);
        }



    public static void main(String[] args) {
	    Main msg_1 = new Main("SC1");
        Main msg_2 = new Main("SC1");
        msg_1 =msg_2;
        msg_1.display();
        Main msg_3=new Main("SC#").display;
        msg_1 =null;
        System.gc();
    }

    public void finalize(){
        System.out.println("'" + this.message+"'"+"successfully garbage collected");
    }
}
