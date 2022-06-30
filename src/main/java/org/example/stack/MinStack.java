package org.example.stack;

public class MinStack {

    /**
     * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&tPage=1
     * initialize your data structure here.
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数, 得到栈的最大元素的max函数,
     * 得到栈中所有元素的平均数的avg函数在该栈中，调用 min、max、avg、push 及 pop 的时间复杂度都是 O(1)。
     *
     *
     *
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.max();   --> 返回 0.
     * minStack.avg();   --> 返回 -1.
     * minStack.pop();
     * minStack.push(-4);
     * minStack.top();      --> 返回 -4.
     * minStack.min();   --> 返回 -4.
     * minStack.max();   --> 返回 0.
     * minStack.avg();   --> 返回 -2.
     */
    public MinStack() {
        node = null;
    }

    ListNode node;

    public void push(int x) {
        if (node == null) {
            node = new ListNode(x, x, null, 1, x, x);
        } else {
            node = new ListNode(x, Math.min(x, node.min), node, node.count + 1, node.sum + x, Math.max(x, node.max));
        }
    }

    public void pop() {
        if (node != null){
            node = node.next;
        }
    }

    public int top() {
        if (node != null){
            return node.val;
        }else {
            throw new NullPointerException("Stack is null");
        }
    }

    public int min() {
        if (node != null){
            return node.min;
        }else {
            throw new NullPointerException("Stack is null");
        }
    }

    public int max() {
        if (node != null){
            return node.max;
        }else {
            throw new NullPointerException("Stack is null");
        }
    }
    public int avg() {
        if (node != null){
            return node.sum / node.count;
        }else {
            throw new NullPointerException("Stack is null");
        }
    }
    public int size() {
        if (node != null){
            return node.count;
        }else {
            throw new NullPointerException("Stack is null");
        }
    }

    class ListNode {
        private int val;
        private int min;
        private ListNode next;
        private int count;
        private int sum;
        private int max;

        public ListNode(int val, int min, ListNode next, int count, int sum, int max) {
            this.val = val;
            this.min = min;
            this.next = next;
            this.count = count;
            this.sum = sum;
            this.max = max;
        }
    }
}
