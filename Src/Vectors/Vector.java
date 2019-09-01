package Src.Vectors;

import Src.Matrix.Matrix;

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

}
