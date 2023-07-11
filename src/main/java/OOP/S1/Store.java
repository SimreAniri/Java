package OOP.S1;

import java.util.HashMap;

public class Store {
    private HashMap<String, Integer> assortment;

    public Store(HashMap<String, Integer> assortment) {
        this.assortment = assortment;
    }

    public Store() {
    }

    public HashMap<String, Integer> getAssortment() {
        return assortment;
    }

    public void setProduct(String prod, int count) {
        assortment.putIfAbsent(prod,count);
    }

    public void getProduct(String prod, int count) {
        if (assortment.get(prod) <count) System.out.println("Товар закончился");
        else assortment.put(prod, assortment.get(prod) - count);
    }
    public void returnProduct(String prod, int count) {
        assortment.put(prod, assortment.get(prod) + count);
    }
}
