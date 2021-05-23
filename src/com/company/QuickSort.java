package com.company;

import java.util.Arrays;

class QuickSort {

    public int[] sort(int[] array) {
        return Arrays.stream(sort(Arrays.stream(array).boxed().toArray(Integer[]::new)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public long[] sort(long[] array) {
        return Arrays.stream(sort(Arrays.stream(array).boxed().toArray(Long[]::new)))
                .mapToLong(Long::longValue)
                .toArray();
    }

    public double[] sort(double[] array) {
        return Arrays.stream(sort(Arrays.stream(array).boxed().toArray(Double[]::new)))
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];
        while (right >= left) {
            while (array[left].compareTo(pivot) < 0) {
                left++;
            }
            while (pivot.compareTo(array[right]) < 0) {
                right--;
            }
            if (right >= left) {
                T swap = array[left];
                array[left] = array[right];
                array[right] = swap;
                ++left;
                --right;
            }
        }
        return left;
    }
}

class Main{
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] array = {231, 54, 12, 1, 54, -65, 86, -1};
        System.out.println("Old First: " + Arrays.toString(array));
        System.out.println("New First: " + Arrays.toString(quickSort.sort(array)));

        String[] stringArray = {"f", "c", "a", "d", "b", "e", "g"};

        System.out.println("Old Second: " + Arrays.toString(stringArray));
        System.out.println("New Second: " + Arrays.toString(quickSort.sort(stringArray)));
    }
}
