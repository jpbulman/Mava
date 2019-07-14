package Src.Vectors;

import Src.Matrix.Matrix;

public abstract class Vector extends Matrix {

    private final double[] vectorValues;

    public Vector(double[] vectorValues, String typeOfVector){
        super(vectorValues, typeOfVector);
        this.vectorValues = vectorValues;
    }

    public double[] toArray(){
        return this.vectorValues;
    }

}
