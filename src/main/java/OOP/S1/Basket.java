package OOP.S1;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket;

    public Basket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    public Basket() {
        this.basket = new ArrayList<Product>();
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void put(Product prod) {
        this.basket.add(prod);
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return "Корзина пуста";
        }
        return "Basket" + basket;
    }
}
