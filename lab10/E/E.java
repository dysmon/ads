package lab10.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    public static class Vertex {

        public final int data;
        private List<Vertex> neighbors;

        public Vertex(int data) {
            this.data = data;
            this.neighbors = new LinkedList<>();
        }

        public List<Vertex> getNeighbors() {
            return neighbors;
        }

        public void addNeighbors(Vertex neighbor) {
            neighbors.add(neighbor);
        }
    }

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        Vertex[] vertices = new Vertex[n];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) vertices[i].addNeighbors(vertices[j]);
            }
        }

        while (--query >= 0) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            if (vertices[a].getNeighbors().contains(vertices[b]) && vertices[b].getNeighbors().contains(vertices[c])
            && vertices[c].getNeighbors().contains(vertices[a])){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
