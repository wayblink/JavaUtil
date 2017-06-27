
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
    
    /**
     * 从字符串中删除与传入参数字符串匹配的字符串
     * @param input
     * @param flag
     * @return
     */
    public static String deleteFlag(String input,String flag){
        StringBuilder sb=new StringBuilder();
        int step=flag.length();
        int i=0,j=i+step;
        int n=input.length();
        while(i<n&&j-i==step){
            if(input.substring(i,j).equals(flag)){
                i+=step;
                j+=step;
            }else{
                sb.append(input.substring(i,j));
                i+=step;
                j+=step;
            }
            if(j>n){    
                j=n;
            }
        }
        return sb.toString();
    }
    
    
    /**
     * 判断两个字符串是否相互包含
     * @param source 包含字符串
     * @param target 被包含字符串
     * @return 返回真价值
     * 实际上Java中已经有了String.indexOf(String str);String.lastIndexOf(String str);方法
     * 这个函数只是一个算法尝试
     */
    public static boolean brute(String source,String target){
        char[] s=source.toCharArray();
        char[] t=target.toCharArray();
        
        int m=source.length();
        int n=target.length();
        
        for(int i=0;i<=m-n;i++){
            int j=0;
            while(j<n&&i+j<m&&s[i+j]==t[j]){
                //需要注意的是不能把第三个判断项放在前面，否则会数组越界
                //由此可深入理解，&&运算是有次序的，如果前面false后面不会再算
                j++;
            }
            if(j==n){
                return true;
            }
        }
        return false;
    }
}
