
public class RangeSum2D {
    private static int[][] treenodes;
    private static int collen;
    private static int rowlen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int[][] matrix=new int[][]{{3, 0, 1, 4, 2},
        	   {5, 6, 3, 2, 1},
        	   {1, 2, 0, 1, 5},
        	   {4, 1, 0, 1, 7},
        	   {1, 0, 3, 0, 5}};
           
	}
	public RangeSum2D(int[][] matrix) {
        if(matrix==null||matrix.length<1) return;
        rowlen=matrix.length;
        collen=matrix[0].length;
        treenodes=new int[rowlen][collen*2];
        for(int i=0;i<rowlen;i++){
            for(int j=0;j<collen;j++){
                treenodes[i][collen+j]=matrix[i][j];
            }
            for(int j=collen-1;j>=0;j--){
                treenodes[i][j]=treenodes[i][j<<1]+treenodes[i][(j<<1)|1];
            }
        }
    }
    public static void update(int row, int col, int val) {
        int j=col+collen;
        int dif=val-treenodes[row][j];
        while(j>0){
            treenodes[row][j]+=dif;
            j>>=1;
        }
  }
  
  public static int sumRegion(int row1, int col1, int row2, int col2) {
       int sum=0;
       for(int row=row1;row<=row2;row++){
           int i=col1+collen;
           int j=col2+collen;
           for(;i<=j;i>>=1,j>>=1){
               if((i&1)==1){
                   sum+=treenodes[row][i];
                   i++;
               }
               if((j&1)==0){
                   sum+=treenodes[row][j];
                   j--;
               }
           }
       }
       return sum;
  }
	
}
