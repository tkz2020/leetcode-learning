package org.example.sort;

import java.util.Arrays;

public class HeapSort {


    /**
     * 构建一个大顶堆
     * @param heap
     * @param len
     */
    public void buildMaxHeap(int[] heap, int len){

        if (heap == null || heap.length == 0 || len == 0){
            return;
        }

        for (int i = len/2 - 1; i >= 0; i--){
            //检查根节点是否小于左子树
            if ((2*i+1) < len && heap[i] < heap[2*i+1]){
                int tmp = heap[i];
                heap[i] = heap[2*i+1];
                heap[2*i+1] = tmp;
                // 检查交换后的左子树是否满足大顶堆性质 如果不满足 则重新调整子树结构
                if ((2*(2*i+1)+1 < len && heap[2*i+1] < heap[2*(2*i+1)+1]) || (2*(2*i+1)+2 < len && heap[2*i+1] < heap[2*(2*i+1)+2])){
                    buildMaxHeap(heap, len);
                }
            }

            //检查根节点是否小于右子树
            if ((2*i+2) < len && heap[i] < heap[2*i+2]){
                int tmp = heap[i];
                heap[i] = heap[2*i+2];
                heap[2*i+2] = tmp;
                //检查交换后的右子树是否满足大顶堆性质 如果不满足 则重新调整子树结构
                if ((2*(2*i+2)+1 < len && heap[2*i+2] < heap[2*(2*i+2)+1]) || (2*(2*i+2)+2 < len && heap[2*i+2] < heap[2*(2*i+2)+2])){
                    buildMaxHeap(heap, len);
                }
            }
        }
    }

    /**
     * 交换根节点和最后一个节点的值
     * @param heap
     * @param len
     */
    public void swap(int[] heap, int len){
        int tmp = heap[0];
        heap[0] = heap[len-1];
        heap[len-1] = tmp;
    }



    public static void main(String[] args) {
        int[] heap = new int[]{7, 3, 8, 5, 1, 2};
        int len = 6;
        HeapSort heapSort = new HeapSort();
        for (int i = len; i > 0; i--){
            heapSort.buildMaxHeap(heap, i);
            heapSort.swap(heap, i);
        }

        System.out.println(Arrays.toString(heap));
    }
}
