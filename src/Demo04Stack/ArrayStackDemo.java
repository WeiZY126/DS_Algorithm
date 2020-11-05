package Demo04Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        
    }
}

//定义一个类 表示栈
class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈操作
    public void push(int num){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top] = num;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return top--;
    }
    //遍历栈,遍历是需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i=top;i>0;i--){
            System.out.println(top);
        }
    }
}
