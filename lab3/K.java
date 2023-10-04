package lab3;

import java.io.*;
import java.util.*;

public class K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = minSubarrayLength(arr, k);
        System.out.println(result);

        scanner.close();
    }

    public static int minSubarrayLength(int[] arr, int k) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        // Calculate the prefix sum of the array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int minLength = n;  // Initialize the minimum length to a large value

        // Iterate through the left end of the subarray
        for (int left = 0; left < n; left++) {
            // Binary search for the right end of the subarray
            int lo = left, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefixSum[mid + 1] - prefixSum[left] >= k) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            if (lo < n) {  // If a valid subarray exists
                minLength = Math.min(minLength, lo - left + 1);
            }
        }

        return minLength;
    }
}


