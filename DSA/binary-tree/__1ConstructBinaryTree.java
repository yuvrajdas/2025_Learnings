import java.util.*;

public class __1ConstructBinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {

        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node root) {

        if (root == null) {
            return;
        }

        String str = "";

        str += root.left == null ? "." : root.left.data + "";
        str += " <-" + root.data + "-> ";
        str += root.right == null ? "." : root.right.data + "";
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Integer nodes[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null };

        Node root = new Node(nodes[0], null, null);
        Pair rPair = new Pair(root, 1);

        Stack<Pair> stk = new Stack<>();
        stk.push(rPair);

        int idx = 0;

        while (!stk.isEmpty()) {
            Pair top = stk.peek();
            if (top.state == 1) {
                idx++;
                if (nodes[idx] != null) {
                    Node lnode = new Node(nodes[idx], null, null);
                    top.node.left = lnode;
                    Pair lPair = new Pair(lnode, 1);
                    stk.push(lPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (nodes[idx] != null) {
                    Node rnode = new Node(nodes[idx], null, null);
                    top.node.right = rnode;
                    Pair rpair = new Pair(rnode, 1);
                    stk.push(rpair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stk.pop();
            }
        }

        display(root);
    }
}
