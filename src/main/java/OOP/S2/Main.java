package OOP.S2;

public class Main {
    public static void main(String[] args) {
        Move[] members = {new Human("Ivan", 1000, 300),
                new Human("Max", 6000, 100),
                new Cat("Ben", 1500, 50),
                new Cat("Sem", 900, 50),
                new Robot("10000", 45500, 600),
                new Robot("3000", 4500, 400)};


        Wall wall = new Wall(150);
        Treadmill tread = new Treadmill(3000);


        for (Move mem : members) {

            mem.run(tread);
            mem.climb(wall);
        }
    }
}
