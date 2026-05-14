package basic.math;

/*
    --> Leet Code : 1134
    - Given an integer number n, You have to return true if the number is Armstrong number, otherwise return false.

    - NOTE : An Armstrong number is the number that is equal to sum of its own digits raised to the
             power of the total number  of digits.

    Ex:1 -
    n = 153 --> No. of Digits = 3
    --> 1^3 + 5^3 + 3^3 = 153 --> True

    Ex:2 -
    n = 9474 --> No. of digits = 4
    --> 9^4 + 4^4 + 7^4 + 4^4 = 9474 --> True
*/
public class IsArmstrongNumber {
    public static void main(String[] args) {
        int[] data = {153, 9474, 371, 123, 12345};

        for (int number : data) {
            System.err.println("n = "+number+" : "+isArmstrongNumber(number));
        }
    }

    private static boolean isArmstrongNumber(int number) {
        int dump = number;
        int digits = countDigits(number);

        int sum = 0;
        while (number > 0) {
            int remainder = number % 10;
            sum = (int) (sum + Math.pow(remainder, digits));
            number /= 10;
        }

        if (sum == dump)
            return true;
        return false;
    }

    private static int countDigits(int number) {
        int counter = 0;

        while (number > 0) {
            number /= 10;
            counter++;
        }
        return counter;
    }
}
