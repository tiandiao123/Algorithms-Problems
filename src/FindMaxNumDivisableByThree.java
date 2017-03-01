import java.util.*;
public class FindMaxNumDivisableByThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums=new int[]{3,1,4,1,5,9};
        System.out.println("the largets number divisable by 3 is: "+findlargestnum(nums));
	    
	}
	
	public  static int findlargestnum(int[] nums){
	     if(nums==null||nums.length<1) return 0;

	     Arrays.sort(nums);
	     for(int i=0;i<=nums.length;i++){
	         boolean[] visited=new boolean[nums.length];
	         if(helper(nums,0,visited,i,0)){ 
	             return converttoint(nums,visited);
	         }
	     }
	     return 0;
	}

	public static boolean helper(int[] nums,int start,boolean[] visited,int size,int level){
	        if(level==size){
	            if(isdivisableby3(nums,visited)) return true; 
	        }else{
	            int rec=nums[nums.length-1]+1;
	            for(int i=start;i<nums.length;i++){
	                if(rec!=nums[i]){
	                  visited[i]=true;
	                  if(helper(nums,i+1,visited,size,level+1)) return true;
	                  visited[i]=false;
	                }
	            }
	        }
	        return false;
	}
	public static boolean isdivisableby3(int[] nums,boolean[] visited){
	    int sum=0;
	    for(int i=0;i<nums.length;i++){
	        if(visited[i]==false){
	            sum+=nums[i];
	        }
	    }
	    return sum%3==0;
	}

	public static int converttoint(int[] nums,boolean[] visited){
	    int sum=0;
	    for(int i=nums.length-1;i>=0;i--){
	        if(visited[i]==false){
	            sum=sum*10+nums[i];
	        }
	    }
	    return sum;
	}

	public static void reverse(int[] nums){
	    if(nums==null||nums.length<1) return;
	    int i=0;
	    int j=nums.length-1;
	    while(i<j){
	        int t=nums[i];
	        nums[i]=nums[j];
	        nums[j]=t;
	        i++;
	        j--;
	    }
	}


}
