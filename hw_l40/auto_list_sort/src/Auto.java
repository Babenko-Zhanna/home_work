import java.math.BigDecimal;

public class Auto {
    private static int counter = 0;
    private int id;
    private String brand;
    private int year;
    private BigDecimal price;

    public Auto(String brand, int year, BigDecimal price) {
        id = ++counter;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Auto %d: %s %d (%s)", id, brand, year, price);
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
