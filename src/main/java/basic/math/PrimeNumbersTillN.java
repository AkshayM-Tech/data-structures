package basic.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    - Given a number n, You have to find out all prime numbers till n.
 */
public class PrimeNumbersTillN {
    public static void main(String[] args) {
        int[] data = {64, 77, 125, 49};

        for (int number : data) {
            System.err.println(number+" --> "+findPrimeNumbers(number));
            System.err.println(number+" --> "+findPrimeNumbersOptimal(number));
        }
    }

    private static List<Integer> findPrimeNumbers(int number) {
        List<Integer> primeNumbers = new ArrayList<>();
        if (number <= 1)
            return primeNumbers;

        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    private static List<Integer> findPrimeNumbersOptimal(int number) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] isPrime = new boolean[number + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= number; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= number; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 0; i <= number; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
