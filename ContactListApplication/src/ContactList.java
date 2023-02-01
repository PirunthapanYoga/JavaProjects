import javax.naming.InvalidNameException;
import java.io.*;


public class ContactList {
    public static NumberMap N= new NumberMap();
    public static NameList L=new NameList();

    private static String numberFormat(String s){
        String g=" ";
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){

            if(i==3 || i==6 ){
                g=g.concat("-");
                g=g.concat(String.valueOf(c[i]));
            }else{
                g=g.concat(String.valueOf(c[i]));
            }
        }
        return g.trim();
    }

    private static void search(String name, String number){
        if(!name.equalsIgnoreCase("") || !number.equalsIgnoreCase("")){

            try{
                if(!name.equalsIgnoreCase("")){
                    if(name.replaceAll("[a-zA-Z]","").isEmpty()){
                        System.out.print("Searching for Number of " +name+ " \t\t: ");
                        L.search(name);
                    }else{
                        throw new InvalidNameException();
                    }

                }

                if(!number.equalsIgnoreCase("")){
                    System.out.print("Searching for Name of " +number+ " \t: ");
                    N.search(number);
                }

            } catch (InvalidNameException e) {
                System.out.println("--Invalid Search Name--");
            }


        }else{
            try{
                throw new InsufficientinputExeption("No Input Found");
            }catch(InsufficientinputExeption e){
                e.toString();
            }
        }
    }

    public static void main(String[] args) {

        File input=new File(args[0].trim());
        BufferedReader reader = null;
        String[] k;
        String s;
        try{
            if(!args[0].contains(".txt")){
                throw new InvalidFileNameException("--Invalid File Name--");
            }else{
                reader=new BufferedReader(new FileReader(input));
                while((s=reader.readLine())!=null) {
                    k = s.split(": ");
                    k[0] = k[0].trim();
                    k[1] = k[1].trim();

                    N.addEntry(k);
                    L.addVal(k);
                }
            }

            String name=" ";
            String number=" ";
            int i;

            for(i=1;i<args.length;i++) {
                if (args[i].matches("^[a-zA-Z]*$")) {
                    name = name.concat(" ").concat(args[i]);
                }

                if (args[i].matches("\\d+")) {
                    number = args[i];
                }
            }

            name=name.trim();
            number=number.trim();


            if(number.trim().length()==10){
                number=numberFormat(number.trim());
            }else{
                number="";
                try{
                    throw new InvalidNameException();
                } catch (InvalidNameException e) {
                    System.out.println("--Invalid Search Number--");
                }
            }

            search(name,number);

        } catch (FileNotFoundException | InvalidFileNameException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
