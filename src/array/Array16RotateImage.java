package array;

public class Array16RotateImage {

    public static void flipH(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][n-1-j];
                mat[i][n-1-j]=temp;
            }
        }
    }
    
    public static void flipDialognal(int[][] mat){
        int m=mat.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<=i;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] mat={{1,2},{3,4}};
        
        flipDialognal(mat);flipH(mat);

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

}
