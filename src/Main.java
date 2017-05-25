    import java.util.*;
    import java.io.*;
    import java.lang.*;
     
    public class Main
    {
              public static void main (String[] args) throws IOException
              {
                       BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
 
                       int a=Integer.parseInt(r.readLine());
                       for(int i=0;i<a;i++){
                           String[] nums_str=r.readLine().split(" ");
 
                           int K=Integer.parseInt(nums_str[0]);
                           int Q=Integer.parseInt(nums_str[1]);
 
                           String[] strarray=r.readLine().split(" ");
                           int[] nums=new int[K];
                           for(int j=0;j<strarray.length;j++){
                           		nums[j]=Integer.parseInt(strarray[j]);
                           }
                           
                           Arrays.sort(nums);
 						   reverse(nums);
                           for(int j=0;j<Q;j++){
                              int query=Integer.parseInt(r.readLine());
                              int count=getcount(nums,query);
                              System.out.println(count);
                           }
                            
                       }
     
              }
 
          public static int getcount(int[] nums,int query){
              	int count=0;
              	int i=0;
              	while(i<nums.length&&nums[i]>=query){
              		i++;
              		count++;
              	}
 
              	if(i==nums.length){
              		return count;
              	}
 
              	int j=nums.length-1;
 
              	while(i<j){
              		int largersnake=nums[i];
              		while(largersnake<query&&i<j){
              			largersnake++;
              			j--;
              		}
 
              		if(largersnake>=query){
              			count++;
              		}
              		i++;
              	}
 
              	return count;
          }


          public static void reverse(int[] nums){
           	   int i=0;
           	   int j=nums.length-1;
           	   while(i<j){
           	   	    int t=nums[i];
           	   	    nums[i]=nums[j];
           	   	    nums[j]=t;
           	   }
           }
 
 
    }   