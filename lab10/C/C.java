package lab10.C;

import java.util.*;

class C {
    static List<Integer> answer = new ArrayList<>();

    public static class Vertex {

        public final int data;
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

        public void operations(Vertex current) {
            answer.add(current.data);
            while (current != startVertex) {
                current = current.getNeighbors().get(0);
                answer.add(current.data);
            }
        }

        public void minOperations(int target) {
            Set<Integer> visited = new HashSet<>(1000);
            Queue<Vertex> queue = new LinkedList<>();

            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int size = queue.size();

                Vertex current = queue.remove();
                if (current.data == target) {
                    operations(current);
                    return;
                }
                if (visited.contains(current.data)) {
                    continue;
                }
                visited.add(current.data);
                int mul = current.data * 2;
                int sub = current.data - 1;

                if (mul > 0 && mul < 100000) {
                    Vertex verMul = new Vertex(mul);
                    verMul.addNeighbors(current);
                    queue.add(verMul);
                }
                if (sub > 0 && sub < 100000) {
                    Vertex verSub = new Vertex(sub);
                    verSub.addNeighbors(current);
                    queue.add(verSub);
                }
            }
        }
    }

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        new BFS(new Vertex(x)).minOperations(y);

        System.out.println(answer.size() - 1);
        Collections.reverse(answer);
        answer.stream().skip(1).forEach((a) -> System.out.print(a + " "));
    }

}

