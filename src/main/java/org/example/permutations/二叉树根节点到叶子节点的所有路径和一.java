package org.example.permutations;

import java.util.*;

public class 二叉树根节点到叶子节点的所有路径和一 {

    /**
     * NC9 二叉树中和为某一值的路径(一)
     * https://www.nowcoder.com/practice/508378c0823c423baa723ce448cbfd0c?tpId=196&tqId=37053&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E8%25B7%25AF%25E5%25BE%2584%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E8%B7%AF%E5%BE%84
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(root, path, resultList);
        if (resultList == null || resultList.size() == 0){
            return false;
        }

        for (List<Integer> result : resultList){
            int count = 0;
            for (Integer res : result){
                count += res;
            }

            if (count == sum){
                return true;
            }
        }
        return false;
    }


    public void dfs(TreeNode root, Deque<Integer> path, List<List<Integer>> resultList){
        if (root == null){
            return;
        }

        path.addLast(root.val);
        if (root.left == null && root.right == null){
            resultList.add(new ArrayList<>(path));
        }

        dfs(root.left, path, resultList);
        dfs(root.right, path, resultList);

        path.removeLast();
    }



    public static void main(String[] args) {

    }
}
