import java.util.*;

public class CountRangeSum{
   
   public static void main(String[] args){
      int[] nums=new int[]{-1,2,4,7};
      int sum=countRangeSum(nums,-1,7);
      System.out.println("thus, the number of sum between -1 and 7 in this array is : "+sum);
   }

   public static int countRangeSum(int[] nums,int lower,int higher){
        List<Long> list=new ArrayList<>();
        long[] presum=new long[nums.length+1];
        list.add(Long.MIN_VALUE);
        list.add(0L);
        for(int i=1;i<=nums.length;i++){
             presum[i]=nums[i-1]+presum[i-1];
             list.add(presum[i]);
             list.add(presum[i-1]+lower-1);
             list.add(presum[i-1]+higher);
        }          
        Collections.sort(list);
        int[] tree=new int[list.size()+1];
        int totalcount=0;
        for(int i=0;i<=nums.length;i++){
        	update(tree,Collections.binarySearch(list,presum[i]),1);
        }

        for(int i=0;i<=nums.length;i++){
        	update(tree,Collections.binarySearch(list,presum[i]),-1);
        	totalcount+=get(tree,Collections.binarySearch(list,presum[i]+higher));
        	totalcount-=get(tree,Collections.binarySearch(list,presum[i]+lower-1));
        }
        return totalcount;
        
        
   }

   public static void update(int[] tree,int val,int delta){
        while(val<tree.length){
        	tree[val]+=delta;
        	val+=(val)&(-val);
        }
   }

   public static int get(int[] tree,int val){
           int sum=0;
           while(val>=1){
              sum+=tree[val];
              val-=(val)&(-val);
           }
           return sum;
   }


}