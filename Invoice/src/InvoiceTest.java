public class InvoiceTest {

    public static void main(String[] args) {
        Invoice I1 = new Invoice("AMD Ryzen 9 3950x",
                "Core/Thread 16/32 , Base Clock 3.5Ghz , Boost Clock 4.7",
                10,
                650.00);
        System.out.println("Number : " + I1.getNumber());
        System.out.println("Description : " + I1.getDescription());
        System.out.println("Quantity_Of_The_Item_Being_Purchased : " + I1.getQuantityOfTheItemBeingPurchased());
        System.out.println("Price_per_item : " + I1.getPricePerItem());
        System.out.println("Total_Amount : " + I1.getInvoiceAmount());

        System.out.println("\n\nUpdated....");

        I1.setPricePerItem(-12.00);
        System.out.println("Total_Amount : " + I1.getInvoiceAmount());
        I1.setQuantityOfTheItemBeingPurchased(-2);
        System.out.println("Total_Amount : " + I1.getInvoiceAmount());

        System.out.println("\n\nUpdated....");

        I1.setNumber("AMD RYZEN 9 3950X");
        I1.setDescription("AMD ZEN 2 Processor with 16 cores/32 threads ");
        I1.setQuantityOfTheItemBeingPurchased(5);
        I1.setPricePerItem(749.00);
        System.out.println("Number : " + I1.getNumber());
        System.out.println("Description : " + I1.getDescription());
        System.out.println("Quantity_Of_The_Item_Being_Purchased : " + I1.getQuantityOfTheItemBeingPurchased());
        System.out.println("Price_per_item : " + I1.getPricePerItem());
        System.out.println("Total_Amount : " + I1.getInvoiceAmount());




    }
}
