package string;

public class String6SubStringContain {
    
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
    
    public static void main(String[] args){
        String str1="abcdef";
        String str2="def";
        System.out.println(brute(str1,str2));
        System.out.println(str1.indexOf(str2));
    }
}
