public class Manager extends Employee {
    private double bonus;
    public Staff[] team;
    public int level;


    public Manager(String name,int age,double salary,double bonus,int level){
        super(name,age,salary);
        this.bonus=bonus;
        Staff[] team=new Staff[0];
        this.level=level;
    }

    public void addStaff(Staff staff){
        int i=team.length;
        Staff[] temp=new Staff[i+1];

        for(int j=0;j<i;j++){
            team[j]=temp[j];
        }
        temp[i]=staff;

        this.team=temp;
    }

    public void setBonus(double name){
        this.bonus=bonus;
    }

    public double getbonus(){
        return bonus;
    }


    public double getsalary(){
        return salary;
    }

    @Override
    public Boolean equals(Object O){
        if(this.equals(O)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){


    }


}
