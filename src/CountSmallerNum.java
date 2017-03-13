import java.util.*;
public class CountSmallerNum {
    
    public static class node{
       int start,end;
       int count=0;
       node left,right;
       node(int a,int b){
           start=a;
           end=b;
        }
     }
    
    public static void main(String[] args){
        int[] nums=new int[]{2,3,1,1,7,1};
        List<Integer> list=countSmaller(nums);
        System.out.println("the size of nums is:"+list.size());
        for(int i=0;i<list.size();i++){
        	System.out.print(list.get(i)+" ");
        }
    }

    
    public static List<Integer> countSmaller(int[] nums) {
          if(nums==null||nums.length<1) return new ArrayList<>();
          
          int[] res=new int[nums.length];
          int min=Integer.MAX_VALUE;
          for(int i=0;i<nums.length;i++){
              min=Math.min(min,nums[i]);
          }
          
          int max=Integer.MIN_VALUE;
          Integer[] nums2=new Integer[res.length];
          for(int i=0;i<nums.length;i++){
              nums2[i]=nums[i]-min;
              max=Math.max(nums2[i],max);
          }
          
          node root=buildtree(0,max);
          //int j=0;
          for(int i=nums2.length-1;i>=0;i--){
               res[i]=query(root,nums2[i]-1);
               update(root,nums2[i]);
          }
          
         List<Integer> list=new ArrayList<>();
         for(int i=0;i<res.length;i++){
             list.add(res[i]);
         }
         return list;
    }
    
    public static node buildtree(int start,int end){
        if(start==end){
            return new node(start,end);
        }
        int mid=start+(end-start)/2;
        node root=new node(start,end);
        root.left=buildtree(start,mid);
        root.right=buildtree(mid+1,end);
        return root;
    }
    public static int query(node root,int val){
        if(root==null) return 0;
        if(root.start>val) return 0;
        if(root.end<=val) return root.count;
        
        int mid=root.start+(root.end-root.start)/2;
        int left=query(root.left,Math.min(mid,val));
        int right=query(root.right,val);
        
        return left+right;
        
    }
    public static int update(node root,int val){
        if(root==null) return 0;
        if(root.start==val&&root.end==val){
            root.count++;
            return root.count;
        }
        
        if(val<root.start||val>root.end){
            return root.count;
        }
        
        
        int left=update(root.left,val);
        int right=update(root.right,val);
        root.count=left+right;
        return root.count;
        
    }
}