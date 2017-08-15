package array;


/**
 *  Remove Duplicates from Sorted Array II
 *  
 *  Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?
    For example, Given sorted array [1,1,1,2,2,3],
    Your function should return length = 5, and A is now 1,1,2,2,3
 * @author way
 *
 */
public class Array2RemoveDuplicatesfromSortedArrayII {

    static int removeDuplicatesMoreThan2(int[] arr){
        int i=1;
        for(int j=2;j<arr.length;j++){
            if(arr[j]==arr[i]&&arr[j]==arr[i-1]){
            }else{
                arr[++i]=arr[j];
            }
        }
        return i+1;
    }
    
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3,4,4,4,5};
        int tail=removeDuplicatesMoreThan2(arr);
        for(int i=0;i<tail;i++){
            System.out.println(arr[i]);
        }
    }
}
