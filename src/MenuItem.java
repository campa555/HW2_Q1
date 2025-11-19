public abstract class MenuItem {
    private String name;
    private int itemId;
    private double price;
    private String category;

    public MenuItem(String name, int itemId, double price, String category) {
        this.name = name;
        this.itemId = itemId;
        this.price = price;
        this.category = category;
    }

    public abstract String getDetails();

    public String getName() {
        return name;
    }

    public int getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

class Food extends MenuItem {
    private int spiceLevel; // 1: mild , 2: medium , 3: spicy
    private int preparationTime;

    public Food(String name, int itemId, double price, String category, int spiceLevel, int preparationTime) {
        super(name, itemId, price, category);
        this.spiceLevel = spiceLevel;
        this.preparationTime = preparationTime;
    }

    private String getSpice() {
        return (spiceLevel == 1 ? "mild" : (spiceLevel == 2 ? "medium" : "spicy"));
    }

    @Override
    public String getDetails() {
        return "ID: " + getItemId() + ", Name: " + getName() + ", Price: " + (int)Math.round(getPrice())
                + ", Category: " + getCategory() + ", Spice: " +  getSpice() + ", Preparation Time: " + this.preparationTime + "min";
    }
}


class Beverage extends MenuItem {
    private int size; // 1: small , 2: Medium , 3:Large
    private int temperature; // 0: Cold , 1: Hot

    public Beverage(String name, int itemId, double price, String category, int size, int temperature) {
        super(name, itemId, price, category);
        this.size = size;
        this.temperature = temperature;
    }

    private String getSize() {
        return (size == 1 ? "small" : (size == 2 ? "medium" : "large"));
    }

    private String getTemperature() {
        return (temperature == 0 ? "cold" : "hot");
    }

    @Override
    public String getDetails() {
        return "ID: " + getItemId() + " , Name: " + getName() + " ,Price" + (int)Math.round(getPrice())
                + ", Category: " + getCategory() + ", Size: " + getSize() + ", Temperature: " + getTemperature();
    }
}

