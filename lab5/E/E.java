package lab5.E;

import java.io.*;
import java.util.*;

class MinHeap {

    private final ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        int minIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return minValue;
    }


    public long maxSum(int k) {
        long sum = 0;

        while (k < heap.size()) {
            remove();
        }

        for (int i = 0; i < heap.size(); i++) {
            sum += heap.get(i);
        }

        return sum;
    }


    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var wr = new BufferedWriter(new OutputStreamWriter(System.out));
        var st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        var heap = new MinHeap();;

        while (--q >= 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("insert")) {
                heap.insert(Integer.parseInt(st.nextToken()));
            } else if (s.equals("print")) {
                wr.write(( heap.maxSum(k)+"\n"));
            }
        }
        wr.flush();
    }

}



