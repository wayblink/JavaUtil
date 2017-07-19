package array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
   how much water it is able to trap after raining.
   For example, Given {0,1,0,2,1,0,1,3,2,1,2,1}, return 6.

 * @author reus
 *
 */
public class Array15TrappingRainWater {

    static int trappingRainWater(int[] arr){
        if(arr.length<3){
            return 0;
        }
        int sum =0;
        for(int i=1;i<arr.length-1;i++){
            int max_left=max(arr,0,i-1);
            int max_right=max(arr,i+1,arr.length-1);
            int min_max=Math.min(max_left, max_right);
            if(min_max>arr[i]){
                sum+=(min_max-arr[i]);
            }
        }
        return sum;
    }
    
    static int max(int[] arr,int begin,int end){
        int max = arr[begin];
        for(int i=begin;i<=end;i++){
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater(arr));
    }

}
