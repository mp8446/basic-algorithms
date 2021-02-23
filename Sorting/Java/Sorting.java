package com.petersen;

import java.util.ArrayList;

public class Sorting<T extends Comparable<T>> {
    //Stores our list of values
    private final ArrayList<T> elements = new ArrayList<T>();

    /***
     * Adds an element to the elements-Array
     * @param element The element that should be added
     */
    public void addElement(T element) {
        elements.add(element);
    }

    /***
     * @return Returns the elements-Array
     */
    public ArrayList<T> getElements() {
        return elements;
    }

    /***
     * @return Gets a String-Value that can be printed
     */
    public String toString() {
        StringBuilder value = new StringBuilder();

        for(T element : elements) {
            value.append(element.toString()).append("\n");
        }

        return value.toString();
    }

    /***
     * Sorts the elements-Array with a Bubblesort-Algorithm
     * @return The sorted array
     */
    public ArrayList<T> bubbleSort() {
        for(int i = elements.size(); i > 1; --i) {
            for (int j = 0; j < i - 1; j++) {
                if (elements.get(j).compareTo(elements.get(j + 1)) > 0) {
                    T bigger = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j + 1, bigger);
                }
            }
        }
        return getElements();
    }

    /***
     * Sorts the elements-Array with an enhanced Bubblesort-Algorithm.
     * If no changes are needed anymore the algorithm ends earlier.
     * @return The sorted array
     */
    public ArrayList<T> bubbleSortEnhanced() {
        boolean didSwitch = false;
        int iteratorMax = elements.size();

        do {
            didSwitch = false;

            for (int j = 0; j < iteratorMax - 1; j++) {
                if (elements.get(j).compareTo(elements.get(j + 1)) > 0) {
                    T bigger = elements.get(j);
                    elements.set(j, elements.get(j +1));
                    elements.set(j + 1, bigger);
                    didSwitch = true;
                }
            }
            iteratorMax -= 1;
        } while (didSwitch);
        return getElements();
    }

    /***
     * Sorts the elements-Array with a Selectionsort-Algorithm
     * @return The sorted array
     */
    public ArrayList<T> selectionSort() {
        int insertIndex = 0;

        while(insertIndex < elements.size() - 1) {
            int minValueIndex = insertIndex;

            for(int i = insertIndex + 1; i < elements.size(); i++) {
                if(elements.get(i).compareTo(elements.get(minValueIndex)) < 0) {
                    minValueIndex = i;
                }
            }

            if(elements.get(insertIndex).compareTo(elements.get(minValueIndex)) > 0) {
                T orig = elements.get(insertIndex);
                elements.set(insertIndex, elements.get(minValueIndex));
                elements.set(minValueIndex, orig);
            }

            insertIndex += 1;
        }

        return getElements();
    }

    /***
     * Wrapper function to sort the elements using a Quicksort-Algorithm
     * @return The sorted array
     */
    public ArrayList<T> quickSort() {
        quickSortCore( 0, elements.size() -1);

        return getElements();
    }

    /**
     * Recursive function that is the main function of the Quicksort-Algorithm.
     * @param leftIndex left list starting index
     * @param rightIndex right list starting index
     */
    private void quickSortCore(int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int partition = quickSortPartition(leftIndex, rightIndex);
            quickSortCore(leftIndex, partition);
            quickSortCore(partition + 1, rightIndex);
        }
    }

    /***
     * Partitioning function for the Quicksort-Algorithm
     * @param leftIndex left startindex
     * @param rightIndex right startindex
     * @return The ending index of the left list.
     */
    private int quickSortPartition(int leftIndex, int rightIndex) {
        int partitionIndex = (leftIndex + rightIndex) / 2;
        T partitionValue = elements.get(partitionIndex);
        int lower = leftIndex - 1;
        int higher = rightIndex + 1;

        while(true) {
            do {
                lower++;
            } while (elements.get(lower).compareTo(partitionValue) < 0);

            do {
                higher--;
            } while (elements.get(higher).compareTo(partitionValue) > 0);

            if(lower < higher) {
                T save = elements.get(lower);
                elements.set(lower, elements.get(higher));
                elements.set(higher, save);
            } else {
                return higher;
            }
        }
    }
}
