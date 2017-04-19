import java.util.*;

public class MaxNumGivenTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums1=new int[]{3, 9};
        int[] nums2=new int[]{1,2,8,6};
        int[] res=maxNumber(nums1,nums2,3);
        System.out.println("now the largest numebr formed by these two nums array is:");
        for(int ele: res){
        	System.out.print(ele+" ");
        }
	}
	
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        int[] res=new int[k];
        for(int i=Math.max(0,k-m);i<=n&&i<=k;i++){
            int[] array=merge(findmaxsubarray(nums1,i),findmaxsubarray(nums2,k-i));
            if(!greater(res,0,array,0)){
                res=array;
            }
        }
        return res;
    }
    
    public static boolean greater(int[] a,int i,int[] b,int j){
          for(;i<a.length&&j<b.length;i++,j++){
                if(a[i]>b[j]){
                    return true;
                }else if(a[i]<b[j]){
                    return false;
                }
          }
          
          return i!=a.length;
    }
    
    public static int[] merge(int[] array1,int[] array2){
          int[] array=new int[array1.length+array2.length];
          int i=0;
          int j=0;
          int p=0;
          while(i<array1.length&&j<array2.length){
              if(greater(array1,i,array2,j)){
                  array[p++]=array1[i++];
              }else{
                  array[p++]=array2[j++];
              }
          }
          while(i<array1.length){
              array[p++]=array1[i++];
          }
          while(j<array2.length){
              array[p++]=array2[j++];
          }
          return array;
    }
    
    public static int[] findmaxsubarray(int[] nums,int k){
        int n=nums.length;
        int[] ans=new int[k];
        int j=0;
        
        for(int i=0;i<nums.length;i++){
            while(n-i+j-1>=k&&j>0&&ans[j-1]<nums[i]){
                   j--;   
            }
            if(j<k){
               ans[j]=nums[i];
               j++;
            }
        }
        return ans;
    }

}
