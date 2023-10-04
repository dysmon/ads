package lab3;

import java.util.ArrayList;

public class BinarySearch {
    public static int binarySearch(Integer[] array, int search) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == search) {
                return mid;
            } else if (search < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
