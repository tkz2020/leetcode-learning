package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树中和为某一值的路径二 {

    /**
     * NC8 二叉树中和为某一值的路径(二)
     * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=196&tqId=37052&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E8%25B7%25AF%25E5%25BE%2584%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E8%B7%AF%E5%BE%84
     * @param root
     * @param expectNumber
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        if (root == null){
            return new ArrayList<>();
        }

        Deque<Integer> path = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        dfs(root, path, resultList);
        if (resultList == null || resultList.size() == 0){
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (ArrayList<Integer> result : resultList){
            int count = 0;
            for (Integer res : result){
                count += res;
            }

            if (count == expectNumber){
                lists.add(result);
            }
        }
        return lists;
    }


    public void dfs(TreeNode root, Deque<Integer> path, ArrayList<ArrayList<Integer>> resultList){
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
