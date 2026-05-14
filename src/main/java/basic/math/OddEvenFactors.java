package basic.math;

/*
    - Given a number n, Your task is to find whether the number n has EVEN factors or ODD factors.

    - NOTE : If a number is perfect square then it will always have ODD factors, otherwise EVEN factors.

    EX :
    n = 9 --> Perfect Square --> ODD factors.
    n = 25 --> Perfect Square --> ODD factors
    n = 64 --> Perfect Square --> ODD factors
    n = 15 --> Non-Square --> EVEN factors
    n = 45 --> Non-Square --> EVEN factors
 */
public class OddEvenFactors {
    public static void main(String[] args) {
        int[] data = {4, 9, 25, 64, 125, 79, 15};

        for (int number : data) {
            findOddEvenFactors(number);
        }
    }

    private static void findOddEvenFactors(int number) {
        if (number <= 0) {
            System.err.println("Invalid number");
        }

        if (isPerfectSquare(number)){
            System.out.printf("%d has ODD factors\n", number);
        }else  {
            System.out.printf("%d has EVEN factors\n", number);
        }
    }

    private static boolean isPerfectSquare(int number) {
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number)
                return true;
        }
        return false;
    }
}
