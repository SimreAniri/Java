package OOP.S2;

public class Robot implements Move {
    private String name;
    private int maxRunDistanse;
    private int maxClimbHeight;

    static int maxRobotRunDistanse = 25000;
    static int maxRobotClimbHeight = 500;


    public Robot(String name, int maxRunDistanse, int maxClimbHeight) {
        this.name = name;
        if (maxRunDistanse > maxRobotRunDistanse) {
            this.maxRunDistanse = maxRobotRunDistanse;
        } else this.maxRunDistanse = maxRunDistanse;
        if (maxClimbHeight > maxRobotClimbHeight) {
            this.maxClimbHeight = maxRobotClimbHeight;
        } else this.maxClimbHeight = maxClimbHeight;

    }

    @Override
    public void run(Obstacle obs) {
        if (obs.getObstacle() < maxRunDistanse) {
            System.out.println("Робот " + name + " пробегает " + obs.getName());
        } else System.out.println(obs.getName() + " слишком длинная для робота " + name);

    }

    @Override
    public void climb(Obstacle obs) {
        if (obs.getObstacle() < maxClimbHeight) {
            System.out.println("Робот " + name + " перелезает " + obs.getName());
        } else System.out.println(obs.getName() + " слишком высокая для робота " + name);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", maxRunDistanse=" + maxRunDistanse +
                ", maxClimbHeight=" + maxClimbHeight +
                '}';
    }
}
