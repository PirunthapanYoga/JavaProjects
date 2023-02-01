public class Account {
    private int id;
    private String name;
    private double balance;


    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double monthlyInterestRate(){
        return (new Bank()).getInterestRate()/12;
    }

    public double monthlyinterest(){
        return monthlyInterestRate()*balance;
    }

    public void withdraw(int amount){
        if(amount < balance){
            System.out.println("You have Withdrawn "+amount );
            balance-=amount;
        }else{
            System.out.println("Withdrawal failed:no sufficient balance" );
        }
    }

    public void Deposit(int amount){
        if(amount>0){
            balance+=amount;
        }else{
            System.out.println("Deposit value not Acceptable");
        }
    }

    @Override
    public String toString() {
        return  "\nAccount : " +
                "\nid - " + id +
                "\nname - " + name +
                "\nbalance - " + balance + "\n";
    }

}
