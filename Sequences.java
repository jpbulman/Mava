public class Sequences {

    public static int getNthTriangleNumber(int n) throws IndexOutOfBoundsException{
        if(n < 1){
            throw new IndexOutOfBoundsException();
        } else {
            //Division typing is safe because triangle numbers are guaranteed to be ints
            return (n * (n + 1)) / 2;
        }
    }

}
