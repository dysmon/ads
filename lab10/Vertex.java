package lab10;

import java.util.LinkedList;
import java.util.List;

class Vertex<T> {

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
