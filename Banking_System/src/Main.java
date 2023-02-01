import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    static  int branchcounter = 4000300;
    public static String s;
    public static Bank B=new Bank();


    public static void SetInterest() throws IOException{
        System.out.print("Do you want to Change the Interest Rate From 4.5% ? (Yes/No) : ");
        s=reader.readLine().trim();

        if(s.equalsIgnoreCase("Yes")){
            while (true){
                System.out.print("Enter the Value : ");
                s=reader.readLine();
                if(Double.parseDouble(s)<=0){
                    System.out.println("Invalid");
                    continue;
                }else{
                    B.setInterestRate(Integer.parseInt(s));
                    break;
                }
            }
        }
    }

    public static void assignbranch() throws IOException{
        System.out.println("Enter the Branch Location :");
        s= reader.readLine().trim();

        Branch branchx=new Branch(branchcounter,s);
        branchcounter++;
        B.addBranch(branchx);

        while(true){
            System.out.print("Do you want to add Accounts : (YES/NO) ");
            s=reader.readLine().trim();
            if(s.equalsIgnoreCase("yes")){
                setAccount(branchx);
            }else if(s.equalsIgnoreCase("No")){
                break;
            }
        }
    }

    public static void setAccount(Branch br) throws IOException{
        int id;
        double balance;

        System.out.println("Enter the Account Information :");
        System.out.println("Name : ");
        s=reader.readLine().trim();

        while(true){
            System.out.println("ID : ");
            s =reader.readLine().trim();
            if(s.length()!=6){
                System.out.println(" Invalid ID enter 6 Digit ID  :");continue;
            }else{
                id=Integer.parseInt(s);
                break;
            }
        }

        while(true){
            System.out.println("Name : ");
            balance=Double.parseDouble(reader.readLine().trim());
            if(balance<0){
                System.out.println(" Invalid Balance Can't be negative");continue;
            }else{
                break;
            }
        }

        Account k=new Account(id,s,balance);
        br.addAcc(k);

        System.out.println("Monthly InterestRate : " + k.monthlyInterestRate());
        System.out.println("Monthly InterestRate : " + k.monthlyinterest());

        k.toString();
    }

    public static void main(String[] args)throws IOException {
        SetInterest();

        while(true){

            System.out.println("\nSelect from Following Entries : " + "\nBranch Details : 1 " + "\nAccount Details : 2" + "\nExit Entries : 3");
            s=reader.readLine();

            if(Integer.parseInt(s) != 1 && Integer.parseInt(s) !=2 && Integer.parseInt(s) !=3 ){
                System.out.println("Invalid Selection ");
                continue;
            }else if(Integer.parseInt(s) == 1){
                assignbranch();
            }else if(Integer.parseInt(s) == 2){
                System.out.println("Enter the Branch ID : ");
                s=reader.readLine().trim();
                Branch x = B.GetBranches(Integer.parseInt(s));
                if(x!=null){
                    setAccount(x);
                }else{
                    System.out.println("Invalid ID");
                }
            }else{
                break;
            }
        }

        B.GetAllBranches();
        B.GetBranches(400300);
    }
}
