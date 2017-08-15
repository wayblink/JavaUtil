package Netease;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        
        System.out.println(max(a));
        
    }
    
    static int max(int[] arr){
        int length = arr.length;
        int res = 0;
        if(length==1){
            return res;
        }
        if(length==2){
            return Math.abs(arr[1]-arr[0]);
        }
        
        res = Math.abs(arr[1]-arr[0]);
        
        for(int i=2;i<length;i++){
            
            int insert = arr[i];

            int max1 = res + Math.abs(insert-arr[0]);
            int max2 = res + Math.abs(insert-arr[i-1]);
            int max, maxFlag;//最大插入位置插入在元素maxFlag之前
            if(max1>max2){
                maxFlag=0;
                max = max1;
            }else{
                maxFlag=i;
                max =max2;
            }

            
            for(int j = 1; j < i+1;j++){
                int tempMax = res - Math.abs(arr[j-1]-arr[j]) + Math.abs(insert-arr[j-1]) + Math.abs(insert - arr[j]);
                if(max<tempMax){
                    max = tempMax;
                    maxFlag = j;
                }
            }
            res = max;

            int k = i;
            
            if(maxFlag==i){
                
            }else{
                while(k>maxFlag){
                    arr[k]=arr[k-1];
                    k--;  
                }
                arr[k+1] = insert;
            }
            
        }
        return res;
        
    }

}
