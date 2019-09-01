package Src.Vectors;

public class RowVector extends Vector {

    public RowVector(double[] vectorValues){
        super(vectorValues, "Row");
    }

    public ColumnVector transpose(){
        return new ColumnVector(super.toArray());
    }

    public RowVector plus(RowVector r){

        //Make exception at some point
        if(r.length() != this.length()){
            throw new IndexOutOfBoundsException();
        }

        double[] newValues = new double[this.length()];
        for(int i = 0; i < this.length(); i++){
            newValues[i] = this.getAtPosition(i) + r.getAtPosition(i);
        }
        return new RowVector(newValues);
    }

}
