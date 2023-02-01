import java.util.ArrayList;
import java.util.List;

public class NameList {

    public static List<String[]> list=new ArrayList<>();

    public NameList() {
    }

    public void search(String s){
        getval(s);
    }

    public void addVal(String[] k){
        list.add(k);
    }

    public void getval(String s){

        String[] k=s.trim().split(" ");
        String[] x;
        boolean flag=false;


        for(int i=0;i<list.size();i++){

            String y=" ";
            x=list.get(i)[0].split(" ");
            int j=x.length;

            if(k.length<=j){
                for(int l=0;l<k.length;l++){
                   y=y.concat(" ");
                   y=y.concat(x[l]);
                }
                y=y.trim();
            }

            if(y.equalsIgnoreCase(s)){
                System.out.printf("%-25s%15s" , list.get(i)[0] + " " , list.get(i)[1]);
                System.out.println();;
                flag=true;
            }
        }

        if(!flag){
            System.out.println("No contact found.");
        }
    }
}
