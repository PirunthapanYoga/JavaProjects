import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;

public class Database {
    static ArrayList biscuit(){
        ArrayList<Units> Biscuits = new ArrayList<Units>();
        Units MariGold1 = new Units("Marigold","B0001","Maliban",100,100);
        Units MariGold2 = new Units("Marigold","B0002","Maliban",90,100);
        Units MariGold3 = new Units("Marigold","B0003","Maliban",90,100);
        Units MariGold4 = new Units("Marigold","B0004","Maliban",200,100);
        Units MariGold5 = new Units("Marigold","B0005","Maliban",120,100);
        Biscuits.add(MariGold1);
        Biscuits.add(MariGold2);
        Biscuits.add(MariGold3);
        Biscuits.add(MariGold4);
        Biscuits.add(MariGold5);
        return Biscuits;
    }

    static ArrayList Sauce(){
        ArrayList<Units> Sauce = new ArrayList<Units>();
        Units kistKetup1 = new Units("kist Ketup","S0001","Kist",100,100);
        Units kistKetup2 = new Units("kist Ketup","S0002","Kist",90,100);
        Units kistKetup3 = new Units("kist Ketup","S0003","Kist",90,100);
        Units kistKetup4 = new Units("kist Ketup","S0004","Kist",200,100);
        Units kistKetup5 = new Units("kist Ketup","S0005","Kist",120,100);
        Sauce.add(kistKetup1);
        Sauce.add(kistKetup2);
        Sauce.add(kistKetup3);
        Sauce.add(kistKetup4);
        Sauce.add(kistKetup5);
        return Sauce;
    }
}
