package Demo03LinkedList;

public class JosephuTest {
    public static void main(String[] args) {
        CircleSingleLinkedList csl = new CircleSingleLinkedList();
        csl.addBoy(5);
        csl.showBoy();
        csl.countBoy(1,2,5);
    }
}
//创建一个环形单向链表
class CircleSingleLinkedList{
    private Boy first;//创建一个first节点，当前没有编号
    //添加小孩节点,构建成一个环形链表
    public void addBoy(int nums){
        //nums做一个数据校验
        if (nums<=2){
            System.out.println("nums数据不正确");
            return;
        }
        Boy curBoy = null;//辅助变量，帮助构建环形链表
        //使用for循环，创建环形链表
        for (int i =1;i<=nums;i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i==1){
                first = boy;
                first.setNext(first);
                curBoy = first;//让curBoy指向第一个小孩
                continue;
            }
            curBoy.setNext(boy);
            boy.setNext(first);
            curBoy=boy;
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        //判断是否为空
        if (first==null){
            System.out.println("没有任何小孩");
            return;
        }
        //因为first不能动，因此仍然使用辅助指针完成遍历
        Boy curBoy = first;
        do {
            System.out.println("小孩编号"+curBoy.getNo());
            curBoy = curBoy.getNext();
        }while (curBoy!=first);
    }
    //根据用户的输入，计算出出圈顺序
    public void countBoy(int startNo,int countNum,int nums){//nums:表示最初有多少小孩在圈中
        //先对数据进行校验
        if (first == null||startNo<1||startNo>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        while (true){
            if (helper.getNext()==first){//说明helper指向最后
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper==first){//说明圈中只有一个人
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩
            System.out.println(first.getNo()+"小孩出圈");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号"+first.getNo());
    }
}
//创建一个boy类 表示一个节点
class Boy{
    private int no;//编号
    private Boy next;//指向写一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
