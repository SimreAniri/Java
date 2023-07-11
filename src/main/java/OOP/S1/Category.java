package OOP.S1;

import java.util.ArrayList;

public class Category {
    private String name;
    private String[] productsList;

    public Category() {
    }

    public Category(String name, String[] productsList) {
        this.name = name;
        this.productsList = productsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductsList(String[] productsList) {
        this.productsList = productsList;
    }

    public String getName() {
        return name;
    }

    public String[] getProductsList() {
        return productsList;
    }
}
