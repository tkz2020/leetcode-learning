package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 加起来和为目标值的组合三 {

    /**
     * https://www.nowcoder.com/practice/8c297161a58740c5b92b3e184dd1756e?tpId=196&tqId=39466&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D5%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC232 加起来和为目标值的组合(三)
     * @param k
     * @param n
     * @return
     */
    public int[][] combination (int k, int n) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(n, k, 0, 1, path, resultList);
        System.out.println(resultList);
        int[][] results  = new int[resultList.size()][resultList.size()];
        int index = 0;
        for (List<Integer> res : resultList){
            int[] result = new int[res.size()];
            for (int i = 0; i < res.size(); i++){
                result[i] = res.get(i);
            }
            results[index++] = result;
        }
        return results;
    }


    public void dfs(int n, int k, int sum, int startIndex, Deque<Integer> path, List<List<Integer>> resultList){
        if (sum == n && path.size() == k){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++){
            path.addLast(i);
            sum += i;
            dfs(n, k, sum, i+1, path, resultList);
            sum -= i;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int n = 5, k = 2;
        加起来和为目标值的组合三 ss = new 加起来和为目标值的组合三();
        ss.combination(k, n);
    }
}
