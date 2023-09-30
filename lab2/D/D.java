package lab2.D;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        for (int i = 0; i < n; i++) {
            int cur = scan.nextInt();
            int frequency = frequencyMap.getOrDefault(cur, 0) + 1;
            frequencyMap.put(cur, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        List<Integer> modes = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        Collections.sort(modes);

        for (int i = modes.size() - 1; i >= 0; i--) {
            System.out.print(modes.get(i) + " ");
        }
    }
}
