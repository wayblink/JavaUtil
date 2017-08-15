package array;

/**
 * Permutation Sequence
 * @author reus
 *
 */
public class Array13PermutationSequence {

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
    
    static int[] permutationSequence(int n,int k){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        for(int i=0;i<k;i++){
            nextPermutation(arr);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr=permutationSequence(5, 4);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
