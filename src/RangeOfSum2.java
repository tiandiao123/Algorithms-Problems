import java.util.*;
import java.lang.*;

public class RangeOfSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{-2,5,-1};
		System.out.println(countRangeSum(nums,-2,2));

	}
	
	    public static int countRangeSum(int[] nums, int lower, int upper) {
	        if(nums==null||nums.length<1) return 0;
	        long[] presum=new long[nums.length+1];
	        for(int i=0;i<nums.length;i++){
	            presum[i+1]=nums[i]+presum[i];
	        }
	        return merge(presum,0,presum.length-1,lower,upper);
	    }
	    
	    public static int merge(long[] presum,int s,int e,int lower,int upper){
	        if(s>=e) return 0;
	        int mid=s+(e-s)/2;
	        
	        int count=merge(presum,s,mid,lower,upper)+merge(presum,mid+1,e,lower,upper);
	        int j=mid+1;
	        int k=mid+1;
	        int t=mid+1;
	        for(int i=s;i<=mid;i++){
	            while(j<=e&&presum[j]-presum[i]<lower) j++;
	            while(k<=e&&presum[k]-presum[i]<=upper) k++;
	            count+=(k-j);
	        }
	        Mymerge(presum,s,mid,e);
	        return count;
	    }
	    
	    public static void Mymerge(long[] presum,int s,int mid,int e){
	        long[] copy=new long[e-s+1];
	        int i=s;
	        int j=mid+1;
	        int p=0;
	        while(i<=mid&&j<=e){
	            if(presum[i]<=presum[j]){
	                copy[p++]=presum[i++];
	            }else{
	                copy[p++]=presum[j++];
	            }
	        }
	        
	        while(i<=mid){
	            copy[p++]=presum[i++];
	        }
	        while(j<=e){
	            copy[p++]=presum[j++];
	        }
	        System.arraycopy(copy,0,presum,s,e-s+1);
	    }
	

}
