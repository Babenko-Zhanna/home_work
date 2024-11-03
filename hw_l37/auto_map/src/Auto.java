import java.util.Objects;

public class Auto {
    private String number;
    private String brand;
    private String color;
    private int year;

    public Auto(String number, String brand, String color, int year) {
        this.number = number;
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d, %s)", number, brand, year, color);
    }

    public String getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auto auto = (Auto) o;
        return year == auto.year && Objects.equals(number, auto.number) && Objects.equals(brand, auto.brand) && Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(number);
        result = 31 * result + Objects.hashCode(brand);
        result = 31 * result + Objects.hashCode(color);
        result = 31 * result + year;
        return result;
    }
}
