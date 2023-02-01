public class Invoice {
    private String number;
    private String description;
    private int quantity_of_the_item_being_purchased;
    private double price_per_item;

    Invoice(String number,String description,int quantity_of_the_item_being_purchased,double price_per_item){
        this.number=number;
        this.description=description;
        this.quantity_of_the_item_being_purchased=quantity_of_the_item_being_purchased;
        this.price_per_item=price_per_item;
    }

    public void setNumber(String number){
        this.number=number;
    }
    public String getNumber(){
        return number;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    public void setQuantityOfTheItemBeingPurchased(int quantity_of_the_item_being_purchased){
        this.quantity_of_the_item_being_purchased=quantity_of_the_item_being_purchased;
    }
    public int getQuantityOfTheItemBeingPurchased(){
        return quantity_of_the_item_being_purchased;
    }

    public void setPricePerItem(double price_per_item){
        this.price_per_item=price_per_item;
    }
    public double getPricePerItem(){
        return price_per_item;
    }

    public double getInvoiceAmount(){
        if(quantity_of_the_item_being_purchased*price_per_item<0){
            return 0;
        }else if(price_per_item<0){
            return 0.0;
        }else {
            return quantity_of_the_item_being_purchased * price_per_item;
        }
    }
}
