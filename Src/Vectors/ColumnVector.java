package Src.Vectors;

import Src.Matrix.Matrix;

import java.util.List;

public class ColumnVector extends Vector {

    public ColumnVector(double[] vectorValues){
        super(vectorValues, "Column");
    }

    public RowVector transpose(){
        return new RowVector(super.toArray());
    }

    public ColumnVector plus(ColumnVector r){

        //Make exception at some point
        if(r.length() != this.length()){
            throw new IndexOutOfBoundsException();
        }

        double[] newValues = new double[this.length()];
        for(int i = 0; i < this.length(); i++){
            newValues[i] = this.getAtPosition(i) + r.getAtPosition(i);
        }
        return new ColumnVector(newValues);
    }

    //Can probably be moved to vector class at some point
    public static boolean areLinearlyIndependent(ColumnVector... vectors){
        Matrix m = vectors[0];
        for(int i = 1; i < vectors.length; i++){
            m = m.augmentWith(vectors[i]);
        }

        return m.determinant() != 0;
    }

    public static boolean areLinearlyIndependent(List<ColumnVector> vectors){
        Matrix m = vectors.get(0);
        for(int i = 1; i < vectors.size(); i++){
            m = m.augmentWith(vectors.get(i));
        }

        return m.determinant() != 0;
    }

}
