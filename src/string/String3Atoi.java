package string;

public class String3Atoi {

    public final static int INT_MAX=Integer.MAX_VALUE;
    public static int String2Int(String str){
        int num=0;
        if(str.charAt(0)=='-'){
            return -String2Int(str.substring(1));
        }
        for(int i=0;i<str.length();i++){
            int n=str.charAt(i)-'0';
            if(num>INT_MAX/10||num==INT_MAX/10&&n>INT_MAX%10){
                return INT_MAX;
            }
            num=10*num+n;
        }
        return num;
    }
    
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        String str="2147483648";
        System.out.println(String2Int(str));
    }

}
