import java.util.*;

public class MaxSumofSubmatrix{


   public static void main(String[] args) {
   	   int[][] m=new int[][]{{1,  0, 1},{0, -2, 3}};
       int res=maxSumSubmatrix(m,2);

       System.out.println("thus], the largest area of sub-matrix<=2 is:"+res);
   }

   public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length<1) return 0;
        int rowlen=matrix.length;
        int collen=matrix[0].length;
        
        int res=Integer.MIN_VALUE;
        for(int i=0;i<collen;i++){
            int[] sum=new int[rowlen];
            for(int j=i;j<collen;j++){
                   int p=0;
                   TreeSet<Integer> set=new TreeSet<>();
                   set.add(0);
                   for(int index=0;index<rowlen;index++){
                       p+=matrix[index][j];
                       sum[index]+=p;
                       Integer temp=set.ceiling(sum[index]-k);
                       
                       if(temp!=null){
                           res=Math.max(res,sum[index]-temp);
                           if(res==k) return k;
                       }
                       set.add(sum[index]);
                   }
            }
        }
        
        return res;
    }


}