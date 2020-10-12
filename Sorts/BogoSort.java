package Sorts;

import java.util.Random;


/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */
public class BogoSort implements SortAlgorithm {

    private static final Random random = new Random();      // 三个修饰


    private static <T extends Comparable<T>> boolean isSorted(T[] array) {         //泛型类型,并在不知道数组是神马类型的
        for (int i = 0; i < array.length - 1; i++) {
            if (SortUtils.less(array[i + 1], array[i])) return false;
        }
        return true;
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T[] array) {
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortUtils.swap(array, randomIndex, i);                                  //package中可见的部分
        }
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {
        while (!isSorted(array)) {
            nextPermutation(array);
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        BogoSort bogoSort = new BogoSort();

        // print a sorted array
        SortUtils.print(bogoSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};

        SortUtils.print(bogoSort.sort(strings));
    }
}
