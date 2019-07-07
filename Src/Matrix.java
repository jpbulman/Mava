package Src;

import Src.Exceptions.Matrices.MatrixDimensionCreationException;
import Src.Exceptions.Matrices.MatrixMultiplicationArgumentsException;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Matrix {

    private final int m;
    private final int n;

    private final double[][] vals;

    public Matrix(int m, int n) {
        if(m < 1 || n < 1){
            throw new MatrixDimensionCreationException();
        } else {
            this.m = m;
            this.n = n;

            this.vals = new double[m][n];
        }
    }

    public Matrix(double[][] vals) {
        int m = vals.length;
        int n = vals[0].length;

        if(m < 1 || n < 1){
            throw new MatrixDimensionCreationException();
        } else {
            this.vals = vals;

            this.m = vals.length;
            this.n = vals[0].length;
        }
    }

    public int getNumberOfRows(){
        return this.m;
    }

    public int getNumberOfColumns(){
        return this.n;
    }

    @Override
    public String toString(){
        //Wish I could take credit for this cool one liner, but I can't
        //https://stackoverflow.com/questions/56917167/how-to-convert-a-two-dimensional-int-array-to-a-single-string-using-streams
        return Arrays.stream(this.vals)
                .map(doubles -> DoubleStream.of(doubles).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    public Matrix times(double scalar){
        double[][] newVals = new double[this.m][this.n];

        for(int m = 0; m < this.m; m++){
            for(int n = 0; n < this.n; n++){
                newVals[m][n] = this.vals[m][n] * scalar;
            }
        }

        return new Matrix(newVals);
    }

    private double multiplyAndSum(double[] a, double[] b){
        double result = 0;
        for(int i = 0; i < a.length; i++){
            double currentMultiply = a[i] * b [i];
            result += currentMultiply;
        }

        return result;
    }

    public Matrix times(Matrix m) {
        if(this.n != m.getNumberOfRows()){
            throw new MatrixMultiplicationArgumentsException();
        }

        double[][] newVals = new double[this.m][m.getNumberOfColumns()];

        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < m.getNumberOfColumns(); j++){
                double[] multiplyRow = this.vals[i];
                double[] multiplyColumn = m.vals[j];

                newVals[i][j] = multiplyAndSum(multiplyRow, multiplyColumn);
            }
        }

        return new Matrix(newVals);
    }

}
