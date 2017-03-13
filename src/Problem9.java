import java.util.*;

public class Problem9{

      public class node{
      	int val,leftcount=0,dup=0;
      	node left,right;
      	node(int val){
            this.val=val;
      	}
      }
    
    
    public static List<Integer> countSmaller(int[] nums) {
         List<Integer> list=new LinkedList<>();
          if(nums==null||nums.length<1) return list;
          node root=null; 
          for(int i=nums.length-1;i>=0;i--){
            root=update(nums,list,root,i,0);     
          }

          return list;
    }
    
    public static node update(int[] nums,List<Integer> list,node root,int index,int precount){
            if(root==null){
            	root=new node(nums[index]);
            	root.dup++;
            	//System.out.println(precount);
            	list.add(0,precount);	
            }else if(nums[index]==root.val){
            	root.dup++;
            	System.out.println(root.leftcount+precount);
                list.add(0,root.leftcount+precount);
            }else if(nums[index]<root.val){
                root.leftcount++;
                //System.out.println(precount);
                root.left=update(nums,list,root.left,index,precount);
            }else{
                //System.out.println(root.dup);
            	root.right=update(nums,list,root.right,index,precount+root.dup+root.leftcount);
            }

            return root;
      }
  
}
