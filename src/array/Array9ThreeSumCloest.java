package array;

/**
 * 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
   target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
   For example, given array {-1,2,1,-4}, target = 1.
   The sum that is closest to the target is 2. (-1+2+1=2s).
 */
import java.util.Arrays;

public class Array9ThreeSumCloest {

    static int threeSumCloest(int[] arr,int target){
        Arrays.sort(arr);
        int cloestSum=0;
        for(int i=0;i<arr.length-2;i++){
            int low=arr[i];
            int j=i+1,k=arr.length-1;
            int sum = low + arr[j] + arr[k];
            int abs=Math.abs(sum-target);
            while(j<k){
                int tempSum = low +arr[j]+arr[k];
                int tempAbs = Math.abs(tempSum-target);
                if(tempAbs<abs){
                    sum=tempSum;
                }
                if(sum>target){
                    k--;
                }else if(sum<target){
                    j++;
                }else{
                    return target;
                }
            }
            if(Math.abs(sum-target)<Math.abs(cloestSum-target)){
                cloestSum=sum;
            }
        }
        return cloestSum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,9,12};
        System.out.println(threeSumCloest(arr, 10));
    }

}
