package array;

/**
 *  Remove Element
 *  
 *  Given an array and a value, remove all instances of that value in place and return the new length.
 *  The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
 * @author reus
 *
 */
public class Array11RemoveElements {

    static int removeElements(int[] arr,int target){
        int i=0;
        int j=0;
        int removeNum=0;
        while(i<arr.length){
            if(arr[i]!=target){
                arr[j++]=arr[i++];
            }else{
                removeNum++;
                i++;
            }
        }
        return arr.length-removeNum;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,6,3,2,4,6};
        System.out.println(arr.length);
        System.out.println(removeElements(arr, 2));
    }

}
