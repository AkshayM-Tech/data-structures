package basic.math;

/*
    - Given a number n, and you have to find out the number of digits in that number.

    Ex:1 -
        n = 123
        O/P : 3
    Ex:2 -
        n = 12345
        O/P : 5
    Ex:3 -
        n = 1
        O/P : 1
 */
public class CountDigits {
    public static void main(String[] args) {
        int[] data = {1, 123, 12345, 123456789, 1234567890};

        for (int value : data) {
            System.err.println("Number of digits in the number : "+value+" are '"+countDigits(value)+"'");
        }
    }

    /*
        Time Complexity : O(log n) -> because we are dividing the number by 10 in each iteration
        Space Complexity : O(1) -> we are using only a constant amount of space to store the count variable
    */
    private static int countDigits(int number) {
        int count = 0;

        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
