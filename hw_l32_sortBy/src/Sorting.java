import java.util.Arrays;

public class Sorting {
    private final SortingOptions[] sortingOptions = {
            new ComparatorProductsByName(),
            new ComparatorProductsByPriceIncrease(),
            new ComparatorProductsByPriceDecrease(),
            new ComparatorProductsByRating(),
            new ComparatorProductsByInStock()
    };

    public SortingOptions[] getSortingOptions() {
        return Arrays.copyOf(sortingOptions, sortingOptions.length);
    }
}
