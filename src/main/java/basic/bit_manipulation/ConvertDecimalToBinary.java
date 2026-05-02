package basic.bit_manipulation;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int value = array[i];
            String result = "";
            while (value > 0) {
                int rem = value % 2;
                value = value / 2;
                result += rem;
            }
            System.out.println(array[i]+" : "+new StringBuffer(result).reverse());
        }
    }
}
