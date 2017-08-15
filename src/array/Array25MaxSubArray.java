package array;

public class Array25MaxSubArray {
    public static int brute(int[] a){
        int max=0;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                int temp=0;
                for(int k=i;k<j;k++){
                    temp+=a[k];
                }
                if(temp>max){
                    max=temp;
                }
            }
            
        }
        return max;
    }
    
    public static int dynamic(int[] a){
        int max=0;
        int temp=0;
        for(int i=0;i<a.length;i++){
            if(temp>=0){
                temp+=a[i];
            }else{
                temp=a[i];
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;
        
    }
    
    public static void main(String[] args){
        int[] A = {1,-2,3,10,-4,7,2,10,-5,4};
        System.out.println(brute(A));
        System.out.println(dynamic(A));
    }
}
