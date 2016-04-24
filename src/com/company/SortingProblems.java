package com.company;

/**
 * Created by siddharthmolleti on 1/10/16.
 */
public class SortingProblems {

    public static void bubbleSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] < num[j+1]) {
                    int temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                }
            }
        }

    }

    public static void selectionSort(int[] num) {
        for (int i = 0; i< num.length; i++) {
            for (int j = i; j < num.length - i; j++) {
                if (num[i] > num[j]) {
                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0; j--) {
                if (num[j] > num[j-1]) {
                    int temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;
                }
            }
        }
    }

    public static void heapSort(int[] num) {
        heapify(num);

        for (int i = num.length -1; i>0; i++) {
            swap(num, 0, i);
            //N--;queue
            maxHeap(num, 0);
        }

    }

    private static void maxHeap(int[] num, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < num.length && num[left] > num[index]) {
            max = left;
        }

        if (right < num.length && num[right] > num[index]) {
            max = right;
        }

        if (max != index) {
            swap(num, index, max);
            maxHeap(num, max);
        }

    }

    public static void heapify(int[] num) {
        int length = num.length - 1;
        for (int i = length/2; i>=0; i--) {
            maxHeap(num, i);
        }
    }

    private static void swap(int[] num, int index2, int index1) {
        int temp = num[index2];
        num[index2] = num[index1];
        num[index1] = temp;
    }

    public static void mergeSort(int[] num) {

    }

    public static void quickSort(int[] num) {
        quickSort(num, 0, num.length-1);
    }

    private static void quickSort(int[] num, int low, int high) {
        int i = low;
        int j = high;
        int pivot = num[low + (high - low)/2];

        while (i <= j) {
            while (num[i] < pivot) {
                i++;
            }

            while (num[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(num, i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(num, low, j);
        if (i < high)
            quickSort(num, i, high);

    }


    public void twoArrays(int[] mPlusN, int[] n) {

    }

    public static void main(String[] args) {
        int[] num = {2, 1, 6, 4, 9, 16, 22, 12};
        //bubbleSort(num);
        //selectionSort(num);
        //insertionSort(num);
        //maxHeap(num, 0);
        //heapify(num);
        quickSort(num);
        for (int i: num) {
            System.out.println(i);
        }
    }
}
