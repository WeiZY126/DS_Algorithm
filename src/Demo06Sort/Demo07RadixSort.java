package Demo06Sort;

import java.util.Arrays;

public class Demo07RadixSort {
    public static void main(String[] args) throws Exception {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    public static void radixSort(int arr[]) {
        //第一轮排序（针对每个元素的个位数）
        //定义一个二维数组，表示十个桶，每个桶就是一个一位数组
        //1.二维数组包含十个一维数组
        //2.为了防止溢出，则每个一维数组（桶），大小定为arr.length
        //3.明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        int bucketElementCount[] = new int[10];


        //根据推导结果，得到基数排序
        //1.先得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int maxLength = (max + "").length();
        //使用循环处理代码
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位
                int digitOfElement = arr[j]/n% 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }
            //按照桶的顺序放回原来的数组
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCount.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后需要将每个bucketElementCounts清零
                bucketElementCount[k] = 0;
            }
        }


        /*//第1轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }
        //按照桶的顺序放回原来的数组
        int index = 0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCount.length; k++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCount[k] != 0) {
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后需要将每个bucketElementCounts清零
            bucketElementCount[k] = 0;
        }
        //第2轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] / 10 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }
        //按照桶的顺序放回原来的数组
        index = 0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCount.length; k++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCount[k] != 0) {
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后需要将每个bucketElementCounts清零
            bucketElementCount[k] = 0;
        }

        //第3轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] / 100 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }
        //按照桶的顺序放回原来的数组
        index = 0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCount.length; k++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCount[k] != 0) {
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后需要将每个bucketElementCounts清零
            bucketElementCount[k] = 0;
        }*/
    }

}
