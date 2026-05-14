package basic.math;

/*
    - Given a number n, return true if it is perfect cube otherwise return false;

    Ex :
        n = 4 --> False
        n = 9 --> False
        n = 27 --> True
        n = 25 --> False
        n = 64 --> True
        n = 125 -> True
*/
public class IsPerfectCube {
    public static void main(String[] args) {
        int[] data = {4, 9, 27, 25, 64, 125};

        for (int number : data) {
            System.err.println("**********************************************");
            System.err.println(number+" : "+bruteForceSolution(number));
            System.err.println(number+" : "+optimalSolution(number));
            System.err.println("**********************************************");
        }
    }

    private static boolean bruteForceSolution(int number) {
        if (number <= 0)
            return false;
        for (int i = 1; i <= number; i++) {
            if (i * i * i > number)
                return false;
            if (i * i * i == number)
                return true;
        }
        return false;
    }

    private static boolean optimalSolution(int number) {
        if (number <= 0)
            return false;
        for (int i = 1; i * i * i <= number; i++) {
            if (i * i * i == number)
                return true;
        }
        return false;
    }
}
