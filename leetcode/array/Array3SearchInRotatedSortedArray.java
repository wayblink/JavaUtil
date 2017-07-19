package array;

/**
 * Search in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
   (i.e., 0,1,2,3,4,5,6,7 might become 4,5,6,7,0,1,2,3).
   You are given a target value to search. If found in the array return its index, otherwise return -1.
   You may assume no duplicate exists in the array.
 * @author way
 *
 */
public class Array3SearchInRotatedSortedArray {

    static int searchRotatedSortedArray(int[] arr, int target){
        int first =0;
        int last= arr.length;
        while(first!=last){
            int mid = first+(last-first)/2;
            if(target==arr[mid]){
                return mid;
            }else if(arr[mid]>=arr[first]){
                if(target<arr[mid]&&target>=arr[first]){
                    last=mid;
                }else{
                    first=mid+1;
                }
            }else if(arr[mid]<arr[first]){
                if(target>arr[mid]&&target<=arr[last-1]){
                    first=mid+1;
                }else{
                    last=mid;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr={4,6,7,9,0,1,2};
        int flag= searchRotatedSortedArray(arr, 1);
        System.out.println(flag);
    }

}
