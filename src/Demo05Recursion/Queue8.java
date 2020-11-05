package Demo05Recursion;

import java.util.Arrays;

public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 5;
    //定义数组，表示皇后放置未知的结果
    int[] array = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(queue8.count);
    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if (n == max){//说明n=8，已经在放第9个皇后
            System.out.println(Arrays.toString(array));
            count++;
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i =0;i<max;i++){
            //先把当前皇后n，放到该行的第一列
            array[n]=i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){//不冲突
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n]=i; 即将第n个皇后放置在本行的后移的一个位置
        }
    }
    //查看当放置第n个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){//n表示放第n个皇后 row
        for (int i = 0; i < n; i++) {
            //1.array[i] == array[n]判断是否在同一列
            //2.Math.abs(n-i)==Math.abs(array[n]-array[i])判断第n个皇后是否个第i个皇后是否在同一斜线
            if (array[i] == array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i]))
                return false;

        }
        return true;
    }
    //写一个方法，打印皇后摆放位置
    private void print(){
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
