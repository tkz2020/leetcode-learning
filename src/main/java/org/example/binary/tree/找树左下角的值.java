package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class 找树左下角的值 {

    /**
     * 513. 找树左下角的值
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int result = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            result = deque.peek().val;
            while (size-- > 0){
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
