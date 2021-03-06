package com.way.sort;

/** Util class for sort algorithms */
public class SortUtil {
    
    /** bubble sort 
     *  冒泡排序 
     */
    public static void bubbleSort(int[] a){
        int temp;
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    
    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        int min;
        int temp;
        
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i){
                temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }
    
    public static void insertionSort(int[] arr){
        int i,j,temp;
        for(i=1;i<arr.length;i++){
            temp=arr[i];
            j=i-1;
            while(j>=0&&temp<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    
    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        int i,j;
        int r,temp;
        for(r=arr.length/2;r>=1;r/=2){
            for(i=r;i<arr.length;i++){
                temp=arr[i];
                j=i-r;
                while(j>=0&&temp<arr[j]){
                    arr[j+r]=arr[j];
                    j-=r;
                }
                arr[j+r]=temp;
            }
        }
    }
    
    /**
     * Simple function for quicksort
     * @param arr
     */
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    
    /**
     * quick sort with the middle element as the flag
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        int f,t;
        int rtemp,ltemp;
        
        ltemp=left;
        rtemp=right;
        f=arr[(left+right)/2];
        
        while(ltemp<rtemp){
            while(arr[ltemp]<f){ ++ltemp; }
            while(arr[rtemp]>f){ --rtemp; }
            t=arr[ltemp];
            arr[ltemp]=arr[rtemp];
            arr[rtemp]=t;
            --rtemp;
            ++ltemp;
        }
        if(ltemp==rtemp){ ltemp++; }
        
        if(left<rtemp){ quickSort(arr, left, ltemp-1); }
        
        if(ltemp<right){ quickSort(arr, rtemp+1, right); }
    }
    
    /**
     * quick sort with the head element as the flag
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] a,int left,int right){
        int tleft=left;
        int tright=right;
        int flag=a[tleft];
        while(tleft<tright){
            while(a[tright]>flag){
                tright--;
            }
            a[tleft]=a[tright];
            while(a[tleft]<flag){
                tleft++;
            }
            a[tright]=a[tleft];
        }
        a[tleft]=flag;
        
        if(tleft>left)
            quickSort2(a,left,tleft-1);
        if(tleft<right)
            quickSort2(a,tleft+1,right);
    } 
    
    /**
     * simple function for heap sort 
     * @param a
     */
    public static void heapSort(int[] a){
        heapSort(a,a.length);
    }
    
    public static void heapSort(int[] a,int n){
        int i,j,k;
        for(i=n/2-1;i>=0;i--){
            while(2*i+1<n){
                j=2*i+1;
                if((j+1)<n&&a[j]<a[j+1])
                    j++;
                if(a[i]<a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                    i=j;
                }else{
                    break;
                }
            }
        }        
                
        for(i=n-1;i>0;i--){
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            k=0;
            while(2*k+1<i){
                j=2*k+1;
                if((j+1)<i&&a[j]<a[j+1])
                    j++;
                if(a[k]<a[j]){
                    temp=a[k];
                    a[k]=a[j];
                    a[j]=temp;
                    k=j;
                }else{
                    break;
                }
            }
        }
    }
            
    /**
     * simple function for merge sort
     * @param a
     */
    public static void mergeSort(int[] a){
        mergeSort(a, 0,a.length-1);
    }
    
    public static void mergeSort(int[] arr,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            mergeSort(arr, low,mid);//归并排序前半部分
            mergeSort(arr,mid+1,high);//归并排序后半部分
            merge(arr,low,mid,high);//合并两部分
        }
    } 
       
    /**
     * 合并算法
     * @param arr
     * @param low 左边界
     * @param mid 分界
     * @param high 右边界
     */
    public static void merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low; //左指针
        int j=mid+1; //右指针
        int t=0; //新数组指针
        while(i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[t++]=arr[i++];
            }else{
                temp[t++]=arr[j++];
            }
        }       
        while(i<=mid){
            temp[t++]=arr[i++];
        }
        while(j<=high){
            temp[t++]=arr[j++];
        }
        for(int k=0;k<temp.length;k++){
            arr[k+low]=temp[k];
        }
    }
      
    /**
     * output the array 
     * only used for test
     * @param a
     */
    public static void printArr(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
