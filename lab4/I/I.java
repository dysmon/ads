package lab4.I;

//‘        insert X’ - insert X into the tree, if it already in a tree - increase its multiplicity,
//        ‘delete X’ - decrease multiplicity of Xby one, if it became zero - delete the node from the tree,
//        ‘cnt’ - output the multiplicity of X

import java.io.*;
import java.util.*;

class BinarySearchTree {

    private Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public int count = 1;

        Node(int value) {
            this.value = value;
        }

        public int getCount() {
            return count;
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
            if (newNode.value == temp.value) {
                ++temp.count;
                return false;
            }
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

    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void deleteNode(int value) {
        Node nodeToDelete = getNode(value);
        if (nodeToDelete != null) {
            if (nodeToDelete.getCount() == 0) {
                root = deleteNode(nodeToDelete,value);
            }
            nodeToDelete.count--;
        }
    }
    private Node getNode(Node cur, int value) {
        if(cur == null) return null;
        else if(cur.value == value) return cur;
        else if(value < cur.value) return getNode(cur.left,value);
        else return getNode(cur.right,value);
    }

    public Node getNode(int value){
        return getNode(root,value);
    }

    public static void main(String[] args) throws IOException {
        var tree = new BinarySearchTree();
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null || line.isBlank() || line.isEmpty()) {
                break;
            }

            var st = new StringTokenizer(line);

            String input = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (input.equals("insert")) tree.insert(value);
            else if (input.equals("cnt")) {
                if (tree.getNode(value) == null) {
                    System.out.println(0);
                } else {
                    System.out.println(tree.getNode(value).getCount());
                }
            } else if (input.equals("delete")) tree.deleteNode(value);
        }
    }
}

