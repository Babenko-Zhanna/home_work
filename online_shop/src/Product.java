public class Product {
    private int number;
    private String name;
    private double price;

    public Product(int number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d. %s (%.2f €)", number, name, price);
    }

    public String shortString () {
        return String.format("%s (%.2f €)", name, price);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
