
public class StringUtil {
    
    /**
     * 字符数组转字符串
     * @param arr
     * @return
     */
    String arrayToString(char[] arr){
        return String.copyValueOf(arr);
    }
    
    /**
     * 字符串左旋,"abcd"->"bcda"
     * @param str
     * @return
     */
    static String rotateLeft(String str){
        char[] arr=str.toCharArray();
        char t=arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=t;
        return String.copyValueOf(arr);
    }

    /**
     * 字符串右旋,"abcd"->"dabc"
     * @param str
     * @return
     */
    static String rotateRight(String str){
        char[] arr=str.toCharArray();
        char t=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=t;
        return String.copyValueOf(arr);
    }
    
    /**
     * 左旋n位
     * @param str
     * @param n
     * @return
     */
    static String rotateLeft(String str,int n){
        char[] arr=str.toCharArray();
        String result=str;
        for(int i=0;i<n;i++){
            result=rotateLeft(result);
        }
        return result;
    }
    
    /**
     * 右旋n位
     * @param str
     * @param n
     * @return
     */
    static String rotateRight(String str,int n){
        char[] arr=str.toCharArray();
        String result=str;
        for(int i=0;i<n;i++){
            result=rotateRight(result);
        }
        return result;
    }
    
    /**
     * 字符串翻转
     * @param str
     * @return
     */
    static String reserve(String str){
        char[] arr=str.toCharArray();
        for(int i=0;i<(arr.length%2==1?arr.length/2-1:arr.length/2);i++){
            char temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        return String.copyValueOf(arr);
    }
    
    
    public static void main(String[] args){
        String str="abcdef";
        System.out.println(rotateLeft(str));
    }
}
