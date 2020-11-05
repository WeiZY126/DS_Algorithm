package Demo04Stack;

public class MiGong {
    public static void main(String[] args) {
        //先创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        // 上下全为1
        for (int i = 0; i < 8; i++) {
            map[i][0] =1;
            map[i][6]=1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] =1;
            map[7][i]=1;
        }
        map[3][1]=map[3][2]=1;
        map[5][3]=map[5][4]=map[5][5]=1;

        //使用递归回溯给小球找路
        setWay(map,1,1);
        for(int i1[]:map){//查看地图情况
            for (int i2:i1)
                System.out.print(i2+" ");
            System.out.println();
        }
    }
    //使用递归回溯给小球找路
    //map表示地图
    //i,j表示从地图哪个位置开始出发（1,1）
    //如果小球能到map[6][5]，则说明通路找到
    //约定：当map[i][j]=0 表示该点没有走过，当为1时表示墙，当为2时表示通路可以走，当为3表示该点已经走过但是走不通
    //在走迷宫时，需要确定一个策略（方法）下-->右-->上-->左，如果该点走不通，再回溯
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2)
            return true;
        else {
            if (map[i][j]==0){//如果当前这个点还没有走过
                //按照策略
                map[i][j]=2;//假定该点可以走通
                if (setWay(map,i+1,j)){//向下走
                    return true;
                }else if (setWay(map,i,j+1)) {
                    return true;
                }else if (setWay(map,i-1,j)) {
                    return true;
                }else if (setWay(map,i,j-1)) {
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            }else { //如果map[i][j]!=0，map可能是1,2,3
                return false;
            }
        }
    }
}
