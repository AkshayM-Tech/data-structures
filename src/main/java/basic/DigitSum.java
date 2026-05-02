package basic;

/*
    Write a program to calculate the sum of digits in a given integer.

    Ex:1
    I/p : 3586
    O/p : 22

    Ex:2
    I/p : 12345
    O/p : 15
*/
public class DigitSum {
    public static void main(String[] args) {
        int[] input = {3586, 12345};

        for (int n : input) {
            System.err.println("I/P : "+n+" - O/P : "+sumOfDigits(n));
        }
    }

    /*
        Time Complexity : O(log n) -> because we are dividing the number by 10 in each iteration
        Space Complexity : O(1) -> we are using only a constant amount of space to store the res variable
    */
    private static int sumOfDigits(int n) {
        int res = 0;
        while (n > 0){
            int rem = n % 10;
            res = res + rem;
            n = n / 10;
        }
        return res;
    }
}
