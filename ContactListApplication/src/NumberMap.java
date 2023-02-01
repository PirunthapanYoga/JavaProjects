import java.util.Map;
import java.util.TreeMap;

public class NumberMap {

    public static Map<String, Node> listM = new TreeMap<>();

    public NumberMap() {
    }

    public void addEntry(String k[]){
        try{
            if(listM.containsKey(k[1])){
                Node n=listM.get(k[1]);
                n.setDuplicate();
                listM.replace(k[1],n);
                System.out.println(k[1]);
                throw new InputDupllicateNumberException("--Input has Duplicate Numbers--");
            }else{
                Node n=new Node(k[0]);
                listM.put(k[1],n);
            }
        }catch(InputDupllicateNumberException e){
            e.toString();
        }

    }

    public void search(String s) {

        try {
            String name=listM.get(s).getName();
            System.out.printf("%-25s%15s" , name + " " , s );
            if(listM.get(s).getDuplicate())
            {
                throw new StoredDataDuplicateNumberException("\t\t--Duplicate Contact Information Found--");
            }
        } catch (StoredDataDuplicateNumberException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e){
            System.out.println("--Name Not Found--");
        }
    }
}
