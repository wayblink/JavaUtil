package array;

/**
 * 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique
   triplets in the array which gives the sum of zero.
   Note:
• Elements in a triplet (a, b, c) must be in non-descending order. (ie, a ≤ b ≤ c)
• The solution set must not contain duplicate triplets.
  For example, given array (-1,0,1,2,-1,4).
  A solution set is:
  (-1,0,1)
  (-1,-1,2)
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Array8ThreeSum {

    static ArrayList<ArrayList<Integer>> threeSum(int[] arr,int target){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> resultSet=new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            int low=arr[i];
            int j=i+1,k=arr.length-1;
            while(j<k){
                if(arr[j]+arr[k]==target-low){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(low);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    resultSet.add(temp);
                    k--;
                }else if(arr[j]+arr[k]>target-low){
                    k--;
                }else{
                    j++;
                }
            }
            
        }
        return resultSet;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,9,12};
        ArrayList<ArrayList<Integer>> resultSet=threeSum(arr, 9);
        System.out.println(resultSet.size());
        for(int i=0;i<resultSet.size();i++){
            ArrayList<Integer> temp=resultSet.get(i);
            for(int j=0;j<temp.size();j++){
                System.out.println(temp.get(j));
            }
        }
    }

}
