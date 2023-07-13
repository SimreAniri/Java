package OOP.S2;

public class Wall implements Obstacle{
    static int number;
    private String name;
    private int height;

    public Wall(int height) {
        number++;
        this.name = "Стена_" + number;
        this.height = height;
    }

    @Override
    public int getObstacle() {
        return height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
