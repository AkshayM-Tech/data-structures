package org.akm.array;

/*
    Given a sorted array, arr[] consisting of N integers, the task is to find the frequencies of each array element.

    #Ex-1 :
    I/P : {1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10}
    O/P : Frequency of 1 is: 3
          Frequency of 2 is: 1
          Frequency of 3 is: 2
          Frequency of 5 is: 2
          Frequency of 8 is: 3
          Frequency of 9 is: 2
          Frequency of 10 is: 1
    #Ex-2 :
    I/P : {2, 2, 6, 6, 7, 7, 7, 11}
    O/P : Frequency of 2 is: 2
          Frequency of 6 is: 2
          Frequency of 7 is: 3
          Frequency of 11 is: 1
*/
public class FrequenciesInSortedArray {
    public static void main(String[] args) {
        int[][] input = {{1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10}, {2, 2, 6, 6, 7, 7, 7, 11}};

        for (int[] array : input)
            getFrequencyCount(array);
    }

    private static void getFrequencyCount(int[] array) {
        int n = array.length;
        int count = 1;
        int currentElement = array[0];

        for (int i = 1; i < n; i++){
            if (array[i] == currentElement){
                count++;
            }else {
                System.err.println(currentElement+" : "+count);
                currentElement = array[i];
                count = 1;
            }
        }
        System.err.println(currentElement+" : "+count);
        System.err.println("===========================================");
    }
}
