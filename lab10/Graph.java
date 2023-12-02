package lab10;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
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
                while(--size >= 0) {
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

}
