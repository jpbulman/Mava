import java.util.HashMap;

public class Sequences {

    public static int getNthTriangleNumber(int n) throws IndexOutOfBoundsException{
        if(n < 1){
            throw new IndexOutOfBoundsException();
        } else {
            //Division typing is safe because triangle numbers are guaranteed to be ints
            return (n * (n + 1)) / 2;
        }
    }

    private static HashMap<Integer, Integer> factorials = new HashMap<Integer, Integer>(){{
        put(0, 1);
    }};

    public static int factorial(int n) throws IndexOutOfBoundsException{
        if(n < 0) {
            throw new IndexOutOfBoundsException();
        } else if(factorials.containsKey(n)){
            return factorials.get(n);
        } else {
            int val = n*factorial(n - 1);
            factorials.put(n, val);
            return val;
        }
    }

    private static HashMap<Integer, Integer> fibs = new HashMap<Integer, Integer>(){{
        put(1, 1);
        put(2, 1);
    }};

    public static int getNthFibonacciNumber(int n) throws IndexOutOfBoundsException{
        if(n < 1){
            throw new IndexOutOfBoundsException();
        } else if(fibs.containsKey(n)){
            return fibs.get(n);
        } else {
            int val = getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2);
            fibs.put(n, val);
            return val;
        }
    }

}
