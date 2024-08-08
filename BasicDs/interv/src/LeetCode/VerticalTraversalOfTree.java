package LeetCode;

import java.util.*;

class VerticalTraversalOfTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> a.node.val -b.node.val);
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty())
        {
            Pair cur = queue.poll();
            if(map.containsKey(cur.hd))
            {
                map.get(cur.hd).add(cur.node.val);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(cur.node.val);
                map.put(cur.hd,temp);
            }
         
            if(cur.node.left != null) queue.offer(new Pair(cur.hd-1,cur.node.left));
            if(cur.node.right != null) queue.offer(new Pair(cur.hd+1,cur.node.right));
           
        }
 
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet())
        {
            Collections.sort(entry.getValue());          
            result.add(entry.getValue());
        }
 
        return result ;
    }

    public static void main(String[] args) {
        VerticalTraversalOfTree solution = new VerticalTraversalOfTree();
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Get the vertical order traversal
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Print the result
        for (List<Integer> column : result) {
            System.out.println(column);
        }
    }

}
 
 class Pair  {
        int hd;
        TreeNode node;
 
        public Pair(int hd,TreeNode node)
        {
            this.hd = hd;
            this.node = node;
        }
 
        // @Override
        // public int compareTo( Pair o)
        // {
        // return Integer.compare(this.node.val, o.node.val);
        // }
    }

