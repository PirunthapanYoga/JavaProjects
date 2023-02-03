import java.util.Date;

public class Units {
    String name;
    String itemNumber;
    String companyName;
    int quantity;
    int unitPrice;
    Date manufactureDate=null;
    Date ExpireDate=null;

    public Units(String name, String itemNumber, String companyName, int quantity, int unitPrice) {
        this.name = name;
        this.itemNumber = itemNumber;
        this.companyName = companyName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Units(String name, String itemNumber, int quantity, int unitPrice) {
        this.name = name;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        ExpireDate = expireDate;
    }
}
