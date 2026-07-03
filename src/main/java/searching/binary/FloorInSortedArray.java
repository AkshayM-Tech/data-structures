package searching.binary;

/*
    --> GFG
    - Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is
      less than or equal to x. This element is called the floor of x. If such an element does not exist, return -1.

    - Note: In case of multiple occurrences of floor of x, return the index of the last occurrence.

    Ex:1 -
        I/P : [1, 2, 8, 10, 10, 12, 19], x = 5
        O/P : 1
        Explanation: Largest number less than or equal to 5 is 2, whose index is 1.

    Ex:2 -
        I/P : [1, 2, 8, 10, 10, 12, 19], x = 11
        O/P : 4
        Explanation: Largest Number less than or equal to 11 is 10, whose indices are 3 and 4.
                     The index of last occurrence is 4.

    Ex:3 -
        I/P : [1, 2, 8, 10, 10, 12, 19], x = 0
        O/P : -1
        Explanation: No element less than or equal to 0 is found. So, output is -1.
*/
public class FloorInSortedArray {
    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 10, 10, 12, 19}, {1, 2, 8, 10, 10, 12, 19}, {1, 2, 8, 10, 10, 12, 19}, {1, 2, 8, 10, 10, 12, 19}
        , {4, 15, 17, 17, 19, 20, 21, 22, 22, 25, 26, 26, 26, 28, 28, 28, 31, 31, 32, 33, 34, 34, 35, 36, 36, 37,
            38, 38, 39, 41, 41, 42, 43, 43, 44, 44, 45, 45, 46, 47, 49, 49, 50, 50, 50, 51, 53, 54, 54, 56, 57, 58,
                58, 59, 60, 64, 67, 69, 75, 94}};
        int[] keys = {5, 11, 0, 10, 26};
        int key = 0;

        for (int[] array : data) {
            System.err.println(findFloor(array, keys[key++]));
        }
    }

    private static int findFloor(int[] array, int key) {
        int n = 0;
        if (array != null)
            n = array.length;
        if (n <= 0)
            return -1;

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] <= key) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }
        // To handle the condition 'If ceil value is not present then return -1 instead of returning out of bound value'
        if (low >= n)
            return -1;
        return high;
    }
}
