package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树根节点到叶子节点的所有路径和 {

    /**
     * NC5 二叉树根节点到叶子节点的所有路径和
     * https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=196&tqId=37049&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E8%25B7%25AF%25E5%25BE%2584%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E8%B7%AF%E5%BE%84
     * @param root
     * @return
     */
    public int sumNumbers (TreeNode root) {
        if (root == null){
            return 0;
        }

        StringBuilder path = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        dfs(root, path, resultList);
        if (resultList == null || resultList.size() == 0){
            return 0;
        }

        int sum = 0;
        for (String result : resultList){
            sum += Integer.parseInt(result);
        }
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder path, List<String> resultList){
        if (root == null){
            return;
        }

        path.append(root.val);
        if (root.left == null && root.right == null){
            resultList.add(new String(path));
        }

        dfs(root.left, path, resultList);
        dfs(root.right, path, resultList);

        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {

    }
}
