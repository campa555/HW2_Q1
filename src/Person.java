public abstract class Person {
    private String name;
    private String phone;

    Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getInfo() {
        return null;
    }

    public void setName(String name) {
        if (name.isEmpty()) return;
        this.name = name;
    }

    public void setPhone(String phone) {
        if (phone.isEmpty()) return;
        for (int i=0; i<phone.length(); i++) {
            if ( !Character.isDigit(phone.charAt(i)) ) return;
        }
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
}

class Customer extends Person {
    private String customerId;
    private int loyaltyPoints;

    private Customer(String name, String phone, String customerId, int loyaltyPoints) {
        super(name, phone);
        this.customerId =  customerId;
        this.loyaltyPoints = loyaltyPoints;
    }

    /*
    this is a cool way to check our input before making an instance of the class
    with invalid information. in this class we defined our constructor method as
    protected method (so we cannot use it directly to create an instance of the class).
    instead, we give input values to another method that first checks input values and
    if input is in the right format, it will generate and return the instance. otherwise
    it will return null.
    (I did a little bit of searching to create such a method but the concept of this
    implementation was in workshop7 documents)
     */
    public Customer create(String name, String phone, String customerId,  int loyaltyPoints) {
        if (name.isEmpty()) {
            System.out.println("Error: Customer name is empty.");
            return null;
        }

        for (int i=0; i<phone.length(); i++) {
            if ( !Character.isDigit(phone.charAt(i)) ) {
                System.out.println("Error: Invalid phone number");
                return null;
            }
        }

        int LoyaltyP = loyaltyPoints;
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative. setting loyalty points to 0");
            LoyaltyP = 0;
        }

        if (customerId.length() != 4){
            System.out.println("Error: Customer id cannot be more than 4 characters.");
            return null;
        }
        else {
            if (customerId.charAt(0) != 'c') {
                System.out.println("Error: invalid customer id.");
                return null;
            }
            else {
                for (int i=1; i<customerId.length(); i++) {
                    if ( !Character.isDigit(customerId.charAt(i)) ) {
                        System.out.println("Error: invalid customer id.");
                        return null;
                    }
                }
            }
        }

        return new Customer(name, phone, customerId, LoyaltyP);
    }

    public void addLoyaltyPoints(double purchase) {
        this.loyaltyPoints += (purchase >= 1000 ? 2 : (purchase >= 500 ? 1 : 0));
    }

    // returns the amount you have to pay based on your loyalty points
    public double getDiscount(double bill) {
        return (loyaltyPoints > 5 ? bill*0.9 : (loyaltyPoints > 3 ? bill*0.95 : bill));
    }

    @Override
    public String getInfo() {
        return "ID: " + customerId + ", Name: " + getName() + ", Phone number: "
                + getPhone() + ", Loyalty points: " + loyaltyPoints;
    }
}