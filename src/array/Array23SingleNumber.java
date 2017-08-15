package array;

/**
 * Single Number
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
extra memory?

   异或运算，相同两数异或得零，异或运算可以交换次序
 * @author reus
 *
 */
public class Array23SingleNumber {

    public static int singleNum(int[] arr){
        int result=0;
        for(int i=0;i<arr.length;i++){
            result^=arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,3,5,2,3,1,2};
        System.out.println(singleNum(arr));
    }

}
