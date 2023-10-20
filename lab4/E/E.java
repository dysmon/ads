package lab4.E;

// width of the binary tree using BFS

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

    public boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if (value < currentNode.value) return rContains(currentNode.left, value);
        else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);

    }

    public void insert(int cur, int value, int isRight) {
        Node newNode = new Node(value);

        if(DFSPreOrder(root,cur) == null){
            root = new Node(cur);
        }
            Node temp = DFSPreOrder(root,cur);
            if(isRight == 1) temp.right = newNode;
            else temp.left = newNode;
    }

    private Node DFSPreOrder(Node currentNode, int value) {
        if (currentNode == null) {
            return null; // Value not found in the tree
        }

        if (currentNode.value == value) {
            return currentNode; // Found the node with the desired value
        }

        Node leftResult = DFSPreOrder(currentNode.left, value);
        if (leftResult != null) {
            return leftResult; // Value found in the left subtree
        }

        Node rightResult = DFSPreOrder(currentNode.right, value);
        if (rightResult != null) {
            return rightResult; // Value found in the right subtree
        }

        return null; // Value not found in either subtree
    }



    public int maxWidthUsingBFS() {
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        int max = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            if(count > max){
                max = count;
            }
            while(--count >= 0) {
                temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        var tree = new BinarySearchTree();
        for (int i = 0; i < n - 1; i++) {
            int cur = scan.nextInt();
            int value = scan.nextInt();
            int isRight = scan.nextInt();
            tree.insert(cur, value, isRight);
        }
        System.out.println(tree.maxWidthUsingBFS());
    }
}
