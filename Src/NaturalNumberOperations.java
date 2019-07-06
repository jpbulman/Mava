package Src;

import Src.Exception.CombinatoricsArgumentsException;
import Src.Exception.NegativeArgumentException;

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

    public static int permutations(int n, int r) throws CombinatoricsArgumentsException, NegativeArgumentException {

        if(n < 0 || r < 0){
            throw new NegativeArgumentException();
        } else if(n < r){
            throw new CombinatoricsArgumentsException(n, r);
        }

        //Division is type safe because permutations are guaranteed to be integers
        return factorial(n) / factorial(n - r);
    }

    public static int combinations(int n, int r) throws CombinatoricsArgumentsException, NegativeArgumentException{

        if(n < 0 || r < 0){
            throw new NegativeArgumentException();
        } else if(n < r){
            throw new CombinatoricsArgumentsException(n, r);
        }

        //Division is type safe because combinations are guaranteed to be integers
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

}
