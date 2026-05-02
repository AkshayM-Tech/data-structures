package patterns.star;

/*
    Write a program to print below pattern
    *
   * *
  * * *
 * * * *
* * * * *
 */
public class StartPattern01 {
    public static void main(String[] args) {
        int input = 5;

        for (int i = 0; i < input; i++) {
            for (int j = i; j < input; j++) {
                System.err.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.err.print("* ");
            }
            System.err.println();
        }
    }
}
