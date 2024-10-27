import java.util.Comparator;
import java.util.List;

public class ComparatorProductsByRating implements Comparator<Product>, SortingOptions {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getRating(), o2.getRating());
    }

    @Override
    public void sort(List<Product> productList) {
        productList.sort(new ComparatorProductsByRating().reversed().thenComparing(new ComparatorProductsByName()));
    }

    @Override
    public String getName() {
        return "по рейтингу";
    }
}
