package OOP.Calculator.Service;

import OOP.Calculator.ComplexNum;

public class ComplexCalculator implements ComplexCalculable {
    private ComplexNum primaryArg;

    public ComplexCalculator(ComplexNum primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(ComplexNum arg) {
        primaryArg.setIm(primaryArg.getIm() + arg.getIm());
        primaryArg.setRe(primaryArg.getRe() + arg.getRe());
        return this;
    }

    @Override
    public Calculable multi(ComplexNum arg) {
        primaryArg.setIm(primaryArg.getRe() * arg.getIm() - primaryArg.getIm() * arg.getRe());
        primaryArg.setRe(primaryArg.getRe() * arg.getRe() - primaryArg.getIm() * arg.getIm());
        return this;
    }

    @Override
    public ComplexNum getResult() {
        return primaryArg;
    }
}
