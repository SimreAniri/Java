package OOP.S2;

public class Cat implements Move {
    private String name;
    private int maxRunDistanse;
    private int maxClimbHeight;

    static int maxCatRunDistanse = 1000;
    static int maxCatClimbHeight = 100;


    public Cat(String name, int maxRunDistanse, int maxClimbHeight) {
        this.name = name;
        if (maxRunDistanse > maxCatRunDistanse) {
            this.maxRunDistanse = maxCatRunDistanse;
        } else this.maxRunDistanse = maxRunDistanse;
        if (maxClimbHeight > maxCatClimbHeight) {
            this.maxClimbHeight = maxCatClimbHeight;
        } else this.maxClimbHeight = maxClimbHeight;

    }

    @Override
    public void run(Obstacle obs) {
        if (obs.getObstacle() < maxRunDistanse) {
            System.out.println("Кот " + name + " пробегает " + obs.getName());
        } else System.out.println(obs.getName() + " слишком длинная для кота " + name);

    }

    @Override
    public void climb(Obstacle obs) {
        if (obs.getObstacle() < maxClimbHeight) {
            System.out.println("Кот " + name + " перелезает " + obs.getName());
        } else System.out.println(obs.getName() + " слишком высокая для кота " + name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", maxRunDistanse=" + maxRunDistanse +
                ", maxClimbHeight=" + maxClimbHeight +
                '}';
    }
}
