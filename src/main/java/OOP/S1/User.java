package OOP.S1;

public class User {
    private String login;
    private String password;
    private Basket mybasket;

    private Store shop;

    public User(String login, String password, Store shop) {
        this.login = login;
        this.password = password;
        this.mybasket = new Basket();
        this.shop = shop;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getMybasket() {
        return mybasket;
    }

    public void setMybasket(Basket mybasket) {
        this.mybasket = mybasket;
    }

    public void putToMybasket(Product prod, Double count) {
        if (shop.getProduct(prod, count)) {
            mybasket.putProduct(prod, count);
        }
    }

    public void delFromMyBasket(Product prod, Double count) {
        if (mybasket.delProduct(prod, count)) {
            shop.returnProduct(prod, count);
        }
    }
}
