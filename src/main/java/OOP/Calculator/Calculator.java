package OOP.Calculator;

public final class Calculator<Integer> implements Calculable<Integer> {

    private Integer primaryArg;

    public Calculator(Integer primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable<Integer> sum(Integer arg) {
        return null;
    }

    @Override
    public Calculable<Integer> multi(Integer arg) {
        return null;
    }

    @Override
    public Integer getResult() {
        return primaryArg;
    }
}
