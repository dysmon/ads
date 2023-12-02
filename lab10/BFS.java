package lab10;

import java.util.LinkedList;
import java.util.Queue;

class BFS<T> {
    private final Vertex<T> startVertex;

    public BFS(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public int traverse() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(--size >= 0) {
                Vertex<T> current = queue.remove();
                if (!current.isVisited()) {
                    current.setVisited(true);
                    queue.addAll(current.getNeighbors());
                }
            }
        }
        return -1;
    }
}
