package array;

/**
 *  Set Matrix Zeroes
 *  
 *  Given a m × n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
    Follow up: Did you use extra space?
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 * @author reus
 *
 */
public class Array20SetMatrixZeros {

    static void setMatrixZero(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        boolean[] row=new boolean[m];
        boolean[] col=new boolean[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            if(row[i]){
                for(int j=0;j<n;j++){
                    mat[i][j]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(col[i]){
                for(int j=0;j<m;j++){
                    mat[j][i]=0;
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[][] mat={{1,0,3},{4,5,6},{7,8,9}};
        setMatrixZero(mat);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

}
