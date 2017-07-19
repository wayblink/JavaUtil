package array;

/**
 * 
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * !!
 * @author reus
 *
 */
public class Array17PlusOne {

    
    public int[] plusOne(int[] digits) {
        
        //数字加一
        boolean carryFlag = false;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + (carryFlag ? 1 : 0);
            if (digits[i] >= 10) {
                carryFlag = true;
                digits[i] -= 10;
            } else {
                carryFlag = false;
                break;
            }
        }
        
        //判断是否有溢出位
        if (carryFlag) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++){
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
    
    public static void main(String[] args){
        
    }
}
