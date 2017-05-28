import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
      //public static int[][] dirs=new int[][]{{1,0},{-1,0},{0,1}};

      public static void main (String[] args) throws IOException{

           BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
           int a=Integer.parseInt(r.readLine());

           for(int i=0;i<a;i++){
            String[] strarray=r.readLine().split(" ");
            int N=Integer.parseInt(strarray[0]);
            int L=Integer.parseInt(strarray[1]);
            int A=Integer.parseInt(strarray[2]);
            int B=Integer.parseInt(strarray[3]);
            
            String[] strs=r.readLine().split(" ");
            int[] res=new int[N];
            for(int j=0;j<N;j++){
              res[j]=Integer.parseInt(strs[j]);
            }

            int len=shortestmove(res,L,A,B);
            System.out.println(len);

           }
      }

      public static int shortestmove(int[] nums,int L,int A,int B){
             int i=0;
             int j=0;
             if(nums.length%2==0){
                  i=nums.length/2-1;
                  j=nums.length/2;
                  int count=Math.min(nums[j]-nums[i],);
                  
                  
             }else{

             }
      }
} 