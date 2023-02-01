import java.util.TreeSet;

public class Branch extends Bank{
    private int id;
    private String location;
    private int numberOfAccounts;
    private TreeSet<Account> accounts;


    public Branch(int id, String location) {
        this.id = id;
        this.location = location;
        this.numberOfAccounts = 0;
        accounts = new TreeSet<Account>();
    }

    public int getId() {
        return id;
    }

    public void addAcc(Account acc){
        accounts.add(acc);
    }

    public void GetDetials(int id){
        for(Account x: accounts){
            if(x.getId()==id){
                System.out.println("Branch ID - " + id + "\nLocation - " + location );
                x.toString();
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return  "\nBranch :" +
                "\nid - " + id +
                "\nlocation - " + location +
                "\nnumberOfAccounts - " + numberOfAccounts + "\n";
    }
}
