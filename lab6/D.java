package lab6;

import java.util.Scanner;

public class D {
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }


    public static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }


    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] dates = new int[n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split("-");
            dates[i] = Integer.parseInt(arr[2] + arr[1] + arr[0]);
        }

        quickSort(dates);

        StringBuilder s = new StringBuilder();
        for (int date : dates) {
            s.append(String.format("%02d-%02d-%02d\n", date % 100, date % 10000 / 100, date / 10000));
        }
        System.out.println(s);
    }
}
