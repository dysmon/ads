package lab4.G;

// Maximum distance between any two vertices in a binary search tree. Cool task

import java.io.*;
import java.util.*;

class BinarySearchTree {

    private Node root;
    private static int maxDistance = 0;

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

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0; // Return -1 for null nodes
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        // Update the maximum distance
        maxDistance = Math.max(maxDistance, leftDepth + rightDepth + 1);

        // Return the maximum depth of the subtree rooted at the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int findMaxDistance() {
        maxDepth(root);
        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var tree = new BinarySearchTree();
        int n = Integer.parseInt(bf.readLine());
        var st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            tree.rInsert(Integer.parseInt(st.nextToken()));
        }
        System.out.println(tree.findMaxDistance());
    }
}
