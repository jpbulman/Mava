package Src.Exception;

public class NegativeArgumentException extends Exception {

    public NegativeArgumentException(){

    }

    @Override
    public String toString() {
        return "One or more arguments were negative numbers and were passed into a method that does not allow those.";
    }
}
