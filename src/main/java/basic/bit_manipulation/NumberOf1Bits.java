package basic.bit_manipulation;

/*
    --> Leet Code : 191 - Number of 1 Bit's
    - Given a positive integer n, write a function that returns the number of set bits in its binary representation
    (also known as the Hamming weight).
    - This approach is also called as 'Brain Kernighan's Algorithm, Where we remove last set bit in every iteration.

    Ex:1 -
        I/P : 11
        O/P : 3
        Explanation : The input binary string 1011 has a total of three set bits.

    Ex:2 -
        I/P : 128
        O/P : 1
        Explanation : The input binary string 10000000 has a total of one set bit.

    Ex:3 -
        I/P : 2147483645
        O/P : 30
        Explanation : The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
*/
public class NumberOf1Bits {
    public static void main(String[] args) {
        int[] input = {11, 128, 2147483645};

        for (int value : input) {
            System.err.println("Number of 1 Bit's in : "+value+" are : "+findNumberOfSetBits(value));
        }
    }

    private static int findNumberOfSetBits(int value) {
        int count = 0;

        while (value > 0){
            value = value & (value - 1);
            count++;
        }
        return count;
    }
}
