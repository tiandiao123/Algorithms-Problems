import java.util.*;
import java.io.*;
import java.lang.*;

public class SameSnake{

      public static void main (String[] args) throws IOException
              {
                       BufferedReader r=new BufferedReader(new InputStreamReader(System.in));

                       int a=Integer.parseInt(r.readLine());
                       for(int i=0;i<a;i++){

                           String[] firstarray=r.readLine().split(" ");
                           String[] secondarray=r.readLine().split(" ");
                           int[] array1=new int[4];
                           int[] array2=new int[4];
                           for(int j=0;j<4;j++){
                           	   array1[j]=Integer.parseInt(firstarray[j]);
                           	   array2[j]=Integer.parseInt(secondarray[j]);
                           }

                           boolean samesnake=check(array1,array2);
                           if(samesnake==true){
                           	System.out.println("yes");
                           } else{
                           	System.out.println("no");
                           }
                       }
     
              }

              public static boolean check(int[] nums1,int[] nums2){
              	  if((nums1[1]==nums1[3])&&(nums1[1]==nums2[1])&&(nums1[1]==nums2[3])){
              	  	     int min=Math.min(nums1[0],nums1[2]);
              	  	     int max=Math.max(nums1[0],nums1[2]);

              	  	     int min2=Math.min(nums2[0],nums2[2]);
              	  	     int max2=Math.max(nums2[0],nums2[2]);

              	  	     if((min2>=min&&min2<=max)||(min>=min2&&min<=max2)){
              	  	     	return true;
              	  	     }else{
              	  	     	return false;
              	  	     }
              	  }else if((nums1[0]==nums1[2])&&(nums1[0]==nums2[0])&&(nums1[0]==nums2[2])){
              	  	     int min1=Math.min(nums1[1],nums1[3]);
              	  	     int max1=Math.max(nums1[1],nums1[3]);

              	  	     int min2=Math.min(nums2[1],nums2[3]);
              	  	     int max2=Math.max(nums2[1],nums2[3]);

              	  	     if((min1>=min2&&min1<=max2)||(min2>=min1&&min2<=max1)){
              	  	     	return true;
              	  	     }else{
              	  	     	return false;
              	  	     }
              	  }else{
                      if((nums1[0]==nums2[0]&&nums1[1]==nums2[1])||(nums1[0]==nums2[2]&&nums1[1]==nums2[3])){
                      	     return true;
                      }
                      if((nums1[2]==nums2[0]&&nums1[3]==nums2[1])||(nums1[2]==nums2[2]&&nums1[3]==nums2[3])){
                      	     return true;
                      }
              	  }

              	  return false;
              }




}