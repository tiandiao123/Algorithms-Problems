import java.util.*;
public class SegementTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        int[] treenodes=new int[2*nums.length];
        build(treenodes,nums);
        System.out.println("the sum of the array between index 3 and 6");
        System.out.println("the sum is:"+query(3,6,treenodes,nums));
        
        modify(treenodes,nums,3,5);
        System.out.println("after changing the value of index 3 into 5");
        System.out.println("sum of array between index 3 and 6 is :"+query(3,6,treenodes,nums));
        
        
	}
	
	public static void build(int[] treenode,int[] nums){
	     for(int i=0;i<nums.length;i++){
	    	 treenode[nums.length+i]=nums[i];
	     }
	     for(int i=nums.length-1;i>=1;i--){
	    	 treenode[i]=treenode[i<<1]+treenode[(i<<1)|1];
	     }
	}
	
	public static void modify(int[] treenode,int[] nums,int index,int val){
		int p=index+nums.length;
		nums[index]=val;
		treenode[p]=val;
		for(;p>1;p>>=1){
			treenode[p>>1]=treenode[p]+treenode[p^1];
		}
	}
	
	public static int query(int start,int end,int[] treenode,int[] nums){
	     int res=0;
	     int i=nums.length+start;
	     int j=nums.length+end;
	     for(;i<=j;i>>=1,j>>=1){
	    	 if((i&1)==1){
	    		 res+=treenode[i];
	    		 i++;
	    	 }
	    	 if((j&1)==0){
	    		 res+=treenode[j];
	    		 j--;
	    	 }
	     }
	     return res;
	}
    
}
