import java.util.Comparator;
import java.util.List;

public class ComparatorProductsByName implements Comparator<Product>, SortingOptions {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public void sort(List<Product> productList) {
        productList.sort(new ComparatorProductsByName());
    }

    @Override
    public String getName() {
        return "по алфавиту";
    }
}
