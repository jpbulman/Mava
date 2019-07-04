package Src;

import java.util.HashMap;
import java.util.List;

public class RealNumberOperations {

    public static double sum(Number... numbers){
        double sum = 0;
        for(Number n : numbers)
            sum += n.doubleValue();

        return sum;
    }

    @SafeVarargs
    public static double sum(List<Number>... numbers){
        double sum = 0;
        for(List<Number> list : numbers){
            double listSum = 0;
            for(Number n : list){
                listSum += n.doubleValue();
            }
            sum += listSum;
        }

        return sum;
    }

    public static double product(Number... numbers){
        double prod = 1;
        for(Number n : numbers)
            prod *= n.doubleValue();

        return prod;
    }

}
