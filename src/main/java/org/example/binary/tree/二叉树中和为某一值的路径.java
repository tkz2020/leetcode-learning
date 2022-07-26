package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树中和为某一值的路径 {


    /**
     * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=117&tqId=37718&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * @param root
     * @param expectNumber
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        Deque<Integer> path = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        dfs(root, expectNumber, path, resultList);
        return resultList;
    }


    /**
     * DFS遍历二叉树
     * @param root
     * @param expectNumber
     * @param path
     * @param resultList
     */
    public void dfs(TreeNode root, int expectNumber, Deque<Integer> path, ArrayList<ArrayList<Integer>> resultList){
        if (root == null){
            return;
        }

        path.add(root.val);
        expectNumber -= root.val;

        if (root.left == null && root.right == null && expectNumber == 0){
            resultList.add(new ArrayList<>(path));
        }

        dfs(root.left, expectNumber, path, resultList);
        dfs(root.right, expectNumber, path, resultList);
        path.removeLast();
    }


    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int expectNumber) {
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
