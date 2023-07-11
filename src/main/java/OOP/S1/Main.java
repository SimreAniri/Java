package OOP.S1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Category fruits = new Category("Fruits", new String[]{"apple", "banana"});
        Category vegetables = new Category("Vegetables", new String[]{"tomato", "cucumber"});
        Category seafood = new Category("Seafood", new String[]{"shrimp", "squid"});

        Product apple = new Product("Яблоки", 129.8, 9);
        Product banana = new Product("Бананы", 99.8, 8);
        Product shrimp = new Product("Креветки", 559.8, 10);

        User irina = new User("Irina", "1234rewq");
        User alex = new User("Alex", "1234rewq");

        System.out.println("alex basket = " + alex.getMybasket());

        alex.putToMybasket(apple);
        System.out.println("alex basket = " + alex.getMybasket());


    }
}
