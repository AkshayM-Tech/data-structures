package basic;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        int n = 2;

        if (n <= 1) {
            System.out.println(n + " is not a prime number");
            return;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a prime number");
                return;
            }else {
                System.out.println(n + " is a prime number");
                return;
            }
        }
    }
}
