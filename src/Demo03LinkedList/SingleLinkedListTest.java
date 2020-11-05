package Demo03LinkedList;

import java.util.Stack;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero4 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(4, "关胜", "大刀");


        //创建一个链表
        SingleLinkedList sll = new SingleLinkedList();

        //加入
        sll.addNo(hero1);
        sll.addNo(hero2);
        sll.addNo(hero3);
        sll.addNo(hero4);
        sll.addNo(hero5);
//        sll.del(1);
//        System.out.println(sll.getlength(sll.getHead()));
//
//        HeroNode hero7 = new HeroNode(4, "zx", "yyy");
//        sll.update(hero7);
//        //显示
        sll.list();
//        System.out.println(SingleLinkedList.findLastNode(hero1,2).toString());
        System.out.println("++++");
//        SingleLinkedList.print(sll.getHead());
    }
}


//定义SingleLinkedList管理英雄
class SingleLinkedList {
    //先初始化一个头结点，头结点不要动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到单链表
    //思路：当不考虑编号的顺序时
    //找到当前链表的最后节点
    //将最后这个节点的next指向新节点
    public void add(HeroNode heroNode) {
        //head节点不能动，所以需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没找到，就将temp后移
            temp = temp.next;
        }
        //退出while循环时，temp就指向了链表的最后
        //将最后的节点next指向新节点
        temp.next = heroNode;
    }

    public void addNo(HeroNode heroNode) {
        //head节点不能动，所以需要一个辅助变量temp
        HeroNode temp = head;
        boolean flag = false;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null)
                break;
            else if (temp.no == heroNode.no) {//说明希望添加的heroNode已经存在
                flag = true;
                break;
            } else if (temp.next.no > heroNode.no) {
                break;
            }
            //如果没找到，就将temp后移
            temp = temp.next;
        }
        if (flag) {
            System.out.println("添加的编号已经存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //根据编号修改节点，no不能修改
    //根据newHeroNode的no修改即可
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没找到节点");
        }

    }

    //删除节点
    public void del(int no){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                System.out.println("没有找到删除的节点");
                break;
            }
            else if (temp.next.no == no){
                temp.next = temp.next.next;
                System.out.println("删除成功");
                break;
            }
            temp = temp.next;
        }

    }


    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
//求单链表节点个数
    public static int getlength(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return 0;
        }
        //因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        int count = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            count++;
            //将temp后移
            temp = temp.next;
        }
        return count;
    }



//求单链表的倒数第k个节点
    //编写一个方法，接受head节点，同时接受一个index
    //index表示倒数第index个节点
    //链表从头到尾遍历，得到总长度
    //得到size后从链表的第一个开始遍历，遍历（size-index）个
    //如果找到，返回该节点，否则返回空
    public static HeroNode findLastNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if (head.next == null){
            return null;//没有找到
        }
        //第一次遍历得到节点的个数
        int size = getlength(head);
        //第二次遍历 size-index位置，就是倒数第k个节点
        //先做一个index的校验
        if (index <= 0 || index>size){
            return null;
        }
        //定义一个辅助变量,for循环定位到倒数index个
        HeroNode cur = head.next;
        for (int i = 0;i<size-index;i++){
            cur = cur.next;
        }
        return cur;
    }

    //将单链表翻转
    public static HeroNode reversetList(HeroNode head){
        //如果当前链表为空，或只有一个节点，无需翻转，直接返回
        if (head.next == null ||head.next.next == null){
            return null;
        }
        //定义一个辅助指针（变量）,帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0,null,null);
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead最前端
        while (cur!=null){
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;
            cur = next;//让cur后移
        }
        //
        head.next = reverseHead.next;
        return head;
    }

    //
    public static void print(HeroNode h) {
        if (h ==null||h.next == null){
            System.out.println("没有值");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = h.next;
        while (cur.next!=null){
            stack.push(cur.next);
            cur = cur.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop().toString());
        }
    }

}

//定义一个heronode，每个heronode是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
