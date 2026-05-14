package basic.math;

/*
    - Given a number n, You have to return true if it is perfect square otherwise return false.

    Ex :
        n = 4 --> True
        n = 9 --> True
        n = 15 --> False
        n = 64 --> True
*/
public class IsPerfectSquare {
    public static void main(String[] args) {
        int[] data = {4, 5, 9, 125, 64, 49};

        for (int number : data) {
            System.err.println("=====================================================");
            System.err.println(number+" - "+bruteForceSolution(number));
            System.err.println("=====================================================");
            System.err.println(number+" - "+optimalSolution(number));
        }
    }

    private static boolean bruteForceSolution(int number) {
        if (number <= 1)
            return  false;

        for (int i = 1; i <= number / 2; i++) {
            if (i * i > number)
                return false;
            if (number == i * i)
                return true;
        }
        return false;
    }

    private static boolean optimalSolution(int number) {
        if (number <= 1)
            return false;

        for (int i = 1; i * i <= number; i++) {
            if (i * i == number)
                return true;
        }
        return false;
    }
}
