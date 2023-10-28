package lab6;

import java.util.*;

public class G {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int size = 0;

        var arr = new String[n][2];

        for (int i = 0; i < n; i++) {
            boolean found = false;
            var st = new StringTokenizer(scan.nextLine());
            String oldName = st.nextToken();
            String newName = st.nextToken();
            if(size == 0){
                arr[i][0] = oldName;
                arr[i][1] = newName;
                size++;
                continue;
            }else{
                for(int j = 0; j < size;j++){
                    if(oldName.equals(arr[j][1])){
                        arr[j][1] = newName;
                        found = true;
                    }
                }
            }
            if(!found){
                arr[size][0] = oldName;
                arr[size][1] = newName;
                size++;
            }
        }

        var ans = new ArrayList<String>();
        for(int i = 0; i < size;i++){
            ans.add(arr[i][0] + " " + arr[i][1]);
        }

        Collections.sort(ans);

        System.out.println(size);
        for(String s : ans){
            System.out.println(s);
        }
    }
}