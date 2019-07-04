package Src;

public class ComplexNumber {

    private int a;
    private int b;

    public ComplexNumber(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void add(ComplexNumber i){
        this.a += i.a;
        this.b += i.b;
    }

    public void multiply(ComplexNumber i){
        int c = i.a;
        int d = i.b;

        /*
        Form of (ac - bd) + (ad  -bc)i
         */
        this.a = (this.a * c) - (this.b * d);
        this.b = (this.a * d) - (this.b * c);
    }

    public String toString(){
        String operator = b == Math.abs(b) ? " + " : " - ";
        return a + operator + b + "i";
    }

}
