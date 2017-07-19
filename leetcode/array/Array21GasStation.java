package array;

/**
 * 
 * Gas Station
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
   You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
   You begin the journey with an empty tank at one of the gas stations.
   Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 给出提高的算法：方法主要思想是把这个圈划分成一个个的负序列，以及一个正序列（如果存在的话）。
 * 从任意一个站出发，我们可以累加油的净余量，如果出现负的，序列结束，开启一个新的，并且证明旧的这个序列的起点不能作为起点，因为会出现负油量，不能继续前进。
 * 而且不仅这个负序列的起点不能作为起点，负序列中的任意一点都不能作为起点。
 * @author reus
 *
 */
public class Array21GasStation {

    public static int canCompleteCiruit(int[] gas,int[] cost){
        for(int i=0;i<gas.length;i++){
            int curgas=gas[i];
            int j=i;
            while(curgas>=cost[j]){
                curgas-=cost[j];
                j=(j+1)%gas.length;
                if(j==i)
                    return i;
                curgas+=gas[j];
            }
        }
        return -1;        
    }
    
    
    public int canCompleteCircuit(int[] gas, int[] cost) {  
        int sum = 0;  
        int total = 0;  
        int j = -1;  
        for (int i = 0; i < gas.length; i++) {  
            sum += gas[i] - cost[i];  
            total += gas[i] - cost[i];  
            if(sum < 0) {   //之前的油量不够到达当前加油站  
                j = i;  
                sum = 0;  
            }  
        }  
        if (total < 0) return -1;    //所有加油站的油量都不够整个路程的消耗  
        else return j + 1;  
    } 
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
