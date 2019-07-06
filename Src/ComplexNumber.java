package Src;

public class ComplexNumber {

    //Form of a + b*i

    //Real part
    private final double a;
    //Complex part
    private final double b;

    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getRealPart(){
        return this.a;
    }

    public double getComplexPart(){
        return this.b;
    }

    public ComplexNumber plus(ComplexNumber z){
        double a = this.a + z.a;
        double b = this.b + z.b;

        return new ComplexNumber(a, b);
    }

    public ComplexNumber times(ComplexNumber z){
        double c = z.a;
        double d = z.b;

        /*
        Form of (ac - bd) + (ad + bc)i
         */
        double a = (this.a * c) - (this.b * d);
        double b = (this.a * d) + (this.b * c);

        return new ComplexNumber(a, b);
    }

    //TODO: Add division

    public ComplexNumber minus(ComplexNumber z){
        double a = this.a - z.a;
        double b = this.b - z.b;

        return new ComplexNumber(a, b);
    }

    @Override
    public String toString(){
        boolean operatorIsNotNeeded = this.a == 0 || this.b == 0;
        String operator = this.b == Math.abs(this.b) ? " + " : " - ";
        operator = operatorIsNotNeeded ? "" : operator;
        String a = this.a == 0 ? "" : String.valueOf(this.a);
        String b = this.b == 0 ? "" : String.valueOf(this.b) + "i";
        return a + operator + b;
    }

    public boolean equals(ComplexNumber c){
        return this.a == c.a && this.b == c.b;
    }

    //Conjugate is just reversing the sign of the complex part. Checks for 0 because negative 0 is not wanted
    public ComplexNumber conjugate(){
        return new ComplexNumber(this.a, this.b == 0 ? 0 : this.b * -1);
    }

}
