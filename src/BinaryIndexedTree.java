import java.util.*;

//this question is used to solve the question about how to compute the left sum of an index of an array(given any array)
//we can use segment tree to solve it,but there is still another more efficient way to solve it which is binary indexed tree
//please see my readme file for more details, here is the code I impelemented using Java
public class BinaryIndexedTree{
    //private static int maxval=Integer.MIN_VALUE;
    public static void main(String[] args){
        int[] nums=new int[]{1,2,3,4,8,10,11};
        // for(int ele:nums){
        // 	maxval=Math.max(maxval,nums[i]);
        // }

        int[] tree=new int[nums.length+1];
        buildtree(nums,tree);
        System.out.println("now the fist 4 elements"+getsum(4,nums,tree));
        update(0,3,nums,tree);
        System.out.println("after updating the first element of the nums(change first index's value into 4)\n");
        System.out.println("now th first element 4 elements is:"+getsum(4,nums,tree)+"\n");
     
    }

   public static void buildtree(int[] nums,int[] tree){
       for(int i=0;i<nums.length;i++){
       	   update(i,nums[i],nums,tree);
       }
   }

    public static void update(int index,int val,int[] nums,int[] tree){
        int currentindex=index+1;
        nums[index]+=val;
        while(currentindex<=nums.length){
        	tree[currentindex]+=val;
        	currentindex+=(currentindex)&(-currentindex);
        }
    }
    public static int getsum(int leftcount,int[] nums,int[] tree){
           int currentpos=leftcount;
           int sum=0;
           while(currentpos>0){
              sum+=tree[currentpos];
              currentpos-=(currentpos)&(-currentpos);
           }
           return sum;
    }
} 