//   Given an array [a_1,a_2,...,a_n] consisting of non-positive integers and target sum S, please 
//find the number of all the combinations of the array such that k_1*a_1+k_2*a_2+...+k_n*a_n=S,where k_i can only be 1 or -1.  
import java.util.*;

public class targetsum{

    public static void main(String[] args){
         int[] nums=new int[]{1,2,1};
         int target=3;
         int res=numoftargetsum(nums,target);
         System.out.println("there are total "+numoftargetsum(nums,target)+" different combinations");
    }


    public static int numoftargetsum(int[] nums,int target){
         int sum=0;
         for(int ele:nums){
         	sum+=ele;
         }

         if(sum<Math.abs(target)) return 0;
         
         int doublesum=sum<<1;
         int[][] dp=new int[nums.length][doublesum+1];
         if(nums[0]==0){
         	dp[0][sum]=2;
         }else{
            dp[0][sum-nums[0]]=1;
            dp[0][sum+nums[0]]=1;
         }

        for(int i=1;i<nums.length;i++){
           for(int j=0;j<=doublesum;j++){
                if(j-nums[i]>=0){
                	dp[i][j]+=dp[i-1][j-nums[i]];
                }
                if(j+nums[i]<=doublesum){
                	dp[i][j]+=dp[i-1][j+nums[i]];
                }
           }
        }

         return dp[nums.length-1][target+sum];
                
     }

}
    
   