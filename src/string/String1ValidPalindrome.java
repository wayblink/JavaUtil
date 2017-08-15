package string;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
   For example,
    "A man, a plan, a canal: Panama"is a palindrome.
    "race a car" is not a palindrome.
   Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
   For the purpose of this problem, we define empty string as valid palindrome.
 * @author reus
 *
 */
public class String1ValidPalindrome {

    public static boolean validPalindorme(String str){
        if(str==null){
            return false;
        }
        int n=str.length();
        int left=0;
        int right=n-1;
        while(left<right){
            while(!(str.charAt(left)<='z'&&str.charAt(left)>='a'||str.charAt(left)>='A'&&str.charAt(left)<='Z')){
                left++;
            }
            while(!(str.charAt(right)<='z'&&str.charAt(right)>='a'||str.charAt(right)>='A'&&str.charAt(right)<='Z')){
                right--;
            }
            if(str.charAt(left)==str.charAt(right)||Math.abs(str.charAt(left)-str.charAt(right))==('a'-'A')){
                left++;
                right--;
            }else{
                return false;
            }           
        }
        return true;
        
    }
    
    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
//        String str="abA ,b";
        System.out.println(validPalindorme(str));
    }

}
