/**
 * 1.1.3 Write a program that takes three integer command-line arguments and prints
 * equal if all three are equal, and not equal otherwise.
*/
import java.lang.Integer;

public class E1103 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        if ((a == b) && ( b == c))
            StdOut.println("equal");
        else
            StdOut.println("not equal");
    }
}
