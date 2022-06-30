package org.example.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 奇偶树 {

    /**
     * 1609. 奇偶树
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null){
            return false;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;
        while (!deque.isEmpty()){
            List<TreeNode> resList = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode tmp = deque.poll();
                if (level % 2 == 0){
                    if (tmp.val % 2 == 0){
                        return false;
                    }
                } else if (level % 2 == 1){
                    if (tmp.val % 2 == 1){
                        return false;
                    }
                }
                resList.add(tmp);
                if (tmp.left != null){
                    deque.offer(tmp.left);
                }

                if (tmp.right != null){
                    deque.offer(tmp.right);
                }
            }
            if (!compare(resList, level)){
                return false;
            }
            level++;
        }
        return true;
    }


    public boolean compare(List<TreeNode> resList, int level){
        if (level == 0){
            return true;
        }

        if (level % 2 == 0){
            for (int i = 1; i < resList.size(); i++){
                if (resList.get(i).val <= resList.get(i-1).val){
                    return false;
                }
            }
        } else {
            for (int i = 1; i < resList.size(); i++){
                if (resList.get(i).val >= resList.get(i-1).val){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
