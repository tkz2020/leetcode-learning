package org.example.permutations;

public class 二叉树中和为某一值的路径三 {

    /**
     * https://www.nowcoder.com/practice/965fef32cae14a17a8e86c76ffe3131f?tpId=196&tqId=39283&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D4%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC162 二叉树中和为某一值的路径(三)
     * @param root
     * @param sum
     * @return
     */
    private int result = 0;
    public int FindPath (TreeNode root, int sum) {
        if (root == null){
            return 0;
        }

        dfs(root, sum);
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return result;
    }


    public void dfs(TreeNode root, int sum){
        if (root == null){
            return;
        }

        if (sum == root.val){
            result++;
        }

        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }

    public static void main(String[] args) {

    }
}
