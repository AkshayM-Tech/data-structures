package basic.bit_manipulation;

/*
    --> Leet Code : 231 - Power of Two
    - Given an integer n, return true if it is a power of two. Otherwise, return false.
    - An integer n is a power of two, if there exists an integer x such that n == 2x.

    Ex:1 -
        I/P : 1
        O/P : true
        Explanation : 2^0 = 1

    Ex:2 -
        I/P : 16
        O/P : true
        Explanation : 2^4 = 16

    Ex:3 -
        I/P : 3
        O/P : false
        Explanation : 2^0 = 1 & 2^1 = 2 & 2^2 = 4 --> 3 is not the power value of 2.
*/
public class PowerOfTwo {
    public static void main(String[] args) {
        int[] input = {1,16, 3, 8, 9};

        for (int value : input) {
            System.err.println("I/P : "+value+" :: O/P : "+isPowerOfTwo(value));
        }
    }

    /*
        Here we will use (n & (n - 1)) formula (Brian Kernighan's Algorithm), Using this formula we can remove last
        / lowest set bit and as we know any number n which is power of two contains only one set it in its binary,
        and we are removing that set bit using above algorithm so result will become 0's.
    */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
