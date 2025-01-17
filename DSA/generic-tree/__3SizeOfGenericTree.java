import java.util.*;

public class __3SizeOfGenericTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int getSize(Node root){
        int s = 0;

        for(Node child : root.children){
            int ch = getSize(child);
            s = s+ch;
        }
        return s + 1;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, 5, 7, -1, 8, -1, -1, 6, -1, -1, 3, -1, -1 };

        Node root = null;
        Stack<Node> stk = new Stack<>();

        for(int i=0; i<nodes.length; i++){
            if(nodes[i] == -1){
                stk.pop();
            }else{
                Node node = new Node();
                node.data = nodes[i];

                if(stk.isEmpty()){
                    root = node;
                }else{
                    stk.peek().children.add(node);
                }
                stk.push(node);
            }
        }

        System.out.println(getSize(root));
    }
}
