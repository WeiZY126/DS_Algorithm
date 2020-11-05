package Demo03LinkedList;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        System.out.println("测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 hero4 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(4, "关胜", "大刀");

        DoubleLinkedList db = new DoubleLinkedList();
        db.add(hero1);
        db.add(hero2);
        db.add(hero3);
        db.add(hero4);
        db.add(hero5);
        db.add(hero6);

        db.list();
        //修改测试
        HeroNode2 hero7 = new HeroNode2(4,"zs","zs");
        db.update(hero7);
        System.out.println("修改后");
        db.list();
        //删除
        db.del(4);
        System.out.println("删除后");
        db.list();
    }
}
//创建一个双向链表的类
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
    //遍历
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
    //添加,默认添加到最后
    public void addU(HeroNode2 heroNode) {
        //head节点不能动，所以需要一个辅助变量temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没找到，就将temp后移
            temp = temp.next;
        }
        //退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改一个节点的内容
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode2 temp = head.next;
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

    //删除一个节点
    //对于双向链表，我们可以直接找到要删除的节点
    //找到后自我删除即可
    public void del(int no){
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                System.out.println("没有找到删除的节点");
                break;
            }
            else if (temp.no == no){
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    //代码有问题，如果删除最后节点，就不需要执行下面这句话，否则会有空指针异常
                    temp.next.pre = temp.pre;
                }
                System.out.println("删除成功");
                break;
            }
            temp = temp.next;
        }

    }

    public void add(HeroNode2 hero){
        if (head.next==null){
            head.next=hero;
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (hero.no == temp.no){
                System.out.println("节点id已存在");
                return;
            }
            if (temp.next == null){
                temp.next = hero;
                hero.pre=temp;
                return;
            }
            if (hero.no > temp.no && hero.no<temp.next.no){
                hero.pre = temp;
                hero.next = temp.next;
                temp.next.pre = hero;
                temp.next = hero;
                return;
            }
            temp = temp.next;
        }
    }


    public HeroNode2 getHead(){
        return head;
    }
}
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
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

