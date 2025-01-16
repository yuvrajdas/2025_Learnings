import java.util.*;

class __1ConstructGenericTree{
    
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();    
    }

    public static void display(Node root){
        String str = root.data +"->";

        for(Node child : root.children){
            str+=child.data+", ";
        }
        str+=".";
        System.out.println(str);

        for(Node child : root.children){
            display(child);
        }
    }
 
    public static void main(String[] args) {
        int nodes[] = {10, 20, 50, -1, 60, -1, -1,  30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40,  100, -1, -1, -1};
        Node root = null;
        Stack<Node> stk = new Stack<>();

        for(int i = 0; i<nodes.length; i++){

            if(nodes[i] == -1){
                stk.pop();
            }else{
                Node node = new Node();
                node.data = nodes[i];

                if(stk.size()>0){
                    stk.peek().children.add(node);
                }else{
                    root = node;
                }
                stk.push(node);
            }
        }  
        System.out.println();
        display(root);
    }
}