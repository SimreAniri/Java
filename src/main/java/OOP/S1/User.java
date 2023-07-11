package OOP.S1;

public class User {
    private String login;
    private String password;
    private Basket mybasket;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.mybasket = new Basket();
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getMybasket() {
        return mybasket;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void putToMybasket(Product prod) {
        mybasket.put(prod);

    }
}
