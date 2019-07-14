package Src.Matrix;

import Src.Exceptions.Matrices.MatrixDimensionCreationException;
import Src.Exceptions.Matrices.MatrixDimensionMismatchException;
import Src.Exceptions.Matrices.MatrixMultiplicationArgumentsException;
import Src.Vectors.ColumnVector;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Matrix {

    //TODO: column constructor, rref

    //Number of rows
    private final int m;

    //Number of columns
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

    //Default Vector constructor, if no config is specified, default to row vector
//    public Matrix(double[] vals){
//        this.m = 1;
//        int vectorLength = vals.length;
//        this.n = vectorLength;
//
//        double[][] newVals = new double[1][vectorLength];
//        for(int i = 0; i < vectorLength; i++){
//            newVals[0][i] = vals[i];
//        }
//
//        this.vals = newVals;
//    }

    protected Matrix(int m, int n, boolean isVector){
        if(isVector){
            if(m != 1 && n != 1){
                throw new MatrixDimensionCreationException();
            } else {
                this.m = m;
                this.n = n;
                this.vals = new double[m][n];
            }
        } else {
            this.m = m;
            this.n = n;

            this.vals = new double[m][n];
        }
    }

    protected Matrix(double[] vectorValues, String typeOfVector){

        int vectorLength = vectorValues.length;

        switch (typeOfVector){
            case "Row":
            case "row":
                this.m = 1;
                this.n = vectorLength;
                this.vals = new double[1][vectorLength];
                break;
            case "Column":
            case "column":
                this.m = vectorLength;
                this.n = 1;
                this.vals = new double[vectorLength][1];
                break;
            default:
                throw new MatrixDimensionMismatchException();
        }
    }

//    protected Matrix(double[] vectorValues, String type){
//        switch (type){
//            case "row":
//                int vectorLength = vectorValues.length;
//                double[][] newVals = new double[1][vectorLength];
//                for(int j = 0; j < vectorLength; j++){
//                    newVals[0][j] = vectorValues[j];
//                }
//                this.vals = newVals;
//                this.m = 1;
//                this.n = vectorLength;
//                break;
//            case "column":
//                vectorLength = vectorValues.length;
//                newVals = new double[1][vectorLength];
//                for(int j = 0; j < vectorLength; j++){
//                    newVals[0][j] = vectorValues[j];
//                }
//                this.vals = newVals;
//                this.m = 1;
//                this.n = vectorLength;
//                break;
//            default:
//                throw new MatrixDimensionCreationException();
//        }
//    }

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

    //Take a row and a column, multiply the values at each index, and add them all up
    //so a[0] * b[0] + a[1] * b[1] + ... + a[n] * b[n]
    private double multiplyAndSum(double[] a, double[] b){
        double result = 0;

        for(int i = 0; i < a.length; i++){
            double currentMultiply = a[i] * b [i];
            result += currentMultiply;
        }

        return result;
    }

    //Since it's math, columns start at 1
    //Could potentially be cache optimized somehow? Unsure if that would require restructuring attributes or not
    //Gets values from left to right;
    private ColumnVector getNthColumn(int n){
        double[] col = new double[this.m];

        for(int i = 0; i < this.m; i++){
            col[i] = this.vals[i][n];
        }

        return new ColumnVector(col);
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

    public Matrix times(Matrix m) {
        if(this.n != m.m){
            throw new MatrixMultiplicationArgumentsException();
        }

        //Matrices are a x b • b x c
        //New matrix is a x c
        //Same thing as this.m x m.n

        double[][] newVals = new double[this.m][m.n];

        //Iterate through each empty rom/column of the empty matrix and fill it in accordingly
        //Take the ith row and multi/sum the jth column
        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < m.n; j++){
                double[] multiplyRow = this.vals[i];
                double[] multiplyColumn = m.getNthColumn(j).toArray();

                newVals[i][j] = multiplyAndSum(multiplyRow, multiplyColumn);
            }
        }

        return new Matrix(newVals);
    }

    public Matrix plus(Matrix m){
        if(m.m != this.m && m.n != this.n){
            throw new MatrixDimensionMismatchException();
        } else {
            double[][] newVals = new double[this.m][this.n];

            for(int i = 0; i < this.m; i++){
                for(int j = 0; j < this.n; j++){
                    newVals[i][j] = this.vals[i][j] + m.vals[i][j];
                }
            }

            return new Matrix(newVals);
        }
    }

    public double[][] asArray(){
        return this.vals;
    }

    public Matrix minus(Matrix m){
        return this.plus(m.times(-1));
    }

    public boolean equals(Matrix m){
        if (this.m != m.m || this.n != m.n){
            return false;
        } else {
            for(int i = 0; i < this.m; i++){
                for(int j = 0; j < this.n; j++){
                    if(this.vals[i][j] != m.vals[i][j]){
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static Matrix getIdentityMatrix(int size){
        if(size < 1){
            throw new MatrixDimensionCreationException();
        }

        double[][] vals = new double[size][size];

        for(int i = 0, j = 0; i < size && j < size; i++, j++){
            vals[i][j] = 1;
        }

        return new Matrix(vals);
    }

    public Matrix transpose(){
        double[][] vals = new double[this.n][this.m];
        for(int i = 0;i < this.n; i++){
            vals[i] = this.getNthColumn(i).toArray();
        }

        return new Matrix(vals);
    }

    public Matrix augmentWith(Matrix m){
        if(this.m != m.m){
            throw new MatrixDimensionMismatchException();
        }

        double[][] vals = new double[this.m][this.n + m.n];
        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < this.n + m.n; j++){
                //If it is in the first half of the matrix, aka **this** matrix
                if(j < this.n){
                    vals[i][j] = this.vals[i][j];
                } else {
                    //If it is in the second matrix, aka the one being augmented/appended on
                    //J needs the offset because it is the index for the new matrix, but not for m
                    vals[i][j] = m.vals[i][j - this.n];
                }
            }
        }

        return new Matrix(vals);
    }

    //Always pass in n > 1
    private ColumnVector getNthColumnCoveringFirstRow(int n){
        double[] colArr = this.getNthColumn(n).toArray();
        int vectorLength = colArr.length;
        double[] newColArr = new double[vectorLength - 1];

        System.arraycopy(colArr, 1, newColArr, 0, vectorLength - 1);

        return new ColumnVector(newColArr);
    }

    public double determinant(){
        if(this.m != this.n){
            throw new MatrixDimensionMismatchException();
        } else if(this.m == 1){
            return this.vals[0][0];
        } else if(this.m == 2){
            return (this.vals[0][0] * this.vals[1][1]) - (this.vals[0][1] * this.vals[1][0]);
        } else {
            double sum = 0;
            for(int i = 0; i < this.n; i++){
                double currentValue = this.vals[0][i];

                Matrix toFindDeterminantOf = null;
                for(int j = 0; j < this.n; j++){
                    if(j == i){
                        continue;
                    } else if (toFindDeterminantOf == null) {
                        toFindDeterminantOf = this.getNthColumnCoveringFirstRow(j);
                    } else {
                        toFindDeterminantOf.augmentWith(this.getNthColumnCoveringFirstRow(j));
                    }
                }

                double product = currentValue * toFindDeterminantOf.determinant();

                if(i % 2 != 0){
                    product *= -1;
                }

                sum += product;
            }

            return sum;
        }
    }

}
