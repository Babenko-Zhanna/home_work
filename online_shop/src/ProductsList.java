import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsList {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> productList;
    private  List<Product> productsInBasket;

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
        for (int i = 0; i < productList.size(); i++) {
            sb.append(productList.get(i)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public List<Product> addProduct(Product product) {
        productList.add(product);
        return productList;
    }

    public List<Product> addProductList(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            productList.add(list.get(i));
        }
        return productList;
    }

    public List<Product> addProductToBasket () {
        productsInBasket = new ArrayList<>();

        while (true) {
            System.out.println("Введите номер товара для добавления в корзину (0 для завершения):");
            int number = scanner.nextInt();
            if (number==0 || number < 0 || number > productList.size()) {
                return productsInBasket;
            }
            productsInBasket.add(productList.get(number-1));
        }
    }

    private double sumPrice () {
        double result = 0;
        for (int i = 0; i < productsInBasket.size(); i++) {
            result += productsInBasket.get(i).getPrice();
        }
        return result;
    }

    public void printBasket () {
        addProductToBasket();

        StringBuilder sb = new StringBuilder();
        sb.append("Ваш список покупок: ").append(System.lineSeparator());
        for (int i = 0; i < productsInBasket.size(); i++) {
            sb.append(productsInBasket.get(i).shortString()).append(System.lineSeparator());
        }
        sb.append("Итоговая сумма: ").append(sumPrice()).append(" €").append(System.lineSeparator());

        String result = (productsInBasket.isEmpty()) ? "Ваша корзина пуста" : sb.toString(); ;
        System.out.println(result);

    }

}
