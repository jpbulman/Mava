package Src.Exceptions.Matrices;

public class MatrixDimensionCreationException extends IndexOutOfBoundsException {

    public MatrixDimensionCreationException(){
        super();
    }

    @Override
    public String toString() {
        return "Matrix dimensions must be greater than > 0";
    }
}
