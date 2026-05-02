package basic.bit_manipulation;

/*
    - Given a positive integer n, write a function that returns the last set bit in its binary representation.
 */
public class LastSetBit {
    public static void main(String[] args) {
        int[] input = {17, 52, 16};

        for (int value : input) {
            System.err.println("Last Set Bit for the number " + value + " is " + findLastSetBit(value));
        }
    }

    private static int findLastSetBit(int value) {
        if (value <= 0)
            return 0;
        return (value & (~(value - 1)));
    }
}
