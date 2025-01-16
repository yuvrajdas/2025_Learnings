import java.util.*;

public class __2ConstructGenericTree {
    
    public static class  Node {
        int data;
        ArrayList<Node> childred = new ArrayList<>();
    }

    public static void display(Node root) {
        String str = root.data+"-->";

        for(Node child : root.childred){
            str+=child.data+", ";
        }

        str+=".";
        System.out.println(str);

        for(Node child : root.childred){
            display(child);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, 5, 7, -1, 8, -1, -1, 6, -1, -1, 3, -1, -1};
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
                    stk.peek().childred.add(node);
                }

                stk.push(node);
            }
        }

        display(root);
    }
}
