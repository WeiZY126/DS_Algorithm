package Demo07search;

public class Demo01SeqSearch {
    public static void main(String[] args) throws Exception {
        int arr[]={1,9,245,-21,42};//没有顺序的数组

    }

    public static int SeqSearch(int[] arr,int value){
        //线性查找是逐一比对，发现有相同的值时，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value)
                return i;
        }
        return -1;
    }
}
