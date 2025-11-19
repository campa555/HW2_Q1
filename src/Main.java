import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rgen = new Random();

        Customer c1 = Customer.create("Ali", "012312345678", "C001");
        Customer c2 = Customer.create("Sara", "012312345677", "C002");
        Customer c3 = Customer.create("Reza", "012312345676", "C003");
        Customer c4 = Customer.create("Mina", "012312345675", "C004");
        Customer c5 = Customer.create("Hossein", "012312345674","C005");

        Customer[] customers = { c1, c2, c3, c4, c5 };

        Employee chef = Employee.create("Ahmad", "012312345673", "E001", "Chef", 80000, 180);
        Employee accountant = Employee.create("Leila", "012312345672", "e002", "Accountant", 60000, 170);
        Employee waiter = Employee.create("Omid",  "012312345671", "e003", "Waiter", 40000, 165);

        Employee[] employees = { chef, accountant, waiter };

        MenuItem pizza = new Food("Pizza", 1, 370, "fast food", 2, 20);
        MenuItem burger = new Food("Burger", 2, 250, "fast food", 3, 15);
        MenuItem pasta = new Food("Pasta", 3, 350, "fast food", 1, 18);
        MenuItem kebab = new Food("Kebab", 4, 250, "traditional food", 1, 20);
        MenuItem tahChin = new Food("Tahchin", 5, 250, "traditional food", 1, 30);


        MenuItem tea = new Beverage("Tea", 6, 50, "drink", 1, 1);
        MenuItem soda = new Beverage("Soda", 7, 70, "drink", 2, 0);
        MenuItem Coffee = new Beverage("Coffee", 8, 90, "drink", 3, 0);

        MenuItem[] menu = { pizza, burger, pasta, kebab, tahChin, tea, soda, Coffee };

        ArrayList<Order> allOrders = new ArrayList<>();

        for (Customer c : customers) {
            if (c == null) continue;

            for (int i = 0; i < 3; i++) {
                Order order = new Order(c);

                // in each order, number of items are randomly generated
                int n = rgen.nextInt(1, 5);
                for (int j = 0; j < n; j++) {
                    // items in each order are also random
                    order.addItem(menu[rgen.nextInt(menu.length)]);
                }

                allOrders.add(order);
            }
        }

        System.out.println("orders description:");
        for (Order o : allOrders) {
            System.out.println(o.getOrderSummary());
        }

        // at the end print out the most loyal employee
        Customer mostLoyal = customers[0];
        for (Customer c : customers) {
            if (c.getLoyaltyPoints() > mostLoyal.getLoyaltyPoints()) {
                mostLoyal = c;
            }
        }

        System.out.println("\nmost loyalty points:");
        System.out.println(mostLoyal.getInfo());

        System.out.println("\ncustomers info:");
        for (Customer c : customers) {
            if (c != null) {
                System.out.println(c.getInfo());
            }
        }

        System.out.println("\nemployees info:");
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.getInfo());
                System.out.println("salary: " + e.calculateSalary());
            }
        }

        System.out.println("\nmenu items info:");
        for (MenuItem i : menu) {
            System.out.println(i.getDetails());
        }
    }

}
