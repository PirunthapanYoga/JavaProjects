import java.util.Set;
import java.util.TreeSet;

public class Bank {
    private String name;
    private TreeSet<Branch> branches=new TreeSet<Branch>();
    private double interestRate;

    public Bank() {
        name = "Bank of Wakanda";
        interestRate=4.5;
        branches=new TreeSet<Branch>();
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addBranch(Branch branch){
        branches.add(branch);
    }

    public void GetAllBranches(){
        System.out.println("Bank Name - " + name + "\n");
        for(Branch x: branches){
            x.toString();
        }
        System.out.println();
    }

    public Branch GetBranches(int ID){
        for(Branch x: branches){
            if(x.getId()==ID){
                return x;
            }
        }
        return null;
    }
}


