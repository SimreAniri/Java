package OOP.Calculator.Service;

public class IntCalculableFactory<Integer> implements ICalculableFactory<Integer> {
    public Calculable create(Integer primaryArg) {
        return new Calculator(((Number) primaryArg));
    }
}
