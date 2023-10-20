package lab4.D;

// sum of values for each level

import java.util.*;

class BinarySearchTree {

    private Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node newNode = new Node(value);
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> BFS() {
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(temp);
        while (!queue.isEmpty()) {
            int sum = 0;
            int count = queue.size();

            while(--count >= 0) {
                temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                sum += temp.value;
            }
            results.add(sum);
        }
        return results;
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for(int i = 0; i < n;i++){
            tree.insert(scan.nextInt());
        }
        System.out.println(tree.BFS().size());
        for(int i : tree.BFS()){
            System.out.print(i + " ");
        }
    }

}
