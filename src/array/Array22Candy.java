package array;

/**
 * Candy
 * 
 * There are N children standing in a line. Each child is assigned a rating value.

   You are giving candies to these children subjected to the following requirements:

   Each child must have at least one candy.
   Children with a higher rating get more candies than their neighbors.
   What is the minimum candies you must give?

       初始化每个孩子一个糖果；

      从左往右扫描，保证每个rating高的孩子比其左邻居孩子糖果多；

      从右往左扫描，保证每个rating高的孩子比其右邻居孩子糖果多，这时必须要做max操作。

 * @author reus
 *
 */
public class Array22Candy {

    public int minCandy(int[] ratings){
        int[] candy=new int[ratings.length];
        for(int i=0;i<candy.length;i++){
            candy[i]=1;
        }
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]++;
            }
        }
        
        for(int j=ratings.length-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                candy[j]=Math.max(candy[j], candy[j+1]+1);
            }
        }
        
        int sum=0;
        for(int i=0;i<ratings.length;i++){
            sum+=candy[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
    }

}
