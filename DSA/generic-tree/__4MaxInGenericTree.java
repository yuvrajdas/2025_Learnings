import java.util.*; 

public class __4MaxInGenericTree {

    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    static int max = Integer.MIN_VALUE;
    public static int getMax(Node root){

        for(Node child : root.children){
         
            getMax(child);
            max = Math.max(max, child.data);
        }

        return Math.max(max, root.data);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 210, 4, -1, 5, 7, -1, 8, -1, -1, 6, -1, -1, 3, -1, -1 };

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

        System.out.println(getMax(root));        
    }
}
