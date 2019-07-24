package Src.Vectors;

import Src.Matrix.Matrix;

import java.util.List;

public abstract class Vector extends Matrix {

    private final double[] vectorValues;

    //Constructor is only used by Vector subclasses and is abstract, so it can be package private
    Vector(double[] vectorValues, String typeOfVector){
        super(vectorValues, typeOfVector);
        this.vectorValues = vectorValues;
    }

    public double[] toArray(){
        return this.vectorValues;
    }

    public int length(){
        return this.vectorValues.length;
    }

    public double getAtPosition(int n){
        return this.vectorValues[n];
    }

    public static boolean areLinearlyIndependent(Vector... vectors){
        Matrix m = vectors[0];
        for(int i = 1; i < vectors.length; i++){
            m.augmentWith(vectors[i]);
        }

        return m.determinant() != 0;
    }

    public static boolean areLinearlyIndependent(List<Vector> vectors){
        Matrix m = vectors.get(0);
        for(int i = 1; i < vectors.size(); i++){
            m = m.augmentWith(vectors.get(i));
        }

        return m.determinant() != 0;
    }

}
