package array;

/**
 * Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
   If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
   The replacement must be in-place, do not allocate extra memory.
   Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3->1,3,2
    3,2,1->1,2,3
    1,1,5->1,5,1
 * @author reus
 *
 */
public class Array12NextPermutation {

    static void nextPermutation(int[] arr){
        int n=arr.length-1;
        int i=n;
        while(i>=1&&arr[i]<=arr[i-1]){
            i--;
        }
        if(i!=0){
            int temp=arr[i-1];
            arr[i-1]=arr[i];
            arr[i]=temp;        
        }
        reverse(arr, i, n);               
    }
    
    static void reverse(int[] arr,int begin,int end){
        while(begin<end){
            int temp=arr[begin];
            arr[begin]=arr[end];
            arr[end]=temp;
            begin++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,3,4,5,2};
//        reverse(arr, 0, arr.length-1);
        nextPermutation(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
