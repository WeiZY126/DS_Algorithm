package Algorithm.Demo01BinarySearch;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        int[] arr ={1,3,8,10,11,67,100};
        System.out.println(binarySearch(arr,18));
    }

    public static int binarySearch(int arr[], int target) {

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
