package org.example.sort;

public class BucketSort {
    
    private final QuickSort quickSort = new QuickSort();


    public int[] sort(int[] sourceArray, int bucketSize){

        //找出最大和最小值
        int minValue = sourceArray[0];
        int maxValue = sourceArray[1];

        for (int value : sourceArray){
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        //计算桶的数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketCount];

        //保存每个桶的数组的元素下标，默认值为0
        int[] indexArr = new int[bucketCount];

        //将数组中的值分配大各个桶里面
        for (int value : sourceArray){
            int bucketIndex = (value - minValue) / bucketSize;
            //当前桶的数组达到最大值，需要扩容
            if (indexArr[bucketIndex] == buckets[bucketIndex].length){
                ensureCapacity(buckets, bucketIndex);
            }

            //将数组放到桶中，并且桶对应的数组下标+1
            buckets[bucketIndex][indexArr[bucketIndex]++] = value;
        }

        //对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++){
            if (indexArr[i] == 0){
                continue;
            }

            quickSort.quickSort(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++){
                sourceArray[k++] = buckets[i][j];
            }
        }
        return sourceArray;
    }


    /**
     * 数组扩容，并保存数据
     * @param buckets
     * @param bucketIndex
     */
    private void ensureCapacity(int[][] buckets, int bucketIndex){
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length*2];
        for (int j = 0; j < tempArr.length; j++){
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }


    public static void main(String[] args) {

    }
}
