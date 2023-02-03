import java.util.ArrayList;

public class Billing {

    public static void main(String[] args){
        Category Biscuit = new Category("Biscuits","CAT00001");
        Category Sauce = new Category("Sauce","CAT00002");

        Biscuit.setProducts(Database.biscuit());
        Sauce.setProducts(Database.Sauce());

        





    }
}
