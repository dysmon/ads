package lab4.C;

// pre order DFS subtree

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

    public boolean setRoot(int value) {
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                root = temp;
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
            temp = queue.remove();
            results.add(temp.value);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return results;
    }

    private void DFSPreOrder(Node currentNode) {
        System.out.print(currentNode.value + " ");
        if (currentNode.left != null) {
            DFSPreOrder(currentNode.left);
        }
        if (currentNode.right != null) {
            DFSPreOrder(currentNode.right);
        }
    }

    public void DFSPreOrder() {
        DFSPreOrder(root);
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            tree.insert(scan.nextInt());
        }
        int x = scan.nextInt();
        tree.setRoot(x);
        tree.DFSPreOrder();
    }
}