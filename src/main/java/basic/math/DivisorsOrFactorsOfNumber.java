package basic.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    - Given a number n, You have to find out all its divisors/factors.
    - NOTE : A number is a divisor/factor of given number if it divides that number.

    Ex:1 -
    n = 15 --> [1,3,5,15]
 */
public class DivisorsOrFactorsOfNumber {
    public static void main(String[] args) {
        int[] data = {15, 36, 64, 8};

        for (int value : data) {
            System.err.println("Factors/Divisors of the number : "+value+" are : "+bruteForceSolution(value));
            System.err.println("Factors/Divisors of the number : "+value+" are : "+optimalSolution(value));
        }
    }

    private static List<Integer> bruteForceSolution(int value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= value; i++) {
            if (value % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Integer> optimalSolution(int value) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= value; i++) {
            if (value % i == 0) {
                result.add(i);
                if (value / i != i)
                    result.add(value / i);
            }
        }
        Collections.sort(result);
        return result;
    }
}
