package lab10.B;

import java.io.*;
import java.util.*;

public class B {
    public static class Vertex<T> {

        private final T data;
        private boolean visited;
        private List<Vertex<T>> neighbors;

        public Vertex(T data) {
            this.data = data;
            this.visited = false;
            this.neighbors = new LinkedList<>();
        }

        public T getData() {
            return data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Vertex<T>> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<Vertex<T>> neighbors) {
            this.neighbors = neighbors;
        }

        public void addNeighbors(Vertex<T> neighbor) {
            neighbors.add(neighbor);
        }
    }

    public static class BFS<T> {
        static int cnt;
        private final Vertex<T> startVertex;


        public BFS(Vertex<T> startVertex) {
            this.startVertex = startVertex;
        }

        public int traverse(Vertex<T> find) {
            Queue<Vertex<T>> queue = new LinkedList<>();
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (--size >= 0) {
                    Vertex<T> current = queue.remove();
                    if (!current.isVisited()) {
                        current.setVisited(true);
                        if (current == find) return cnt;
                        queue.addAll(current.getNeighbors());
                    }
                }
                cnt++;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Vertex<Integer>[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex<>(i);
        }
        for (int i = 0; i < n; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    vertices[i].addNeighbors(vertices[j]);
                }
            }
        }
        var st = new StringTokenizer(br.readLine());

        int root = Integer.parseInt(st.nextToken());
        int toFind = Integer.parseInt(st.nextToken());


        System.out.println(new BFS<>(vertices[root - 1]).traverse(vertices[toFind - 1]));
//
//        System.out.println(Arrays.toString(vertices));
//        for(Vertex<Integer> i : vertices){
//            System.out.println(i.getNeighbors());
//        }

    }
}
