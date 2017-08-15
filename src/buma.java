
public class buma {

    static int foo(int x){
        return x & -x;
    }
    public static void main(String[] args) {
         System.out.println( foo((int)Math.pow(2, 31)-3) );
         System.out.println((int)Math.pow(2,31));
         System.out.println(Integer.MAX_VALUE);
         
    }
}
