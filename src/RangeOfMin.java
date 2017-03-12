import java.util.*;
public class RangeOfMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums=new int[]{10,2,3,4,9,6,7,8,20,10,11,30};
        int[] treenodes=new int[2*nums.length];
        build(treenodes,nums);
        
        int index=queryminindex(treenodes,nums,3,7);
        System.out.println("the minindex of array between 3 and 7 is :"+queryminindex(treenodes,nums,3,7));
	    System.out.println("and the min value is :"+nums[index]);
	    
	    System.out.println("changing value of index 3 as 15");
	    modify(treenodes,nums,3,15);
	    index=queryminindex(treenodes,nums,3,7);
	    System.out.println("now the minvalue is:"+nums[index]);
	    System.out.println("and the min index is "+index);
	}
	
	public static void build(int[] treenode,int[] nums){
	    for(int i=0;i<nums.length;i++){
	    	treenode[i+nums.length]=i;
	    }
	    for(int i=nums.length-1;i>=1;i--){
	    	if(nums[treenode[i<<1]]<nums[treenode[(i<<1)|1]]){
	    		treenode[i]=treenode[i<<1];
	    	}else{
	    		treenode[i]=treenode[(i<<1)|1];
	    	}
	    }
	}
	
	public static void modify(int[] treenode,int[] nums,int index,int val){
	      nums[index]=val;
	      for(int i=index+nums.length;i>=1;i>>=1){
	    	  if(nums[treenode[i]]<nums[treenode[i^1]]){
	    		  treenode[i>>1]=treenode[i];
	    	  }else{
	    		  treenode[i>>1]=treenode[i^1];
	    	  }
	      }
	}
	
	public static int queryminindex(int[] treenode,int[] nums,int start,int end){
		int i=start+nums.length;
		int j=end+nums.length;
         
		int minindex=end;
		for(;i<=j;i>>=1,j>>=1){
			if((i&1)==1){
				if(nums[minindex]>nums[treenode[i]]){
					minindex=i;
				}
				i++;
			}
			if((j&1)==0){
				if(nums[minindex]>nums[treenode[j]]){
					minindex=treenode[j];
				}
				j--;
			}
		}
		
		return minindex;
	}

}
