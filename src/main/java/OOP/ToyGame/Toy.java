package OOP.ToyGame;

public class Toy {
    private int id;
    private String name;
    private double probability;

    public Toy(int id, String name, double probability) {
        this.id = id;
        this.name = name;
        this.probability = probability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getProbability() {
        return probability;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", probability=" + probability +
                '}';
    }
}
