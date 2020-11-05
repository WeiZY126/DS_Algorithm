package Algorithm.Demo02Divide;

public class HanoiTower {
    static int sum=0;
    public static void main(String[] args) throws Exception {
        hanoiTower(5,'A','B','C');
    }
    public static void hanoiTower(int num,char a,char b,char c){
        System.out.println(++sum);
        if (num==1)
            System.out.println("第1个盘从"+a+"->"+c);
        else {
            //1.先把最上面的盘A->B,移动过程会使用到c
            hanoiTower(num-1,a,c,b);
            //2.把最下面的盘A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3.把B塔的所有盘B->C
            hanoiTower(num-1,b,a,c);

        }
    }
}
