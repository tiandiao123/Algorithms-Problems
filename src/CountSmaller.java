import java.util.*;

public class CountSmaller{
    
    public static void main(String[] args){
         int[] nums=new int[]{1,3,7,-1,2,9,0};
         int[] ans=countSmallerAfterSelf(nums);
         for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
         }
    }
    


    public static int[] countSmallerAfterSelf(int[] nums) {
        int minval=Integer.MAX_VALUE;
        for(int ele:nums){
            minval=Math.min(minval,ele);
        }
        
        int maxval=Integer.MIN_VALUE;
        for(int ele:nums){
            maxval=Math.max(maxval,ele);
        }
        int size=maxval-minval+1;
        int[] nums2=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums2[i]=nums[i]-minval+1;
        }
        
        int[] tree=new int[size+1];
        int[] res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            res[i]=getsum(tree,nums2[i]-1);
            update(tree,nums2[i]);
        }
        return res;
    }
    
    public static void update(int[] tree,int val){
         int index=val;
        
         while(index<tree.length){
             tree[index]++;
             index+=(index)&(-index);
         }
    }
    
    public static int getsum(int[] tree,int val){
        int index=val;
        
        int totalcount=0;
        while(index>=1){
            totalcount+=tree[index];
            index=index-((index)&(-index));
        }
        return totalcount;
    }
}