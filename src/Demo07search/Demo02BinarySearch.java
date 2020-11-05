package Demo07search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo02BinarySearch {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 3, 5, 6, 9, 12, 12, 12, 17, 55, 67, 232, 1111, 4525, 52525};
        Set<Integer> search = BinarySearch(arr, 0, arr.length - 1, 12);
        search.forEach(System.out::println);
    }

    public static Set<Integer> BinarySearch(int[] arr, int left, int right, int value) {
        Set<Integer> res = new HashSet<>();
        //当left>right说明递归完毕，但没有找到
        if (left>right)
            return null;
        int mid = (left + right) / 2;
        if (arr[mid] > value)
            return BinarySearch(arr, left, mid-1, value);
        if (arr[mid] < value) //向右递归
            return BinarySearch(arr, mid+1, right, value);
        else{//找到多个，返回ArrayList
            int temp = mid-1;
            while (true){
                if (temp<0||arr[temp]!=value)
                    break;
                //否则把temp放入集合
                res.add(temp);
                temp--;
            }
            res.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=value)
                    break;
                //否则把temp放入集合
                res.add(temp);
                temp++;
            }
            res.add(mid);
        }
        return res;
    }
}
