package OOP.Calculator;

public class ComplexNum {
    private double re;
    private double im;

    public ComplexNum(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public String toString() {
        return re + " + " + im + "i";
    }
}
