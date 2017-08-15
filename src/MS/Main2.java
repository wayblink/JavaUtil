package MS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<String[]> input=new ArrayList<>();
        int i=0;
        while(i<n) {
            String[] temp=new String[2];
            temp[0]=in.nextLine();
            temp[1]=in.nextLine();
            input.add(temp);
            i++;
        }
        
        for(int j=0;j<n;j++){
            String[] inputj=input.get(j);
            String str1=inputj[0];
            String str2=inputj[1];
            System.out.println(str1);
            System.out.println(str2);
            int num=0;
            HashMap<Character,Integer> map=new HashMap<>();
            map.put('m',0);
            map.put('s',0);
            map.put('t',0);
            map.put('f',0);
            for(int k=0;k<str1.length();k++){
                if(str1.charAt(k)!=str2.charAt(k)){
                    num++;
                    char key=str1.charAt(k);
                    if(map.containsKey(key)){
                        map.put(key, map.get(key)+1);
                    }
                }
            }
            num-=map.get('m')>1?1:0+map.get('s')>1?1:0+map.get('t')>1?1:0+map.get('f')>1?1:0;
            num--;
            System.out.println(num);
        }
        
        
    }
}
