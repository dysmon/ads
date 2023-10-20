package lab4.J;

// Balanced Binary Search Tree

import java.io.*;
import java.util.*;


class BinarySearchTree {

    static ArrayList<Integer> list = new ArrayList<>();
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
        root = rInsert(root,value);
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

    private Node push(ArrayList<Integer> nums, int l, int r) {
        if (l > r) return null;

        int mid = l + (r - l) / 2;
        Node curNode = new Node(nums.get(mid));
        curNode.left = push(nums, l, mid - 1);
        curNode.right = push(nums, mid + 1, r);
        return curNode;
    }

    public void push(int left, int right) {
        root = push(list, left, right);
    }

    public void DFSPreOrder() {
        DFSPreOrder(root);
    }

    private void DFSInOrder(Node currentNode) {
        if (currentNode.left != null) {
            DFSInOrder(currentNode.left);
        }
        list.add(currentNode.value);
        if (currentNode.right != null) {
            DFSInOrder(currentNode.right);
        }
    }

    public void DFSInOrder() {
        DFSInOrder(root);
    }

    public static void main(String[] args) throws IOException {
        var tree = new BinarySearchTree();
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int size = (int) Math.pow(2, n) - 1;

        for (int i = 0; i < size; i++) {
            tree.rInsert(Integer.parseInt(st.nextToken()));
        }

        tree.DFSInOrder();
        tree.push(0, list.size() - 1);
        tree.DFSPreOrder();
    }
}
