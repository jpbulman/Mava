package Src.Vectors;

public class RowVector extends Vector {

    public RowVector(double[] vectorValues){
        super(vectorValues, "Row");
    }

    public ColumnVector transpose(){
        return new ColumnVector(super.toArray());
    }

}
