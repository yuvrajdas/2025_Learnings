import java.util.Stack;

public class __2ContructBinaryTree {

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

    public static void display(Node root){
        if(root == null) return;

        String str = "";
        str+=root.left == null ? " ." : root.left.data +" ";
        str+="<- "+root.data+" ->";
        str+=root.right == null ? " ." : root.right.data +" ";

        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Integer nodes[] = { 1, 7, 2, null, null, 6, 5, null, null, 11, null, null, 9, null, 9, 5, null, null, null };

        Node root = new Node(nodes[0], null, null);
        Pair rPair = new Pair(root, 1);

        Stack<Pair> stk = new Stack<>();
        
        stk.push(rPair);
        int idx = 0;

        while(!stk.isEmpty()){
            Pair top = stk.peek();

            if(top.state == 1){
                idx++;
                if(nodes[idx] != null){
                    Node leftNode = new Node(nodes[idx], null, null);
                    top.node.left = leftNode;
                    Pair lpair = new Pair(leftNode, 1);
                    stk.push(lpair);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx++;
                if(nodes[idx] != null){
                    Node rightNode = new Node(nodes[idx], null, null);
                    top.node.right = rightNode;
                    Pair rpair = new Pair(rightNode, 1);
                    stk.push(rpair);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                stk.pop();
            }
        }

        display(root);
    }
}
