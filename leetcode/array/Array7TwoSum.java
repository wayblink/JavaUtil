package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Array7TwoSum {

    //只需要是否存在
    static boolean hasTwoSum(int[] arr,int target){
        Set<Integer> set =new HashSet<>();  
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        
        for(int i=0;i<arr.length;i++){
            if(set.contains(target-arr[i])){
                return true;
            }
        }
        return false;
    }
    
    //需要下标
    
    static int[] indexTwoSum(int[] arr, int target){
        HashMap<Integer,Integer> map =new HashMap<>();  
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                int[] result={i,map.get(target-arr[i])};
                return result;
            }
        }
        return new int[]{-1,-1}; 
    }
    
    
    
    public static void main(String[] args){
        int[] arr={1,4,5,7,32,34,5};
        System.out.println(hasTwoSum(arr, 100));
        System.out.println(indexTwoSum(arr, 7)[0]);
        System.out.println(indexTwoSum(arr, 7)[1]); 
    }
}
