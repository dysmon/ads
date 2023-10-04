package lab3;

import java.io.*;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] blocks = new int[n];

        blocks[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            blocks[i] = Integer.parseInt(st.nextToken()) + blocks[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int mistakeLine = Integer.parseInt(br.readLine());
            int block = findBlock(blocks, mistakeLine);
            s.append(block).append("\n");
        }

        System.out.println(s);

        br.close();
    }

    public static int findBlock(int[] end, int mistakeLine) {
        int left = 0;
        int right = end.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (end[mid] > mistakeLine) {
                right = mid - 1;
            } else if (end[mid] < mistakeLine){
                left = mid + 1;
            }
            else{
                return mid + 1;
            }
        }
        return left + 1; // Add 1 to convert index to block number
    }
}