//Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

//You need to return the number of important reverse pairs in the given array.


import java.util.*;
import java.lang.*;

public class ReversePairs2{
    public static void main(String[] args){
       int[] nums=new int[]{1,3,2,3,1};
       int sum=reversePairs(nums);
       System.out.println(sum);
    }

    public static int reversePairs(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        
        return merge(nums,0,nums.length-1);
    }
    
    public static int merge(int[] nums,int start,int end){
        if(start>=end) return 0;
        
        int mid=start+(end-start)/2;
        int count=merge(nums,start,mid)+merge(nums,mid+1,end);
        for(int i=start,j=mid+1;i<=mid;i++){
            while(j<=end&&nums[i]/2.0>nums[j]){
                j++;
            }
            count+=j-(mid+1);
        }
        Mymerge(nums,start,mid,end);
        return count;
    }

    public static void Mymerge(int[] nums,int start,int mid,int end){
        int[] copy=new int[end-start+1];
         int i=start;
         int j=mid+1;
         int p=0;
         while(i<=mid&&j<=end){
             if(nums[i]<=nums[j]){
                 copy[p++]=nums[i];
                 i++;
             }else{
                 copy[p++]=nums[j];
                 j++;
             }
         }
         while(i<=mid){
             copy[p++]=nums[i];
             i++;
         }
         while(j<=end){
             copy[p++]=nums[j++];
         }
         System.arraycopy(copy,0,nums,start,end-start+1);
         
    }
}