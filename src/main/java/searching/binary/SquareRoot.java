package searching.binary;

/*
    - Leet Code : 69
    - Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
      The returned integer should be non-negative as well.
    - You must not use any built-in exponent function or operator.

    Ex : 1
        I/P = 4
        O/P = 2
        Explanation : The square root of 4 is 2, so we return 2.

    Ex : 2
        I/P = 8
        O/P = 2
        Explanation : The square root of 8 is 2.82842..., and since we round it down to the nearest integer,
                     2 is returned.
*/
public class SquareRoot {
    public static void main(String[] args) {
        int[] data = {4, 8, 25, 16, 64, 72, 2147395599};

        for (int value : data) {
            System.err.println("Square Root of "+value+" is "+findSquareRootUsingBinarySearch(value));
            System.err.println("Square Root of "+value+" is "+findSquareRootUsingMath(value));
        }
    }

    private static long findSquareRootUsingBinarySearch(int value) {
        long low = 1;
        long high = value;

        while (low <= high) {
            long mid = (low + high) / 2;

            if ((mid * mid) <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static long findSquareRootUsingMath(int value) {
        int ans = -1;

        for (int i = 1; i * i <= value; i++) {
            if (i * i == value) {
                return i;
            } else if (i * i < value) {
                ans = i;
            }
        }
        return ans;
    }
}
