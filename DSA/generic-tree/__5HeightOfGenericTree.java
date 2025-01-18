import java.util.*;

public class __5HeightOfGenericTree {

    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int getHeight(Node root){
        int height = -1;
        
        for(Node child : root.children){
            int ch = getHeight(child);
            height = Math.max(height, ch);
        }

        height = height+1;
        return height;
    }
    public static void main(String[] args) {
        int nodes[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
        
        Node root = null;
        Stack<Node> stk = new Stack<>();

        for(int val : nodes){
            if(val == -1){
                stk.pop();
            }else{
                Node node = new Node();
                node.data = val;

                if(stk.isEmpty()){
                    root = node;
                }else{
                    stk.peek().children.add(node);
                }

                stk.push(node);
            }
        }
        
        System.out.println(getHeight(root));
    }
}
