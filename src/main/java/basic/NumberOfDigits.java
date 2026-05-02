package basic;

/*
    Write a program to count the number of digits in a given integer.

    Ex:1
    I/p : 3586
    O/p : 4

    Ex:2
    I/p : 12345
    O/p : 5
 */
public class NumberOfDigits {
    public static void main(String[] args) {
        int[] input = {3586, 12345};

        for (int i : input) {
            System.err.println("I/P : "+i+" - O/P : "+countDigits(i));
        }
    }

    /*
        Time Complexity : O(log n) -> because we are dividing the number by 10 in each iteration
        Space Complexity : O(1) -> we are using only a constant amount of space to store the count variable
    */
    private static int countDigits(int n) {
        int count = 0;

        while (n > 0){
            n = n / 10;
            count++;
        }
        return count;
    }
}
