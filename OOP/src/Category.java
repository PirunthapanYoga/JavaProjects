import java.util.ArrayList;
import java.util.List;

public class Category {
    String name;
    String ID;
    List<Units> products = new ArrayList<Units>();

    public Category(String name,String ID) {
        this.name = name;
        this.ID = ID;
    }

    public List<Units> getProducts() {
        return products;
    }

    public void setProducts(List<Units> products) {
        this.products = products;
    }
}
