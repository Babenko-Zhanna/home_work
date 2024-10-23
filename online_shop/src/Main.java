import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductsList productsList = new ProductsList();
        productsList.addProduct(new Product(1, "Bounty", 0.75));
        productsList.addProductList(List.of(
                new Product(2, "Salami", 1.99),
                new Product(3, "Mascarpone", 2.50)
        ));
        productsList.addProduct(new Product(4, "Raspberry", 2.99));

        System.out.println("Добрый день! Вы можете заказать следующие товары:");
        System.out.println(productsList);

        productsList.printBasket();

    }
}