package OOP.S1;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private HashMap<Product, Double> basket;

    public Basket(HashMap<Product, Double> basket) {
        this.basket = basket;
    }

    public Basket() {
        this.basket = new HashMap<Product, Double>();
    }

    public HashMap<Product, Double> getBasket() {
        return basket;
    }

    public void setBasket(HashMap<Product, Double> basket) {
        this.basket = basket;
    }

    public void putProduct(Product prod, Double count) {
        basket.putIfAbsent(prod, 0.0);
        basket.put(prod, basket.get(prod) + count);
    }

    public boolean delProduct(Product prod, Double count) {
        boolean flag = true;
        if (basket.containsKey(prod)) {
            if (basket.get(prod) < count) {
                System.out.println("В корзине находится меньше товара, чем вы пытаетесь выложить");
                flag = false;
            } else basket.put(prod, basket.get(prod) - count);
        } else {
            System.out.println("Такого товара нет в корзине");
            flag = false;
        }
        return flag;
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return "Корзина пуста";
        }
        return "Basket" + basket;
    }
}
