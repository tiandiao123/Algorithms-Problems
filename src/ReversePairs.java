//Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

//You need to return the number of important reverse pairs in the given array.

import java.util.*;
import java.lang.*;

public class ReversePairs {
    public static void main(String[] args){
       int[] nums=new int[]{1,3,2,3,1};
       int sum=reversePairs(nums);
       System.out.println(sum);

    }

    public static int reversePairs(int[] nums) {
          Set<Long> set=new HashSet<>();
          set.add(Long.MIN_VALUE);
          for(int ele:nums){
              set.add(Long.valueOf(ele-1));
              set.add(Long.valueOf(2*ele));
          }
          
          Long[] vararray=set.toArray(new Long[0]);
          Arrays.sort(vararray);
          int[] tree=new int[vararray.length];
          int sum=0;
          for(int i=nums.length-1;i>=0;i--){
              sum+=get(tree,Arrays.binarySearch(vararray,Long.valueOf(nums[i]-1)));
              update(tree,Arrays.binarySearch(vararray,Long.valueOf(2*nums[i])));
          }
          return sum;
    }
    
    public static void update(int[] tree,int index){
           while(index<tree.length){
               tree[index]++;
               index+=(index)&(-index);
           }
    }
    
    public static int get(int[] tree,int index){
        int count=0;
        while(index>=1){
            count+=tree[index];
            index-=(index)&(-index);
        }
        return count;
    }
}