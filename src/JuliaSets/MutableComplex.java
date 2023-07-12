package JuliaSets;

public class MutableComplex implements Complex{

    private double real;
    private double imag;

    public MutableComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override public double distance() {
        return real*real + imag*imag;
    }

    @Override public Complex add(Complex that) {
        return new ImmutableComplex(real + that.real(), imag + that.imag());
    }

    @Override public Complex mult(Complex that) {
        return new ImmutableComplex(real*that.real() - imag*that.imag(), real*that.imag() + imag*that.real());
    }

    @Override
    public double real() {
        return real;
    }

    @Override
    public double imag() {
        return imag;
    }

    @Override
    public String toString() {
        return "MutableComplex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }
}
