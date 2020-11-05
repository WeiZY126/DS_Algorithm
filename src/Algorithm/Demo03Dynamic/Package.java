package Algorithm.Demo03Dynamic;

public class Package {
    public static void main(String[] args) throws Exception {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4;//背包容量
        int n = val.length;//物品个数
        //创建二维数组
        int v[][] = new int[n + 1][m + 1];
        //记录商品存放情况
        int path[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            v[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            v[0][j] = 0;
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (w[i - 1] <= j) {
//                    v[i][j] = Math.max(v[i-1][j], val[i-1] + v[i - 1][j - w[i-1]]);
                    if (v[i - 1][j] > val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }
                } else {
                    v[i][j] = v[i - 1][j];
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        //输出最后放入的是哪些商品
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品放入背包");
                j = j - w[i - 1];
            }
            i--;
        }
    }
}
