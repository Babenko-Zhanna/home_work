import java.util.Comparator;
import java.util.List;

public class ComparatorProductsByInStock implements Comparator<Product>, SortingOptions {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getInStock() - o2.getInStock();
    }

    @Override
    public void sort(List<Product> productList) {
        productList.sort(new ComparatorProductsByInStock().reversed().thenComparing(new ComparatorProductsByName()));
    }

    @Override
    public String getName() {
        return "по количеству на складе";
    }
}
