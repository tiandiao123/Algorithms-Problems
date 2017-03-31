
import java.io.*;
import java.lang.*;
import java.util.*;

public class boundaryOfBinaryTree{

    static List<Integer> list=new ArrayList<>(1000);

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
            if(root==null) return list;
            list.add(root.val);
            findleftnodes(root.left);
            findleaves(root.left);
            findleaves(root.right);
            findrightnodes(root.right);
            return list;
    }
    
    public static void findleftnodes(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)) return;
        list.add(root.val);
        if(root.left==null){
            findleftnodes(root.right);
        }else{
            findleftnodes(root.left);
        }
    }
    
    public static void findleaves(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            list.add(root.val);
            return;
        }
        findleaves(root.left);
        findleaves(root.right);
    }
    
    public static void findrightnodes(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)) return;
        if(root.right!=null){
            findrightnodes(root.right);
        }else{
            findrightnodes(root.left);
        }
        list.add(root.val);
    }

}
