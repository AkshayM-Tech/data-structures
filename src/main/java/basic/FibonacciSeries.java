package basic;

public class FibonacciSeries {
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21,34
        int n = 10;
        int first = 0, second = 1;
        System.out.println("Fibonacci Series for n = "+n+" : ");
        for (int i = 0; i < n; i++) {
            System.out.print(first+",");
            int temp = first + second;
            first = second;
            second = temp;
        }
    }
}
