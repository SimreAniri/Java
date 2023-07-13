package OOP.S2;

public class Treadmill implements Obstacle{
    static int number;
    private String name;
    private int distance;

    public Treadmill(int distance) {
        number++;
        this.name = "Дорожка_" + number;
        this.distance = distance;
    }

    @Override
    public int getObstacle() {
        return distance;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
