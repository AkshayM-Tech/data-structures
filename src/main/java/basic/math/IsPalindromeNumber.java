package basic.math;

/*
    --> Leet Code : 9 - Palindrome Number
    - Given an integer number n, You have to return true if the number is palindrome, otherwise return false.

    - NOTE : A number is called palindrome if the number & it's reversed number both are same.

    Ex:1 -
    n = 121 --> True

    Ex:2 -
    n = 11 --> True
*/
public class IsPalindromeNumber {
    public static void main(String[] args) {
        int[] data = {121, 131, 999, 123, 720};

        for (int number : data) {
            System.err.println("n = "+number+" : "+isPalindrome(number));
        }
    }

    private static boolean isPalindrome(int number) {
        int dump = number;
        int reversedNumber = 0;

        while (number > 0) {
            int remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;
        }

        if (dump == reversedNumber)
            return true;
        return false;
    }
}
