public class Part {

    private int partId;
    private String partName;
    private double price;
    private int quantity;

    public Part(int partId, String partName, double price, int quantity) {

        if (price <= 0) {
            throw new IllegalArgumentException("Part price must be greater than zero.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Part quantity must be greater than zero.");
        }

        this.partId = partId;
        this.partName = partName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return partName +
                " | Price: ₹" + price +
                " | Quantity: " + quantity +
                " | Total: ₹" + getTotalPrice();
    }
}
