package OOP.S2;

public class Human implements Move {

    private String name;
    private int maxRunDistanse;
    private int maxClimbHeight;

    static int maxHumanRunDistanse = 5000;
    static int maxHumanClimbHeight = 200;


    public Human(String name, int maxRunDistanse, int maxClimbHeight) {
        this.name = name;
        if (maxRunDistanse > maxHumanRunDistanse) {
            this.maxRunDistanse = maxHumanRunDistanse;
        } else this.maxRunDistanse = maxRunDistanse;
        if (maxClimbHeight > maxHumanClimbHeight) {
            this.maxClimbHeight = maxHumanClimbHeight;
        } else this.maxClimbHeight = maxClimbHeight;

    }

    @Override
    public void run(Obstacle obs) {
        if (obs.getObstacle() < maxRunDistanse) {
            System.out.println("Человек " + name + " пробегает " + obs.getName());
        } else System.out.println(obs.getName() + " слишком длинная для человека " + name);

    }

    @Override
    public void climb(Obstacle obs) {
        if (obs.getObstacle() < maxClimbHeight) {
            System.out.println("Человек " + name + " перелезает " + obs.getName());
        } else System.out.println(obs.getName() + " слишком высокая для человека " + name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", maxRunDistanse=" + maxRunDistanse +
                ", maxClimbHeight=" + maxClimbHeight +
                '}';
    }
}
