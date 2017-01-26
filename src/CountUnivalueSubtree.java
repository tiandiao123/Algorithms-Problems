import java.util.*;
import java.lang.*;

public class CountUnivalueSubtree {
   private static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         TreeNode root=new TreeNode(5);
         root.left=new TreeNode(1);
         root.right=new TreeNode(5);
         root.left.left=new TreeNode(5);
         root.left.right=new TreeNode(5);
         root.right.right=new TreeNode(5);
         
         System.out.println(countUnivalSubtrees(root));
	}
	
	public static int countUnivalSubtrees(TreeNode root) {
	       
	       helper(root);
	       return count;
	       
	    }
	    
	    public static boolean helper(TreeNode root){
	        if(root==null) return true;
	        
	        boolean left=helper(root.left);
	        boolean right=helper(root.right);
	        
	        if(left==true&&right==true){
	            if((root.left==null||root.left.val==root.val)&&(root.right==null||root.right.val==root.val)){
	                count++;
	                return true;
	            }
	        }
	        
	        return false;
	    }

}
