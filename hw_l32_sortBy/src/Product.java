public class Product {
    private String name;
    private double price;
    private double rating;
    private int inStock;

    public Product(String name, double price, double rating, int inStock) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return String.format("%s | цена: %.2f€ | рейтинг: %.1f ☆ | остаток на складе: %d шт.", name, price, rating, inStock);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getInStock() {
        return inStock;
    }
}
