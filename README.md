# leetcode-learning
1、二叉树
前序遍历：根节点 ---> 左子树 ---> 右子树
中序遍历：左子树 ---> 根节点 ---> 右子树
后续遍历：左子树 ---> 右子树 ---> 根结点
层序遍历：只需按层次遍历即可




2、动态规划




3、回溯




4、双指针



5、滑动窗口
（1）求最长模板
初始化left、right、result、bestResult
while(右指针没有到结尾){
    窗口扩大，加入right对应元素，更新当前result
    while(result不满足需求){
        窗口缩小，移除left对应元素，left右移
    }
    更新最优结果bestResult
    right++;
}
return bestResult;
（2）求最短模板
初始化left、right、result、bestResult
while(右指针没有到结尾){
    窗口扩大，加入right对应元素，更新当前result
    while(result满足需求){
        更新最优结果bestResult
        窗口缩小，移除left对应元素，left右移
    }
    right++;
}
return bestResult
