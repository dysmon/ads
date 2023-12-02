package lab10.D;

import java.io.*;
import java.util.*;

public class D {
    public static class Vertex {

        public final int data;
        public String color = "black";
        private boolean visited;
        private List<Vertex> neighbors;

        public Vertex(int data) {
            this.data = data;
            this.visited = false;
            this.neighbors = new LinkedList<>();
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Vertex> getNeighbors() {
            return neighbors;
        }

        public void addNeighbors(Vertex neighbor) {
            neighbors.add(neighbor);
        }
    }

    public static class BFS {
        private final Vertex startVertex;


        public BFS(Vertex startVertex) {
            this.startVertex = startVertex;
        }

        public int nearestRedVertex() {
            if (startVertex.color.equals("red")) return 0;
            boolean found = false;
            int cnt = 0;

            Queue<Vertex> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>(1000);
            queue.add(startVertex);

            Outer: while (!queue.isEmpty()) {
                int size = queue.size();
                cnt++;
                while (--size >= 0) {
                    Vertex current = queue.remove();
                    if (visited.contains(current.data)) {
                        continue;
                    }
                    visited.add(current.data);
                    for(Vertex v : current.getNeighbors()){
                        if(v.color.equals("red")){
                            found = true;
                            break Outer;
                        }
                    }
                    queue.addAll(current.getNeighbors());
                }
            }
            return !found ? -1 : cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        var output = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), query = Integer.parseInt(st.nextToken());

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) vertices[i] = new Vertex(i);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int vertex1 = Integer.parseInt(st.nextToken()) - 1;
            int vertex2 = Integer.parseInt(st.nextToken()) - 1;
            vertices[vertex1].addNeighbors(vertices[vertex2]);
            vertices[vertex2].addNeighbors(vertices[vertex1]);
        }

        for (int i = 0; i < query; i++) {
            st = new StringTokenizer(input.readLine());
                int query1 = Integer.parseInt(st.nextToken());
                int query2 = Integer.parseInt(st.nextToken()) - 1;
            if (query1 == 1) {
                vertices[query2].color = "red";
            } else {
                System.out.println((new BFS(vertices[query2]).nearestRedVertex()));
            }
        }
        input.close();
        output.close();
    }

}