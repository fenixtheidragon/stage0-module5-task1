package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] arr = new int[length];
        for (int a = 0; a < arr.length; a++) {
            arr[a] = a + 1;
        }
        return arr;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int a = 0; a < arr.length; a++) {
            sum += arr[a];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == number) {
                return a;
            }
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverseArray = new String[arr.length];
        for (int a = 0; a < arr.length; a++) {
            reverseArray[a] = arr[arr.length - 1 - a];
        }
        return reverseArray;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int length = 0;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] > 0) {
                length++;
            }
        }
        int[] na = new int[length];
        int counter = 0;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] > 0) {
                na[counter] = arr[a];
                counter++;
            }
        }
        return na;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * IncoindexOfMinimumg one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("{");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ";");
            }
            System.out.print("},\n");
        }
        System.out.println("--------------------");

        int lastIndex = arr.length;
        int[][] sorted = arr.clone();
        int currentIndex = 0;
        while (currentIndex < lastIndex) {
            for (int a = currentIndex; a < lastIndex; a++) {
                if (sorted[currentIndex].length > sorted[a].length) {
                    int[][] tempSorted = sorted.clone();
                    sorted[currentIndex] = sorted[a].clone();
                    System.arraycopy(tempSorted, currentIndex, sorted, currentIndex + 1, a - currentIndex);
                }
                int[] temp = sorted[currentIndex].clone();
                int tempCounter = 0;
                while (tempCounter < temp.length) {
                    for (int b = tempCounter; b < temp.length; b++) {
                        if (temp[tempCounter] > temp[b]) {
                            int c = temp[tempCounter];
                            temp[tempCounter] = temp[b];
                            temp[b] = c;
                        }
                    }
                    tempCounter++;
                }
                sorted[currentIndex] = temp.clone();
            }
            currentIndex++;
        }
        for (int i = 0; i < sorted.length; i++) {
            System.out.print("{");
            for (int j = 0; j < sorted[i].length; j++) {
                System.out.print(sorted[i][j] + ";");
            }
            System.out.print("},\n");
        }
        return sorted;
    }
}
