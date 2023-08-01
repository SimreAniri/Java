package OOP.Calculator;

public class IntCalculableFactory<Integer> implements ICalculableFactory<Integer> {
    public Calculable<Integer> create(Integer primaryArg) {
        return new Calculator(((Number) primaryArg));
    }
}
