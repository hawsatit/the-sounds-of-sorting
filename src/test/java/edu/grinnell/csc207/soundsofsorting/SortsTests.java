package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    //original test on array of random numbers
    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    //test on array of numbers with multiple repeats
    public void testMultipleRepeats(Consumer<Integer[]> func){
        Integer[] arr = {0 , 4 , 6, 2, 2, 6, 4, 5, 5, 5, 0, 0};
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    //test on array of numbers with multiple repeats
    public void testNegatives(Consumer<Integer[]> func){
        Integer[] arr = {0 , -3, -27, -4, 6, 7, 2};
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    //test on array of ascneding numbers (already sorted)
    public void testAscending(Consumer<Integer[]> func){
        Integer[] arr = {0 , 1, 2, 3, 4, 5, 6, 7, 8};
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    //test on array of descending numbers
    public void testDescending(Consumer<Integer[]> func){
        Integer[] arr = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    

    //test on empty array
    public void testEmptyArray(Consumer<Integer[]> func) {
        Integer[] arr = {};
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    //test on single-element array
    public void testSingleElement(Consumer<Integer[]> func) {
        Integer[] arr = {69};
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    //test on array with all identical elements
    public void testAllSameElements(Consumer<Integer[]> func) {
        Integer[] arr = {7, 7, 7, 7, 7, 7, 7, 7};
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    //test on large array
    public void testLargeArray(Consumer<Integer[]> func) {
        Integer[] arr = new Integer[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
        testMultipleRepeats(Sorts::bubbleSort);
        testNegatives(Sorts::bubbleSort);
        testAscending(Sorts::bubbleSort);
        testDescending(Sorts::bubbleSort);
        testEmptyArray(Sorts::bubbleSort);
        testSingleElement(Sorts::bubbleSort);
        testAllSameElements(Sorts::bubbleSort);
        testLargeArray(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
        testMultipleRepeats(Sorts::insertionSort);
        testNegatives(Sorts::insertionSort);
        testAscending(Sorts::insertionSort);
        testDescending(Sorts::insertionSort);
        testEmptyArray(Sorts::insertionSort);
        testSingleElement(Sorts::insertionSort);
        testAllSameElements(Sorts::insertionSort);
        testLargeArray(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
        testMultipleRepeats(Sorts::selectionSort);
        testNegatives(Sorts::selectionSort);
        testAscending(Sorts::selectionSort);
        testDescending(Sorts::selectionSort);
        testEmptyArray(Sorts::selectionSort);
        testSingleElement(Sorts::selectionSort);
        testAllSameElements(Sorts::selectionSort);
        testLargeArray(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
        testMultipleRepeats(Sorts::mergeSort);
        testNegatives(Sorts::mergeSort);
        testAscending(Sorts::mergeSort);
        testDescending(Sorts::mergeSort);
        testEmptyArray(Sorts::mergeSort);
        testSingleElement(Sorts::mergeSort);
        testAllSameElements(Sorts::mergeSort);
        testLargeArray(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
        testMultipleRepeats(Sorts::quickSort);
        testNegatives(Sorts::quickSort);
        testAscending(Sorts::quickSort);
        testDescending(Sorts::quickSort);
        testEmptyArray(Sorts::quickSort);
        testSingleElement(Sorts::quickSort);
        testAllSameElements(Sorts::quickSort);
        testLargeArray(Sorts::quickSort);
    }
    
    @Test
    public void testHeapSort() {
        testSort(Sorts::heapSort);
        testMultipleRepeats(Sorts::heapSort);
        testNegatives(Sorts::heapSort);
        testAscending(Sorts::heapSort);
        testDescending(Sorts::heapSort);
        testEmptyArray(Sorts::heapSort);
        testSingleElement(Sorts::heapSort);
        testAllSameElements(Sorts::heapSort);
        testLargeArray(Sorts::heapSort);
    }
}