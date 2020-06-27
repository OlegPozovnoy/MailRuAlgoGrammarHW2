package complex;

import exception.DivisionByZero;

import java.util.Objects;

public class Complex {
    public Double re;
    public Double im;

    public Complex(Double re, Double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex fromDouble(Double r) {
        return new Complex(r, 0.);
    }

    @Override
    public String toString() {
        return re + " " + im + "i";
    }

    public Complex add(Complex r) {
        return new Complex(re + r.re, im + r.im);
    }

    public Complex substract(Complex r) {
        return new Complex(re - r.re, im - r.im);
    }

    public Complex mult(Complex r) {
        return new Complex(re * r.re - im * r.im, im * r.re + re * r.im);
    }

    public Complex divide(Complex r) {
        if ( r.re * r.re + r.im * r.im == 0)
            throw new DivisionByZero();
        Double div = r.re * r.re + r.im * r.im;
        return new Complex(re / div, im / div).mult(new Complex(r.re, -r.im));
    }

    public Complex negate() {
        return new Complex(-re, -im);
    }

    public static Complex parseComplex(String arg) {
        arg = arg.trim();
        int imPos = arg.indexOf("Im");
        Double re = Double.parseDouble(arg.substring(2, imPos));
        Double im = Double.parseDouble(arg.substring(imPos + 2));
        return new Complex(re, im);
    }

    public static final Complex ONE = new Complex(1., 0.);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Math.abs( re- complex.re) + Math.abs(im - complex.im)<0.000000001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
