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

        Store shop = new Store();
        shop.setProduct(apple, 10.0);
        shop.setProduct(banana, 4.0);
        shop.setProduct(shrimp, 15.0);
        shop.printAssortment();


        User irina = new User("Irina", "1234rewq", shop);
        User alex = new User("Alex", "1234rewq", shop);

        System.out.println("alex basket = " + alex.getMybasket());

        alex.putToMybasket(apple, 1.5);
        System.out.println("alex basket = " + alex.getMybasket());

        shop.printAssortment();
        alex.putToMybasket(shrimp, 20.0);
        alex.delFromMyBasket(apple, 2.0);
        alex.putToMybasket(banana, 2.0);
        alex.delFromMyBasket(banana, 0.5);

        System.out.println("alex.getMybasket() = " + alex.getMybasket());
        shop.printAssortment();


    }
}
