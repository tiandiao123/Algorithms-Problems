import java.util.*;

public class PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] strs=new String[]{"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> listarray=palindromePairs(strs);
        for(int i=0;i<listarray.size();i++){
        	for(int j=0;j<listarray.get(i).size();j++){
        		System.out.print(listarray.get(i).get(j)+" ");
        	}
        	System.out.println();
        }
	}
	
    public static class TrieNode {
        TrieNode[] child=new TrieNode[26];
        int index=-1;
   }
   
   public static List<List<Integer>> palindromePairs(String[] words) {
         List<List<Integer>> listarray=new ArrayList<>();
         if(words==null||words.length<1) return listarray;
         TrieNode root=new TrieNode();
         
         for(int i=0;i<words.length;i++){
         	  insert(root,words[i],i);
         }

         for(int i=0;i<words.length;i++){
         	   for(int j=0;j<=words[i].length();j++){
                  if(ispalindrome(words[i],0,j-1)){
                       int index=search(root,words[i],j,words[i].length()-1);
                       if(index!=-1&&index!=i){
                       	listarray.add(Arrays.asList(index,i));
                       }
                       
                  }

                  if(ispalindrome(words[i],j,words[i].length()-1)&&words[i].length()-j!=0){
                  	 int index=search(root,words[i],0,j-1);
                  	 if(index!=-1&&index!=i){
                  	 	listarray.add(Arrays.asList(i,index));
                  	 }
                  }
         	   }
          }
          return listarray;
       }

   

   public static int search(TrieNode root,String str,int start,int end){
        TrieNode current=root;
        for(int i=start;i<=end;i++){
            char c=str.charAt(i);
            if(current.child[c-'a']==null) return -1;
            current=current.child[c-'a'];
        }
       return current.index;  
   }

   public static void insert(TrieNode root,String word,int idx){
   	char[] array=word.toCharArray();
   	TrieNode current=root;

   	if(word.equals("")){
   		root.index=idx;
   		return;
   	}

   	for(int i=array.length-1;i>=0;i--){
             char c=array[i];
             if(current.child[c-'a']==null){
                    current.child[c-'a']=new TrieNode();
             }
             current=current.child[c-'a'];
   	}
   	current.index=idx;
   }
   
   public static boolean ispalindrome(String str,int i,int j){
   	    char[] strarray=str.toCharArray();
   	    while(i<j){
   	    	if(strarray[i]!=strarray[j]) return false;
   	    	i++;
   	    	j--;
   	    }
   	    return true;
   }

}
