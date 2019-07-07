package Src.Exceptions;

public class CombinatoricsArgumentsException extends IndexOutOfBoundsException {

    private int n;
    private int r;

    public CombinatoricsArgumentsException(int n, int r){
        super();
        this.n = n;
        this.r = r;
    }

    @Override
    public String toString(){
        return "Arguments for the called combinatorics function are not valid. n must be > r, but " + n + " is not > " + r;
    }

}
