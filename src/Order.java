import java.util.ArrayList;

public class Order {
    private int orderId = 0;
    private Customer customer;
    private ArrayList<MenuItem> Items;
    private double totalAmount;

    Order(Customer customer) {
        this.orderId++;
        this.customer = customer;
    }

    public void addItem(MenuItem item){
        Items.add(item);
    }

    public double calculateTotal() {
        totalAmount = 0;
        for (MenuItem item : Items) {
            totalAmount += item.getPrice();
        }
        totalAmount = customer.getDiscount(totalAmount);
        return totalAmount;
    }

    public String getOrderSummary(){
        String temp =  "Order ID: " + orderId + ", Customer: " + customer.getName()
                + ", Total Amount: " + calculateTotal() + '\n'
                + ", Items: ";

        for (int i = 0; i < Items.size(); i++) {
            temp +=  this.Items.get(i).getName() + (i == Items.size() - 1 ? "" : " - ");
        }

        return temp;
    }
}
