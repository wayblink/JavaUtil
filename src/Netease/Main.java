package Netease;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]= sc.nextInt();
//        }
//        
//        print(arr);
//        reverse(arr);
//        print(arr);
//        
//    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        process(a,n);
    }
    
    static void process(int[] a, int n){
        LinkedList<Integer> b = new LinkedList<>();
        boolean flag = true;
        int i = 0;
        while(i<n){
            
            if(flag){
                b.addLast(a[i]);
            }else{
                b.addFirst(a[i]);
            }
            flag = !flag;
            i++;
        }
        
        for(int j=0;j<b.size()-1;j++){
            System.out.print(b.get(j)+" ");
        }
        System.out.print(b.get(b.size()-1));  
    }

}


//static void reverse(int[] arr){
//for(int i=0;i<arr.length/2;i++){
//  int temp = arr[i];
//  arr[i] =arr[arr.length-1-i];
//  arr[arr.length-1-i] = temp;
//}
//}
//
//static void print(int[] arr){
//for(int i=0;i<arr.length;i++){
//  System.out.print(arr[i]+" ");
//}
//}