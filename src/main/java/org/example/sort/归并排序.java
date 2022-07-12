package org.example.sort;

import java.util.Arrays;

public class 归并排序 {

    /**
     * 归并排序
     * @param array
     */
    public void mergeSort(int[] array){
        if (array == null || array.length == 0){
            return;
        }
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int left, int right){
        if (left > right){
            return;
        }

        if (left == right){
            return;
        }

        int middle = (left + right) >> 1;
        sort(array, left, middle);
        sort(array, middle+1, right);
        merge(array, left, middle, right);
    }

    public void merge(int[] array, int left, int middle, int right){
        int[] result = new int[right - left + 1];
        int point1 = left, point2 = middle + 1;
        int index = 0;
        while (point1 <= middle && point2 <= right){
            result[index++] = array[point1] < array[point2] ? array[point1++] : array[point2++];
        }

        while (point1 <= middle){
            result[index++] = array[point1++];
        }

        while (point2 <= right){
            result[index++] = array[point2++];
        }

        // 把新数组中的数覆盖 array 数组，这块为啥要 + left 呢？因为需要把所有排序后的数添加到 array 数组中
        for (int i = 0; i < result.length; i++){
            array[i + left] = result[i];
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        归并排序 ss = new 归并排序();
        ss.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
