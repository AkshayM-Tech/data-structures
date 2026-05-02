package basic.bit_manipulation;

import java.util.Arrays;

/*
    --> Leet Code : 260
    - Given an integer array nums, in which exactly two elements appear only once and all the other elements appear
    exactly twice. Find the two elements that appear only once. You can return the answer in any order.
    - You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

    Ex:1 -
        I/P : [1,2,1,3,2,5]
        O/P : [3,5]
        Explanation:  [5, 3] is also a valid answer.

    Ex:2 -
        I/P : [-1,0]
        O/P : [-1,0]

    Ex:3 -
        I/P : [0,1]
        O/P : [1,0]
*/
public class SingleNumberIII {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 1, 3, 2, 5}, {-1, 0}, {0, 1}};

        for (int[] array : input){
            System.err.println("I/P : "+ Arrays.toString(array)+" <==> O/P : "+Arrays.toString(findSingleNumbers(array)));
        }
    }

    private static int[] findSingleNumbers(int[] array) {
        int zerosBucket = 0;
        int nonZerosBucket = 0;
        int XOR = 0;
        int n = array.length;

        for (int i : array) {
            XOR = XOR ^ i;
        }

        int lastSetBit = XOR & (~(XOR - 1));

        for (int value : array) {
            if ((value & lastSetBit) == 0) {
                zerosBucket = zerosBucket ^ value;
            }else {
                nonZerosBucket = nonZerosBucket ^ value;
            }
        }
        return new int[]{zerosBucket, nonZerosBucket};
    }
}
