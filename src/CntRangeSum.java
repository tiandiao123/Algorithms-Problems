import java.util.*;
import java.lang.*;

public class CntRangeSum{

	  public static class segmenttree{
	  	Long start,end;
        segmenttree left,right;
        int count;

	  	segmenttree(Long start,Long end){
	  		this.start=start;
	  		this.end=end;
	  	}
	  }

     public static void main(String[] args){
      int[] nums=new int[]{-1,2,4,7};
      int sum=countRangeSum(nums,-1,7);
      System.out.println("thus, the number of sum between -1 and 7 in this array is : "+sum);

     }

     public static int countRangeSum(int[] nums,int lower,int uppper){
            Set<Long> set=new HashSet<>();
            long sum=0;
            for(int i=0;i<nums.length;i++){
            	sum+=nums[i];
            	set.add(sum);
            }
            Long[] sumarray=set.toArray(new Long[0]);
            Arrays.sort(sumarray);
            segmenttree root=build(sumarray,0,sumarray.length-1);
            
            int total=0;
            for(int i=nums.length-1;i>=0;i--){
                update(root,sum);
                sum-=nums[i];
                total+=get(root,sum+lower,sum+uppper);
            }
            return total;

     }

     public static segmenttree build(Long[] sumarray,int i,int j){
     	if(i>j) return null;

     	segmenttree root=new segmenttree(sumarray[i],sumarray[j]);
     	if(i==j) return root;
        root.left=build(sumarray,i,i+(j-i)/2);
        root.right=build(sumarray,i+(j-i)/2+1,j);
        return root;
     }
 
     public static int get(segmenttree root,long min,long max){
            int sum=0;
            if(root==null) return 0;
            if(min>root.end||max<root.start) return 0;
            if(min<=root.start&&max>=root.end){
            	return root.count;
            }
            int left=get(root.left,min,max);
            int right=get(root.right,min,max);
            return left+right;
     } 

     public static void update(segmenttree root,long val){
           if(root==null) return;
           if(root.start<=val&&root.end>=val){
                root.count++;
                update(root.left,val);
                update(root.right,val);
           }
     }

}