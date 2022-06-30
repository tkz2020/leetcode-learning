package org.example.binary.tree;

import java.util.*;

/**
 * 二叉树的中序遍历：左子树--->根节点--->右子树
 */
public class 二叉树的中序遍历 {

    /**
     * 二叉树中序遍历(递归)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        inorderDfs(root, resultList);
        return new ArrayList<>();
    }


    /**
     * 二叉树的中序遍历(递归)
     * @param root
     * @param resultList
     */
    private void inorderDfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        inorderDfs(root.left, resultList);
        resultList.add(root.val);
        inorderDfs(root.right, resultList);
    }


    /**
     * 二叉树中序遍历(非递归)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }


    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0){
            if (root != null){
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                resultList.add(tmp.val);
                root = tmp.right;
            }
        }
        return resultList;
    }


    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            if (entry.getValue() == 1){
                result[index++] = entry.getKey();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,2,5};
        二叉树的中序遍历 ss = new 二叉树的中序遍历();
        ss.singleNumber(nums);
    }
}
