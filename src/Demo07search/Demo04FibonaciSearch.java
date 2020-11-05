//package Demo07search;
//
//import java.util.Arrays;
//
//public class Demo04FibonaciSearch {
//    private static int maxSize = 20;
//    public static void main(String[] args) throws Exception {
//        int arr[] = {1,8,10,89,1000,1234};
//    }
//
//    //因为后面mid = low+F(K-1)-1，需要使用斐波那契数列，所以需要先获得一个斐波那契数列
//    //用非递归方法
//    public static int[] fib(){
//        int[] f = new int[maxSize];
//        f[0] = 1;
//        f[1] = 1;
//        for (int i = 2;i<maxSize;i++){
//            f[i] = f[i-1]+f[i-2];
//        }
//        return f;
//    }
//
//    //编写斐波那契查找算法
//    public static int fibSearch(int[] a,int key){
//        int low = 0;
//        int high = a.length-1;
//        int k = 0;//表示斐波那契分隔数值的下标
//        int mid = 0;
//        int f[] = fib();//获取到斐波那契数列
//        //获取到斐波那契分隔数值的下标
//        while (high>f[k]-1){
//            k++;
//        }
//        //因为f[k]值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a
//        //不足的部分会用0填充
//        int[] temp = Arrays.copyOf(a,f[k]);
//        //实际上需要使用a数组的最后的数填充temp
//        for (int i = high+1;i<temp.length;i++){
//            temp[i] = a[high];
//        }
//
//        //使用while循环处理，找到数key
//        while (low<=high){  //只要这个条件满足，就可以找
//            mid=low+f[k-1]-1;
//            if (key<temp[mid]){//我们应该继续向数组的前面查找
//                high = mid-1;
//                //1.全部元素=前面的元素+后边的元素
//                //2.f[k] = f[k-1]+f[k-2]
//                //因为前面有f[k-1]个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
//                //即在f[k-1]的前面继续查找 k--
//                //即下次循环mid=f[k-1-1]-1
//                k--;
//            }else if (k>temp[mid]){//应该继续向数组后面查找（右边）
//                low = mid +1;
//                k-=2;
//            }
//        }
//    }
//}
