package Src.Vectors;

public class ColumnVector extends Vector {

    public ColumnVector(double[] vectorValues){
        super(vectorValues, "Column");
    }

    public RowVector transpose(){
        return new RowVector(super.toArray());
    }

}
