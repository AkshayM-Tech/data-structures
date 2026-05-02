package basic;

/*
    Write a program to reverse the digits of a given integer.

    Ex:1
    I/p : 3586
    O/p : 6853

    Ex:2
    I/p : 12345
    O/p : 54321
 */
public class ReverseDigits {
    public static void main(String[] args) {
        int[] input = {3586, 12345, 123, -123};

        for (int n : input) {
            System.err.println("I/P : "+n+" - O/P : "+reverseDigits(n));
        }
    }

    /*
        Time Complexity : O(log n) -> because we are dividing the number by 10 in each iteration
        Space Complexity : O(1) -> we are using only a constant amount of space to store the res variable
    */
    private static int reverseDigits(int n) {
        int res = 0;

        while (n != 0) {
            int rem = n % 10;

            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10) {
                return 0; // Overflow case for positive numbers
            }
            res = res * 10 + rem;
            n = n / 10;
        }
        return res;
    }
}
