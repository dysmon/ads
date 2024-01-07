package lab4;

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
        root = rInsert(root, value);
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

    private void DFSPostOrder(Node currentNode) {
        if (currentNode.left != null) {
            DFSPreOrder(currentNode.left);
        }
        if (currentNode.right != null) {
            DFSPreOrder(currentNode.right);
        }
        System.out.print(currentNode.value + " ");
    }

    public void DFSPostOrder() {
        DFSPostOrder(root);
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

    private void DFSInOrder(Node currentNode) {
        if (currentNode.left != null) {
            DFSInOrder(currentNode.left);
        }
        System.out.print(currentNode.value + " ");
        if (currentNode.right != null) {
            DFSInOrder(currentNode.right);
        }
    }

    public void DFSInOrder() {
        DFSInOrder(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0; // Return -1 for null nodes
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);


        // Return the maximum depth of the subtree rooted at the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void findMaxDistance() {
        maxDepth(root);
    }
}
