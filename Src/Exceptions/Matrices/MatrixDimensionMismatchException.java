package Src.Exceptions.Matrices;

public class MatrixDimensionMismatchException extends IndexOutOfBoundsException {

    public MatrixDimensionMismatchException(){
        super();
    }

    @Override
    public String toString() {
        return "Matrices must have the same dimensions in order for this operation to be performed";
    }
}

