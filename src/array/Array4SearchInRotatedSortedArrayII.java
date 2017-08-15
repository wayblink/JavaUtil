package array;

/**
 * Search in Rotated Sorted Array II
 * 
 * Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
   Would this affect the run-time complexity? How and why?
   Write a function to determine if a given target is in the array.
 * @author way
 *
 */
public class Array4SearchInRotatedSortedArrayII {

    static int searchRotatedSortedArray(int[] arr, int target){
        int first =0;
        int last= arr.length;
        while(first!=last){
            int mid = first+(last-first)/2;
            if(target==arr[mid]){
                return mid;
            }else if(arr[mid]>arr[first]){
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
            }else{
                first++;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr={0,1,1,2,4,6,7,9};
        int flag= searchRotatedSortedArray(arr, 1);
        System.out.println(flag);
    }

}
