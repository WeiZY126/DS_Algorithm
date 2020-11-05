package Demo02queue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
        aq.addQueue(20);
        aq.addQueue(20);
        aq.addQueue(20);
        aq.addQueue(20);
        System.out.println(aq.headQueue());
    }
}
//使用数组模拟队列，编写ArrayQueue类
class ArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾
    private int[] arr;//用于存放数据

    //创建队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，front在队列头的前一个位置
        rear = -1;//指向队列尾部，指向队列尾的具体数据（即就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[++rear] = n;
    }

    //数据出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空,没有数据");
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空,没有数据");
        }
        return arr[front+1];
    }
}
