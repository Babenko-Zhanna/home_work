import java.util.List;

public class ComparatorProductsByPriceDecrease extends ComparatorProductsByPriceIncrease {
    @Override
    public void sort(List<Product> productList) {
        productList.sort(new ComparatorProductsByPriceDecrease().reversed());
    }

    @Override
    public String getName() {
        return "по цене по убыванию";
    }
}
