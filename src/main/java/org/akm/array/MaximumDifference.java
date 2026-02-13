package org.akm.array;

/*
    Given an array arr[] of integers, find out the maximum difference between any two elements
    such that larger element appears after the smaller number.
    i.e. arr[j] > arr[i]

    Input : arr = {2, 3, 10, 6, 4, 8, 1}
    Output : 8
    Explanation : The maximum difference is between 10 and 2.

    Input : arr = {7, 9, 5, 6, 3, 2}
    Output : 2
    Explanation : The maximum difference is between 9 and 7.
 */
public class MaximumDifference {
    public static void main(String[] args) {
        int[][] input = {{2, 3, 10, 6, 4, 8, 1}, {7, 9, 5, 6, 3, 2}};

        for (int[] array : input)
            findMaxDifference(array);
    }

    private static void findMaxDifference(int[] array) {
        array = new int[]{999, 997, 980, 976, 948, 940, 938, 928, 924, 917, 907, 907, 881, 878, 864, 862, 859, 857, 848, 840, 824, 824, 824, 805, 802, 798, 788, 777, 775, 766, 755, 748, 735, 732, 727, 705, 700, 697, 693, 679, 676, 644, 634, 624, 599, 596, 588, 583, 562, 558, 553, 539, 537, 536, 509, 491, 485, 483, 454, 449, 438, 425, 403, 368, 345, 327, 287, 285, 270, 263, 255, 248, 235, 234, 224, 221, 201, 189, 187, 183, 179, 168, 155, 153, 150, 144, 107, 102, 102, 87, 80, 57, 55, 49, 48, 45, 26, 26, 23, 15};
        int n = array.length;
        int max = -1;

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (array[j] - array[i] > max)
                    max = array[j] - array[i];
            }
        }
        System.err.println("Max Difference is : "+max);
    }
}
