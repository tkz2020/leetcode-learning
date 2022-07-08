package org.example.二分查找;

public class 旋转数组的最小数字 {


    /**
     * BM21 旋转数组的最小数字
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {

        int left = 0, right = array.length - 1;
        while (left < right){
            int middle = (left + right) >> 1;
            if (array[middle] > array[right]){
                left = middle + 1;
            } else if (array[middle] == array[right]){
                right--;
            } else {
                right = middle;
            }
        }
        return array[left];
    }


    public static void main(String[] args) {

    }
}
