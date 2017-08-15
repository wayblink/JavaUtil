package array;

/**
 * Find the kth biggest number in two sorted array
 * @author reus
 *
 */
public class Array5FindKthNumberInTwoSortedArray {

    static int findKthSortedArrays(int A[], int astart, int aend,  
            int B[], int bstart, int bend, int k) {  
        int m = aend - astart, n = bend - bstart;  
        if (m < n) {  
            return findKthSortedArrays(B, bstart, bend, A, astart, aend, k);  
        }  
        if (n == 0)  
            return A[astart + k - 1];  
        if (k == 1)  
            return Math.min(A[astart], B[bstart]);  

        int pb = Math.min(k / 2, n), pa = k - pb;  
        if (A[astart + pa - 1] > B[bstart + pb - 1])  
            return findKthSortedArrays(A, astart, aend, B, bstart + pb, bend, k - pb);  
        else if (A[astart + pa - 1] < B[bstart + pb - 1])  
            return findKthSortedArrays(A, astart + pa, aend, B, bstart, bend, k - pa);  
        else  
            return A[astart + pa - 1];  
    } 
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a={1,3,5,7,9};
        int[] b={2,4,6,8};
        System.out.println(findKthSortedArrays(a, 0, 5, b, 0, 4, 5));
    }

}
