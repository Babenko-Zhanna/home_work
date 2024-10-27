import java.util.Comparator;
import java.util.List;

public class ComparatorProductsByPriceIncrease implements Comparator<Product>, SortingOptions {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }

    @Override
    public void sort(List<Product> productList) {
        productList.sort(new ComparatorProductsByPriceIncrease());
    }

    @Override
    public String getName() {
        return "по цене по возрастанию";
    }
}
