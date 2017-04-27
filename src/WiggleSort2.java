import java.util.*;
public class WiggleSort2 {
	 public static void wiggleSort(int[] nums) {
         int[] temp=new int[nums.length];
         int k=(nums.length+1)/2;
         int mean_index=findmean(nums,0,nums.length-1,k-1);
         int left=mean_index;
         for(int i=left;i<nums.length;i++){
             if(nums[i]==nums[mean_index]){
                 swap(nums,left,i);
                 left++;
             }
         }
         
         int i=0;
         int j=nums.length/2;
         for(int p=0;p<nums.length;p++){
             if(p%2==0){
                 temp[p]=nums[j++];
             }else{
                 temp[p]=nums[i++];
             }
         }
         for(int p=0;p<nums.length;p++){
             nums[p]=temp[p];
         }
    }
	 
	    public static int findmean(int[] nums,int start,int end,int k){
	        int left=start;
	        int pivot=nums[end];
	        for(int i=start;i<=end-1;i++){
	            if(nums[i]>pivot){
	                swap(nums,left,i);
	                left++;
	            }
	        }
	        swap(nums,left,end);
	        if(left==k) return left;
	        else if(left<k){
	            return findmean(nums,left+1,end,k);
	        }else{
	            return findmean(nums,start,left-1,k);
	        }
	        
	    }
	    public static void swap(int[] nums,int i,int j){
	        int t=nums[i];
	        nums[i]=nums[j];
	        nums[j]=t;
	    }
    
}
