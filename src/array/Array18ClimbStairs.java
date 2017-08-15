package array;

/**
 * Climbing Stairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top
   
        设f(n)表示爬n阶楼梯的不同方法数，为了爬到第n阶楼梯，两个选择：
        从第n-1阶上1阶
        从第n-2阶上2阶
        f(n)=f(n-1)+f(n-2)
        这是一个斐波那契数列，因此解法如下
 * @author reus
 *
 */
public class Array18ClimbStairs {

    static int climbStairs(int n){
        if(n<=1){ 
            return 1;
        }else if(n==2) {
            return 2;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
    
    static int fibonacci(int n){
        int prev=0;
        int cur=1;
        for(int i=1;i<=n;i++){
            int temp=cur;
            cur+=prev;
            prev=temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(climbStairs(4));
        System.out.println(fibonacci(4));
    }

}
