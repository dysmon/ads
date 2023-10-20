package lab4.A;

import java.io.*;
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
    public boolean available(String s){
        Node temp = root;
        if(temp == null) return false;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'L'){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
            if(temp == null) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        var tree = new BinarySearchTree();
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n;i++){
            tree.insert(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < m;i++){
            System.out.println(tree.available(br.readLine()) ? "YES" : "NO");
        }
    }
}
