package OOP.Calculator;

public class ComplexCalculableFactory implements ICalculableFactory{

    @Override
    public Calculable create(Object primaryArg) {
        return new ComplexCalculator((ComplexNum) primaryArg);
    }
}
