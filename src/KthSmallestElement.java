import java.util.*;
public class KthSmallestElement {
	public static int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int high=matrix[matrix.length-1][matrix[0].length-1]+1;
        while(low<high){
           int mid=low+(high-low)/2;
           int count=countLessEqual(matrix,mid);
           if(count<k){
               low=mid+1;
           }else{
               high=mid;
           }
        }
        return low;
  }
  
  public static int countLessEqual(int[][] matrix,int val){
      int i=0;
      int j=matrix[0].length-1;
      int count=0;
      while(i<matrix.length&&j>=0){
          if(matrix[i][j]<=val){
              count+=(j+1);
              i++;
          }else{
              j--;
          }
      }
      return count;
  }
}
