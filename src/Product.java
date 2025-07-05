public class Product implements Shippable {
    private String name;
    private double price;
    private int quantity;
    private boolean expired;
    private ProductType type;
    private boolean shippable;
    private double weight; // in kg

    public Product(String name, double price, int quantity,ProductType productType, boolean expired, boolean shippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = productType;
        this.expired = expired;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean isExpired() {
        if (type == ProductType.NON_EXPIRABLE) return false;
        return expired;
    }
    public boolean isShippable() {
        return shippable;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public double getWeight() {
        if (!shippable) return 0;
        return weight;
    }
}
