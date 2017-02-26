package com.karbaros.myapp.utility;

/**
 * Created by shanu on 19-Jan-17.
 */

public class SortingAlgoritham {

    // Code for Bubble sort

    /*
     * Bubble sort, also referred to as sinking sort, is a simple sorting
     * algorithm that works by repeatedly stepping through the list to be
     * sorted, comparing each pair of adjacent items and swapping them if they
     * are in the wrong order. The pass through the list is repeated until no
     * swaps are needed, which indicates that the list is sorted. The algorithm
     * gets its name from the way smaller elements "bubble" to the top of the
     * list. Because it only uses comparisons to operate on elements, it is a
     * comparison sort. Although the algorithm is simple, most of the other
     * sorting algorithms are more efficient for large lists.
     */
    public static void bubbleSort(int[] array) {

        int arrayLength = array.length;
        for (int i = arrayLength - 1; i >= 0; i--) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // print here to see the array by each iteration;
        }

    } // bubble sort end here----

    // code for selection sort

    /*
     * The selection sort is a combination of searching and sorting. During each
     * pass, the unsorted element with the smallest (or largest) value is moved
     * to its proper position in the array. The number of times the sort passes
     * through the array is one less than the number of items in the array. In
     * the selection sort, the inner loop finds the next smallest (or largest)
     * value and the outer loop places that value into its proper location.
     */
    public static void selectionSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            int index = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < array[index]) {
                    index = j;

                    int temp = array[index];
                    array[index] = array[i];
                    array[i] = temp;

                }
            }

        }

    } // selection sort ends here---

    // Code for insertion sort

	/*
	 * Insertion sort is a simple sorting algorithm, it builds the final sorted
	 * array one item at a time. It is much less efficient on large lists than
	 * other sort algorithms.
	 *
	 * Advantages of Insertion Sort:
	 *
	 * 1) It is very simple. 2) It is very efficient for small data sets. 3) It
	 * is stable; i.e., it does not change the relative order of elements with
	 * equal keys. 4) In-place; i.e., only requires a constant amount O(1) of
	 * additional memory space.
	 *
	 * Insertion sort iterates through the list by consuming one input element
	 * at each repetition, and growing a sorted output list. On a repetition,
	 * insertion sort removes one element from the input data, finds the
	 * location it belongs within the sorted list, and inserts it there. It
	 * repeats until no input elements remain.
	 */

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j < 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }// insertion sort ends here...

    // code for quick sort

	/*
	 * Quicksort or partition-exchange sort, is a fast sorting algorithm, which
	 * is using divide and conquer algorithm. Quicksort first divides a large
	 * list into two smaller sub-lists: the low elements and the high elements.
	 * Quicksort can then recursively sort the sub-lists.
	 *
	 * Steps to implement Quick sort:
	 *
	 * 1) Choose an element, called pivot, from the list. Generally pivot can be
	 * the middle index element. 2) Reorder the list so that all elements with
	 * values less than the pivot come before the pivot, while all elements with
	 * values greater than the pivot come after it (equal values can go either
	 * way). After this partitioning, the pivot is in its final position. This
	 * is called the partition operation. 3) Recursively apply the above steps
	 * to the sub-list of elements with smaller values and separately the
	 * sub-list of elements with greater values.
	 */

    int length;
    int[] array;

    public void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.array = array;
        length = array.length;
        quickSortCode(0, length - 1);
    }

    private void quickSortCode(int low, int high) {
        int lowerBound = low;
        int upperBound = high;
        // pivot is middle index
        int pivot = array[lowerBound + (upperBound - lowerBound) / 2];
        while (lowerBound <= upperBound) {
            while (array[lowerBound] < pivot) {
                lowerBound++;
            }
            while (array[upperBound] > pivot) {
                upperBound--;
            }
            if (lowerBound <= upperBound) {
                int temp;
                temp = array[lowerBound];
                array[lowerBound] = array[upperBound];
                array[upperBound] = temp;
                lowerBound++;
                upperBound--;
            }
        }

        // quick sort recursive call;

        if (low < upperBound) {
            quickSortCode(low, upperBound);
        }
        if (lowerBound < high) {
            quickSortCode(lowerBound, high);
        }
    } // end of quick sort code ..

//------------------------------------------
    // merge sort
    public static void mergeSort(int[] a, int low, int high) {
        int n = high - low;
        if (n <= 1)
            return;
        int mid = low + n / 2;
        // recursively sort
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        // merge two sorted subarrays
        int[] temp = new int[n];
        int i = low, j = mid;
        for (int k = 0; k < n; k++) {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j] < a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < n; k++)
            a[low + k] = temp[k];
    } // merge sort ends here

   // heap sort
   
    private static int N;
    /* Sort Function */
    public static void heapSort(int array[])
    {

            heapify(array);
            for (int i = N; i > 0; i--)
            {
                swap(array,0, i);
                N = N-1;
                maxheap(array, 0);
            }



    }
    /* Function to build a heap */
    private static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);
    }
    /* Function to swap largest element in heap */
    private static void maxheap(int arr[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
    /* Function to swap two numbers in an array */
    private static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
// heap sort ends here


}
