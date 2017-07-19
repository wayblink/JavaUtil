package string;

public class String2ImplementStr {

    public static int strStr(String haystack,String needle){
        for(int i=0;i<haystack.length();i++){
            int j=0;
            int k=i;
            while(j<needle.length()){
                if(haystack.charAt(k)==needle.charAt(j)){
                    k++;
                    j++;
                }else{
                    break;
                }
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack="abcdefg";
        String needle="cdefg";
        System.out.println(strStr(haystack, needle));
    }

}
