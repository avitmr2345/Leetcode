import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static class Node {
        int value;
        Node left;
        Node right;
    }
    public static ArrayList<ArrayList<Integer>> leverOrder(Node node){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> currentList = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();
                currentList.add(currNode.value);
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }
}
        
        