package OOP.S1;

public class Product {
    private String name;
    private Double price;
    private int raiting;

    public Product() {
    }

    public Product(String name, Double price, int raiting) {
        this.name = name;
        this.price = price;
        this.raiting = raiting;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
