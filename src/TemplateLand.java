import java.io.*;
import java.lang.*;
import java.util.*;


public class TemplateLand{
    public static void main (String[] args) throws IOException
              {
                       BufferedReader r=new BufferedReader(new InputStreamReader(System.in));

                       int a=Integer.parseInt(r.readLine());
                       for(int i=0;i<a;i++){

                           int len=Integer.parseInt(r.readLine());   
                           String[] strarray=r.readLine().split(" ");


                           if(len%2==0){
                           	System.out.println("no");
                           }else{
                             int[] nums=new int[len];
                             for(int j=0;j<strarray.length;j++){
                           	    nums[j]=Integer.parseInt(strarray[j]);
                              }

                              if(check(nums)){
                              	System.out.println("yes");
                              }else{
                              	System.out.println("no");
                              }
                           }
                       }
     
              }

              public static boolean check(int[] nums){
                      int mid=nums.length/2;
                      int i=mid-1,j=mid+1;
                      
                      while(i>=0&&j<nums.length){
                           if(nums[i]==nums[j]&&nums[i]+1==nums[i+1]&&nums[j-1]==nums[j]+1){
                                i--;
                                j++;
                           }else{
                           	return false;
                           }
                      }

                      return nums[++i]==1;
              }




}