package array;

/**
 * Single Number II
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one. 
　　Note: 
　　Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

   方法一：考虑全部用二进制表示，如果我们把 第ith个位置上所有数字的和对3取余，那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0). 
   因此取余的结果就是那个 “Single Number”。一个直接的实现就是用大小为 32的数组来记录所有位上的和。 
   
 
 * @author reus
 *
 */
public class Array24SingleNumberII {

    public int singleNumber(int[] nums) {

        int[] count = new int[32];
        int result = 0;

        for (int i = 0; i < 32; i++) {
            for (int n : nums) {
                // 统计第i位的1的个数
                if (((n >> i) & 1) == 1) {
                    count[i]++;
                }
            }

            result |= (count[i] % 3) << i;
        }

        return result;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
