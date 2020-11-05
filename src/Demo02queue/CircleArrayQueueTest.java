package Demo02queue;

public class CircleArrayQueueTest {

}
class CircleArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾
    private int[] arr;//用于存放数据

    //创建队列构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear +1)%maxSize;
    }

    //数据出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保存到一个临时变量
        //2.将front后移,考虑取模
        //3.返回临时变量
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空,没有数据");
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front;i<front+size();i++){
            System.out.println(arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空,没有数据");
        }
        return arr[front];
    }
}
