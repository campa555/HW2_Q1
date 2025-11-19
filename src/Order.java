import java.util.ArrayList;

public class Order {
    private static int orderId = 0;
    private Customer customer;
    private ArrayList<MenuItem> items;
    private double totalAmount;

    Order(Customer customer) {
        this.orderId++;
        this.customer = customer;
        this.items = new ArrayList<MenuItem>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public double calculateTotal() {
        totalAmount = 0;
        for (MenuItem item : items) {
            totalAmount += item.getPrice();
        }
        totalAmount = customer.getDiscount(totalAmount);
        customer.addLoyaltyPoints(totalAmount);
        return totalAmount;
    }

    public String getOrderSummary(){
        String temp =  "OrderID: " + orderId + ", Customer: " + customer.getName()
                + ", Total Amount: " + calculateTotal() + '\n'
                + "Items: ";

        for (int i = 0; i < items.size(); i++) {
            temp +=  this.items.get(i).getName() + (i == items.size() - 1 ? "" : " - ");
        }

        return temp;
    }
}
