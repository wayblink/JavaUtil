package string;

/**
 * 
 * Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).
   For example,
   Input:
      110 11
   Return:
      1001

 * @author reus
 *
 */
public class String4AddBinary {

    public static String addBinary(String str1,String str2){
        int carry=0;
        int i=str1.length()-1;
        int j=str2.length()-1;
        StringBuffer sb=new StringBuffer();
        while(i>=0||j>=0){
            if(i>=0){
                carry+=str1.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                carry+=str2.charAt(j)-'0';
                j--;
            }
            sb.append(Integer.toString(carry%2));
            carry=carry/2;
        }
        if(carry==1){
            sb.append(Integer.toString(1));
        }
        return sb.reverse().toString();
        
    }
    
    public static void main(String[] args) {
        String str1="110";
        String str2="11";
        System.out.println(addBinary(str1, str2));
    }

}
