package org.example.binary.tree;

public class 完全二叉树结点数 {

    /**
     * https://www.nowcoder.com/practice/512688d2ecf54414826f52df4e4b5693?tpId=196&tqId=37120&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * @param head
     * @return
     */
    public int nodeNum(TreeNode head) {
        if (head == null){
            return 0;
        }

        return nodeNum(head.left) + nodeNum(head.right) + 1;
    }
}
