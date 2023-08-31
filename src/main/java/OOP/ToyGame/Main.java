package OOP.ToyGame;

public class Main {
    public static void main(String[] args) {
        ToyPool myPool = new ToyPool();

        try {
            myPool.addToys("C:\\Ирина\\Java\\My_HW\\src\\main\\java\\OOP\\ToyGame\\my_toy.csv");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("myPool = " + myPool.getPool());

        Game myGame = new Game(myPool, 3);
        myPool = myGame.start();

        System.out.println("myPool = " + myPool.getPool());
    }
}
