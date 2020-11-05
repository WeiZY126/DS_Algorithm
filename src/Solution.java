public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(NumberOf1(2));
    }
    public static int NumberOf1(int n) {
        int sum = 0;
        byte[] num = Integer.toBinaryString(Math.abs(n)).getBytes();
        for(byte n1:num){
            if(n1==49)
                sum++;
        }
        return sum;
    }
}