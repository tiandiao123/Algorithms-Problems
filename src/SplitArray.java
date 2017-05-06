
public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums=new int[]{7,2,5,10,8};
        int m=2;
        System.out.println("the largest sum of split arrays given m is :" + splitArray(nums,m));
	}
	
	public static int splitArray(int[] nums, int m) {
        long num_max=0;
        long sum=0;
        for(int num:nums){
            sum+=num;
            num_max=Math.max(num_max,num);
        }
        if(m==1) return (int)sum;
        
        long left=num_max;
        long right=sum+1;
        
        while(left<right){
            long mid=left+(right-left)/2;
            if(valid(nums,mid,m)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        
        return (int)left;
   }
   
   public static boolean valid(int[] nums,long target,int m){
       int count=1;
       long total=0;
       for(int i=0;i<nums.length;i++){
           if(total+nums[i]<=target){
               total+=nums[i];
           }else{
               total=nums[i];
               count++;
               if(count>m) return false;
           }
       }
       
       return true;
   }

}
