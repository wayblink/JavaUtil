package array;

/**
 * Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once
   and return the new length.
   Do not allocate extra space for another array, you must do this in place with constant memory.
   For example, Given input array {1,1,2,3,4,4,5},
   Your function should return length = 5, and A is now {1,2,3,4,5}.
 * @author way
 *
 */

public class Array1RemoveDuplicatesfromSortedArray {

    static int removeDuplicates(int[] arr){
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                arr[++i]=arr[j];
            }
        }
        return i+1;
    }
    
    public static void main(String[] args){
        int[] arr={1,1,2,3,4,4,5};
        int tail = removeDuplicates(arr);
        for(int i=0;i<tail;i++){
            System.out.println(arr[i]);
        }        
    }
}
