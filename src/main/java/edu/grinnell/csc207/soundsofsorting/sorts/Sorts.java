package edu.grinnell.csc207.soundsofsorting.sorts;

import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import java.util.Arrays;

/**
 * A collection of sorting algorithms.
 */
public class Sorts {
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> bubbleSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
        return null;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> selectionSort(
            T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        return null;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ] 
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> insertionSort(
            T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return null;
    }

    /**
     * Sorts the array according to the merge sort algorithm.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> mergeSort(
            T[] arr) {
        if (arr.length > 0) {
            mergeSortRecursion(arr, 0, arr.length - 1);
        }
        return null;
    }
    
     /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @param left The left bound of the subarray we want to sort
     * @param right The left bound of the subarray we want to sort
     * @param mid The midpoint of the subarray
     */
    public static <T extends Comparable<? super T>> void merge(T[] arr, int left, int right, int mid) {

        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i].compareTo(rightArr[j]) < 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }

    }
    
    /**
     * This helper function recursively breaks down the left side of the array and
     * right side of the array and then merges it back up.
     * @param <T>
     * @param arr the array to sort
     * @param left The left bound of the subarray we want to sort
     * @param right The left bound of the subarray we want to sort 
     */
    public static <T extends Comparable<? super T>> void mergeSortRecursion (T[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            //sort left
            mergeSortRecursion(arr, left, mid);

            //sort right
            mergeSortRecursion(arr, mid + 1, right);

            //merge
            merge(arr, left, right, mid); 
        }
    }


    /**
     * Sorts the array according to the quick sort algorithm.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> quickSort(T[] arr) {
        quickSortRecursion(arr, 0, arr.length - 1);
        return null;
    }
    
    /**
     * Splits into two by using bounds recursively, while using the quick sort method
     * of comparison using pivot points
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @param left left bound of the subarray
     * @param right right bound of the subarray
     */
    public static <T extends Comparable<? super T>> void quickSortRecursion(T[] arr, int left, int right) {
        //call on left and right
        if (left < right) {
            int pivot = pivotCompare(arr, left, right);

            //right side
            quickSortRecursion(arr, pivot + 1, right);

            //left side
            quickSortRecursion(arr, left, pivot - 1);
        }
    }
    
    /**
     * making the pivot the right most element
     * and using the pivot comparison from the quick sort method
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @param left left bound of the subarray
     * @param right right bound of the subarray
     * @return the pivot point which is the midpoint of the next recursion call
     */
    public static <T extends Comparable<? super T>> int pivotCompare(T[] arr, int left, int right) {

        int pivot = right;
        int head = left;
        int tail = left - 1;

        while (head <= right - 1) {
            if (arr[head].compareTo(arr[pivot]) < 0) {
                tail++;
                swap(arr, head, tail);

            }
            head++;
        }
        //do final swap with pivot and tail + 1
        swap(arr, tail + 1, pivot);

        return tail + 1;
    }
    
    /**
     * Sorts the array according to the heap sort algorithm.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void heapSort(T[] arr) {
        
        // Build max heap (start from the last root
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            makeHeap(arr, arr.length, i);
        }
        
        // Extract elements from the heap one by one
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            makeHeap(arr, i, 0); // Heapify the reduced heap
        }
    }
    
    /**
     * Maintains the max heap property.
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @param n number of elements in heap
     * @param root the root index being heapified
     */
    public static <T extends Comparable<? super T>> void makeHeap(T[] arr, int n, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        // Swap and continue heapifying if the root is not the largest
        if (largest != root) {
            swap(arr, root, largest);
            makeHeap(arr, n, largest);
        }
    }
}
