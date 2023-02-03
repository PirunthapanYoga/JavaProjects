import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class Client {
    final static LinkedList<Passanger> passangersInList = new LinkedList<>();

    final static ArrayList<Passanger> passanger = new ArrayList();
    final static Scanner scan =new Scanner(System.in);
    final static String[] places ={"Kankesanthurai","Chunnakam","Jaffna","Kodikamam","Kilinochchi","Ariviyal Nagar","Vavuniya"};
    final static int[] platforms ={4,2,5,2,3,1,4} ; //platform of each station
    final static double[] dfk = {0,9.3,19.3,44.1,88.8,96.4,165.8}; //Distance From Kankesanthurai
    final static double fairFactor = 5.5;
    final static String[] paymentMethod = {"Card Payment" , "Pay by Bills" , "Mobile Paymanet"};

    static double travelDistance(int sourceIndex,int destinationIndex){
        double source = dfk[sourceIndex];
        double destination = dfk[destinationIndex];
        if(source>destination){
            return (source-destination);
        }else{
            return (destination-source);
        }
    }

    static void printDetails(Passanger passanger , float distance){
        System.out.println("\n-----------------------------------------");
        System.out.println("Passenger Name : " + passanger.getName().toUpperCase() +
                "\nID : " + passanger.getId().toUpperCase() +
                "\nCurrent Station : " + passanger.getSource().toUpperCase() +
                "\nPlatform Number : " + passanger.getPlatformNumber() +
                "\nDestination Station: " + passanger.getDestination().toUpperCase() +
                "\nDistance : " + distance +
                "\nTravel Fare: " + passanger.getTravelFare()
        );
    }

    static int getPaymentMethode(){
        int paymentIndex =-999;
        System.out.println("\n-----------------------------------------");
        System.out.print("Are you want to pay Travel fare ? (Yes / No) ");
        String y = scan.next();
        if(y.equalsIgnoreCase("yes")){
            System.out.println("-----------------------------------------");
            System.out.println("|\tPlease select the payment method\t|");
            System.out.println("-----------------------------------------");
            System.out.println("|\tOption Number \t:\tOption\t\t\t|");
            System.out.println("-----------------------------------------");
            for(int i=0 ; i<paymentMethod.length;i++){
                System.out.println("\t\t\t" + i + "\t\t:\t" + paymentMethod[i] );
            }
            System.out.println("-----------------------------------------");
            System.out.print("Please enter the payment option number : ");
            paymentIndex=scan.nextInt();
            scan.nextLine();
            System.out.println("-----------------------------------------");
        }else{
            System.out.println("Thank You");
        }
        return paymentIndex;
    }

    static void Payment(Passanger passanger) {
        System.out.println("-----------------------------------------");
        boolean paymentStatus = false;
        int paymentIndex = getPaymentMethode();
        if(paymentIndex==0){
            System.out.print("Payment of" + " " + passanger.getTravelFare() + " through " + paymentMethod[paymentIndex]);
            System.out.println("\n-----------------------------------------");
            paymentStatus = creditCard();
        }else if(paymentIndex==1){
            System.out.print("Payment of" + " " + passanger.getTravelFare() + " " + paymentMethod[paymentIndex]);
            System.out.println("\n-----------------------------------------");
            paymentStatus = payByBills(passanger);
        }else if(paymentIndex==2){
            System.out.print("Payment of" + " " + passanger.getTravelFare() + " through " + paymentMethod[paymentIndex]);
            System.out.println("\n-----------------------------------------");
            paymentStatus = mobilePayment();
        }
        System.out.println("-----------------------------------------");
        if (paymentStatus){
            generateToken(passanger);
        }

    }

    static void generateToken(Passanger passanger){
        String token = String.valueOf(Calendar.getInstance().getTimeInMillis());
        passanger.setToken(token);
        System.out.println(token);
    }

    static boolean creditCard() {
        System.out.println("Process through payment Portal");
        System.out.println("Payment Successful");
        return true;
    }

    static boolean payByBills(Passanger passanger) {
        System.out.print("PLease enter the amount you placed in the counter : ");
        float billValue= scan.nextFloat();
        scan.nextLine();
        System.out.println("Take your Balance : " + (billValue-passanger.getTravelFare()));
        System.out.println("Payment Successful");
        return true;
    }

    static boolean mobilePayment() {
        System.out.println("Process through payment Portal");
        System.out.println("Payment Successful");
        return true;
    }

    static void sendToken(Passanger passanger){
        try{
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF(passanger.getToken());
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }

    public static void main(String[] args) {
        while(true){
            String name;
            String ID;
            Random random =new Random();
            double distance = 0 ;
            int sourceIndex =random.nextInt(7);
            String source = places[sourceIndex];
            System.out.println("---------------------------------------------------------");
            System.out.println("|\t\tNorthern Railway Ticketing System\t\t\t\t|");
            System.out.println("---------------------------------------------------------");
            System.out.println("\t\tWelcome to the "+ source + " Station\t\t");
            System.out.println("---------------------------------------------------------");
            scan.reset();
            System.out.print("Please Enter Your Name \t: ");
            name =scan.nextLine();
            System.out.print("Please Enter Your ID \t: ");
            ID =scan.nextLine();
            Passanger passanger=new Passanger(name,ID,source);

            while(true){
                int destinationIndex=-999;
                System.out.println("\n-----------------------------------------");
                System.out.println("|\t\t\tStation Details\t\t\t\t|");
                System.out.println("-----------------------------------------");
                System.out.println("|\tStation Number \t:\t Station Name\t|");
                System.out.println("-----------------------------------------");
                for (int i=0;i<places.length;i++){
                    if(!places[i].equalsIgnoreCase(source)){
                        System.out.println("\t\t\t" + i + "\t\t:\t" + places[i] );
                    }
                }
                System.out.println("-----------------------------------------");
                System.out.print("Please Enter the Station Number : ");

                try{
                    destinationIndex = scan.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Invalid Input\n");
                    scan.next();
                    continue;
                }

                if ((destinationIndex < 7 || destinationIndex > 0) & (destinationIndex == sourceIndex) ) {
                    System.out.println("Invalid Selection\n");
                }else{
                    distance = travelDistance(sourceIndex,destinationIndex);
                    passanger.setDestination(places[destinationIndex]);
                    passanger.setPlatformNumber(random.nextInt(platforms[sourceIndex]+1));
                    passanger.setTravelFare((float) (((float) distance)*fairFactor));
                    break;
                }
            }
            printDetails(passanger, (float) distance);
            Payment(passanger);
            sendToken(passanger);
            passangersInList.add(passanger);
        }
    }


}

