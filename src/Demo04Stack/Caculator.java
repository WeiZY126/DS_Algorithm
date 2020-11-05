package Demo04Stack;

public class Caculator {

    public static void main(String[] args) {
        //根据思路，完成表达式运算
        String expression = "70+2*6-4";
        //创建一个数栈一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index=0;//用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';//将每次扫描得到的char保存到ch
        String keepNum = "";
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch类型
            if (operStack.isOper(ch)) {//如果是运算符
                if (!operStack.isEmpty()) {
                    //如果当前操作符优先级小于等于符号栈中操作符，就需要取出两树运算
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        //然后将当前操作符入栈
                        operStack.push(ch);
                    } else
                        operStack.push(ch);
                } else {
                    //如果为空，直接进栈
                    operStack.push(ch);
                }
            } else { //如果是数字
                //当处理多位数时，不能发现一个数就立即入栈，因为可能是多位数
                //在处理时，需要向表达式后再看一位，如果是数，不能马上入栈
                //因此需要定义一个字符串变量用于拼接


                keepNum +=ch;
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }
//                numStack.push(ch-48);
            }
            //让index加一，并判断是否扫描到expression最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //当扫描完毕，就顺序取出栈内元素运算
        while (true){
            if (operStack.isEmpty()){//当符号栈为空，则计算到最后的结果，数栈中只有一个数字
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }
}
//创建一个栈，使用前面创建好的
 class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//表示栈顶，初始化为-1

    public ArrayStack2(int maxSize) {
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
        return stack[top--];
    }
    //遍历栈,遍历是需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i=top;i>0;i--){
            System.out.println(stack[top]);
        }
    }

    //返回运算级的优先级，是程序员来确定，优先级使用数字表示，数字越大，则优先级越高
    public int priority(int oper){
        if (oper == '*' || oper =='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;//假定目前表达式只有加减乘除
        }
    }
    //判断是不是运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;//用于存放计算结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
    //可以返回当前栈顶的值但不出栈
    public int peek(){
        return stack[top];
    }
}
