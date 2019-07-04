package Src;

import java.util.HashMap;

public class NaturalNumberOperations {

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

}
