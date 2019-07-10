package Src.Exceptions.Matrices;

public class MatrixMultiplicationArgumentsException extends IndexOutOfBoundsException {

    public MatrixMultiplicationArgumentsException(){
        super();
    }

    @Override
    public String toString(){
        return "When multiplying matrices, A x B must be in the form (a x n) x (n x b)";
    }

}
