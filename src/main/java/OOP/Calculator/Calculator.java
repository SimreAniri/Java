package OOP.Calculator;

public final class Calculator implements NumCalculable {

    private Number primaryArg;

    public Calculator(Number primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(Number arg) {
        primaryArg = (Number) (primaryArg.doubleValue() + arg.doubleValue());
        return this;
    }

    @Override
    public Calculable multi(Number arg) {
        primaryArg = (Number) (primaryArg.doubleValue() * arg.doubleValue());
        return this;
    }

    @Override
    public Number getResult() {
        return primaryArg;
    }
}
