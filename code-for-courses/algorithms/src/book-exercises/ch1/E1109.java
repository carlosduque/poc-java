/*
 * Write a code fragment that puts the binary representation of a positive integer N
 * into a String s.
 * Solution: Java has a built-in method Integer.toBinaryString(N) for this job, but
 * the point of the exercise is to see how such a method might be implemented. Here is a
 * particularly concise solution:
 * <code>
 * String s = "";
 * for (int n = N; n > 0; n /= 2)
 * s = (n % 2) + s;
 * </code>
*/
public class E1109 {
    public static String binary(int num) {
        String str = "";
        int bin = 0;
        for (int i = num; i > 0; i /= 2) {
            str = (i % 2) + str;
        }
        return str;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        StdOut.println(binary(num));
    }
}
