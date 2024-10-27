import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>(List.of(
                new Product("ASKSA Weihnachtskleid", 22.99, 3.5, 15),
                new Product("Numoco Geblümtes Kleid", 107.95, 4.0, 5),
                new Product("Sports Tank", 4.96, 5, 20),
                new Product("Oasis - \"Decca Logo\" T-Shirt", 20.74, 5, 16),
                new Product("Tazzio Damen Skinny Fit High Rise Jeans", 39.90, 4, 11),
                new Product("Pierre Cardin 5-Pocketjeans", 99.99, 5, 2),
                new Product("OG Keemo - Fieber, Hoodie", 65.99, 3.5, 9),
                new Product("Stars & Stripes Westernbluse Dolly", 91.50, 4.5, 2)
        ));

        Sorting sorting = new Sorting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите способ сортировки: ");
        SortingOptions[] options = sorting.getSortingOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + " - " + options[i].getName());
        }

        int selectedSorting = scanner.nextInt();
        if (selectedSorting < 0 || selectedSorting >= options.length) {
            System.out.println("Ошибка ввода");
        } else {
            options[selectedSorting].sort(productList);
            print(productList);
        }

    }

    public static void print (List<Product> list) {
        for (Product product : list) {
            System.out.println(product);
        }
    }
}