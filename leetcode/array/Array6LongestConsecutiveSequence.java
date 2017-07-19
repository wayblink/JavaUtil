package array;

/**
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    For example, Given {100,4,200,1,3,2}, The longest consecutive elements sequence is {1,2,,3,4}. 
    Return its length: 4.
    Your algorithm should run in O(n) complexity.
 */
import java.util.HashSet;
import java.util.Set;

public class Array6LongestConsecutiveSequence {

    static int longestConsecutiveSequence(int[] arr){
        Set<Integer> set=new HashSet<>();       
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int longest=0;
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            while(set.contains(temp)){
                temp++;
            }
            int tempLongest=temp-arr[i];
            if(longest<tempLongest){
                longest=tempLongest;
            }
        }
        return longest;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequence(arr));
    }

}
