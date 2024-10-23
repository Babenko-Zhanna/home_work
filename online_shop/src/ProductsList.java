import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsList {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> productList;
    private List<Product> productsInBasket;

    /*
    public ProductsList(List<Product> productList) {
        this.productList = productList;
    }
    */

    public ProductsList() {
        productList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : productList) {
            sb.append(product).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProductList(List<Product> list) {
        for (Product product : list) {
            productList.add(product);
        }
    }

    public List<Product> addProductToBasket() {
        productsInBasket = new ArrayList<>();

        while (true) {
            System.out.println("Введите номер товара для добавления в корзину (0 для завершения):");
            int number = scanner.nextInt();
            if (number == 0 || number < 0 || number > productList.size()) {
                return productsInBasket;
            }
            productsInBasket.add(productList.get(number - 1));
        }
    }

    private double sumPrice() {
        double result = 0;
        for (Product product : productsInBasket) {
            result += product.getPrice();
        }
        return result;
    }

    public void printBasket() {
        addProductToBasket();

        StringBuilder sb = new StringBuilder();
        sb.append("Ваш список покупок: ").append(System.lineSeparator());
        for (Product product : productsInBasket) {
            sb.append(product.shortString()).append(System.lineSeparator());
        }
        sb.append("Итоговая сумма: ").append(sumPrice()).append(" €").append(System.lineSeparator());


        if (productsInBasket.isEmpty()) {
            System.out.println("Ваша корзина пуста");
            System.out.println("1 - продолжить покупки");
            System.out.println("0 - завершить программу");

            boolean cycle = true;

            while (cycle) {
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        printBasket();
                        cycle = false;
                        break;
                    case 0:
                        System.out.println("До новых встреч!");
                        cycle = false;
                        break;
                    default:
                        System.out.println("Введите 1 или 0");
                        break;
                }
            }

        } else {
            System.out.println(sb);
        }

    }

}
