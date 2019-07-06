package Src;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matrix {

    private final int m;
    private final int n;

    private final int[][] vals;

    public Matrix(int m, int n){
        this.m = m;
        this.n = n;

        this.vals = new int[m][n];
    }

    public Matrix(int[][] vals){
        this.vals = vals;

        this.m = vals.length;
        this.n = vals[0].length;
    }

    public int getNumberOfRows(){
        return this.m;
    }

    public int getNumberOfColumns(){
        return this.n;
    }

    @Override
    public String toString(){

        return Arrays.stream(this.vals)
                .map(ints -> IntStream.of(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

}
