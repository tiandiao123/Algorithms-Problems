public class FindMaxXor {
    public static class TrieNode{
        TrieNode[] child=new TrieNode[2];
    }
    
    public static void main(String[] args){
       int[] nums=new int[]{3, 10, 5, 25, 2, 8};
       System.out.println("we have the following array:");
       for(int ele:nums){
        System.out.print(ele+" ");
       }

       System.out.println("\nso the max Xor is :"+findMaximumXOR(nums)+"\n");

    }

    public static int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();
        for(int ele:nums){
            insert(root,ele);
        }
        
        int max=Integer.MIN_VALUE;
        for(int ele:nums){
              TrieNode current=root;
              int cursum=0;
              for(int i=31;i>=0;i--){
                  int index=(ele>>i)&1;
                  if(current.child[index^1]!=null){
                      cursum|=(1<<i);
                      current=current.child[index^1];
                  }else{
                      current=current.child[index];
                  }
              }
              max=Math.max(max,cursum);
        }
        
        return max;
    }
    
    public static void insert(TrieNode root,int ele){
        TrieNode current=root;
        for(int i=31;i>=0;i--){
            int index=(ele>>i)&1;
            if(current.child[index]==null){
                current.child[index]=new TrieNode();
            }
            current=current.child[index];
        }
    }
}