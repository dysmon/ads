package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    private static void swap(List<Character> array, int firstIndex, int secondIndex) {
        char temp = array.get(firstIndex);
        array.set(firstIndex,array.get(secondIndex));
        array.set(secondIndex,temp);
    }

    private static int pivot(List<Character> array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array.get(i) < array.get(pivotIndex)) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }


    public static void quickSortHelper(List<Character> array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }


    public static void quickSort(List<Character> array) {
        quickSortHelper(array, 0, array.size() - 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.next();

        List<Character> vowels = new ArrayList<>();
        List<Character> cons = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'i' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                vowels.add(s.charAt(i));
            }else {
                cons.add(s.charAt(i));
            }
        }

        quickSort(vowels);
        quickSort(cons);
        vowels.addAll(cons);

        for(char i : vowels){
            System.out.print(i);
        }
    }
}
