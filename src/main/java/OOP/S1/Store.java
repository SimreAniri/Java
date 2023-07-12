package OOP.S1;

import java.util.HashMap;

public class Store {
    private HashMap<Product, Double> assortment;

    public Store(HashMap<Product, Double> assortment) {
        this.assortment = assortment;
    }

    public Store() {
        assortment = new HashMap<Product, Double>();
    }

    public HashMap<Product, Double> getAssortment() {
        return assortment;
    }

    public void setAssortment(HashMap<Product, Double> assortment) {
        this.assortment = assortment;
    }

    public void setProduct(Product prod, Double count) {
        assortment.putIfAbsent(prod, 0.0);
        assortment.put(prod, assortment.get(prod) + count);
    }

    public boolean getProduct(Product prod, Double count) {
        boolean flaf = true;
        if (assortment.get(prod) < count) {
            System.out.println("Товар закончился");
            flaf = false;
        } else assortment.put(prod, assortment.get(prod) - count);

        return flaf;
    }

    public void returnProduct(Product prod, Double count) {
        assortment.put(prod, assortment.get(prod) + count);
    }

    public void printAssortment() {
        for (var item : assortment.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }
}
