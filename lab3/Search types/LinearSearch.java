package lab3;

import java.util.ArrayList;

public class LinearSearch {
    public int linearSearch(ArrayList<Integer> list, int value){
        int index = -1;
        for(int i = 0;i < list.size();i++){
            if (list.get(i) == value) {
                index = i;
                return index;
            }
        }
        return index;
    }
}
