package Demo01sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：没有子 1：黑子 2：蓝子
        int cheseArr1[][] = new int[11][11];
        cheseArr1[1][2] = 1;
        cheseArr1[2][3] = 2;
        cheseArr1[5][6] = 2;
        System.out.println("原始的二维数组");
        for (int[] ints : cheseArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        //先遍历二维数组，得到非0数据个数
        int sum = 0;
        for (int[] ints1 : cheseArr1) {
            for (int i1 : ints1) {
                if (i1 != 0)
                    sum++;
            }
        }
        //创建稀疏数组
        int sparseArray[][] = new int[sum+1][3];

        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历二维数组 将非0的值存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (cheseArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = cheseArr1[i][j];
                }
            }
        }

        System.out.println("得到稀疏数组：");
        for (int k = 0; k < sparseArray.length; k++) {
            System.out.println(sparseArray[k][0]+" "+sparseArray[k][1]+" "+sparseArray[k][2]);
        }

        //将稀疏数组恢复成原始二维数组
        int cheseArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1;i<sparseArray.length;i++){
            cheseArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] o : cheseArray2) {
            for (int p : o) {
                System.out.print(p+" ");
            }
            System.out.println();
        }
    }


}
