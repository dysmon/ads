package lab3;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();

        int[][] arr = new int[n][2];

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int x1, y1, x2, y2;
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            x2 = scan.nextInt();
            y2 = scan.nextInt();
            arr[i][0] = x2;
            arr[i][1] = y2;
            right = Math.max(Math.max(x2, y2), right);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(arr[i][0] <= mid && arr[i][1] <= mid){
                    cnt++;
                }
            }

            if(cnt >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
