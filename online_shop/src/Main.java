import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductsList productsList = new ProductsList();

        productsList.addProduct(new Product(1, "Bounty", 0.75));

        productsList.addProductList(List.of(
                new Product(2, "Salami", 1.99),
                new Product(3, "Mascarpone", 2.50),
                new Product(4, "Raspberry", 2.99),
                new Product(5, "Pizza", 3.75),
                new Product(6, "Milk 1L", 1.09),
                new Product(7, "Wholewheat bread", 2.55),
                new Product(8, "Salmon 200g", 4.99)
        ));


        System.out.println("Добрый день! Вы можете заказать следующие товары:");
        System.out.println(productsList);

        productsList.printBasket();

    }
}