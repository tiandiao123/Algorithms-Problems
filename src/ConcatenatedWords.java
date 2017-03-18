import java.util.*;

public class ConcatenatedWords{
      
      public static class TrieNode{
        TrieNode[] child=new TrieNode[26];
        String word;
      }


     public static void main(String[] args){
           System.out.println("create string array :");
           String[] strs=new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
           for(String ele:strs){
           	System.out.print(ele+" ");
           }
           List<String> res=findAllConcatenatedWordsInADict(strs);
           System.out.println("\nhere is the result:");
           for(String ele:res){
           	System.out.print(ele+ " ");
           }
           System.out.println();
      }

 
    
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root=new TrieNode();
        for(int i=0;i<words.length;i++){
            insert(words[i],root);
        }
        
        List<String> res=new ArrayList<>();
        for(String ele:words){
            if(searchwords(root,ele.toCharArray(),0,0)){
                res.add(ele);
            }   
        }
        return res;
    }
    
    public static boolean searchwords(TrieNode root,char[] array,int count,int index){
          TrieNode current=root;
          for(int i=index;i<array.length;i++){
              char c=array[i];
              if(current.child[c-'a']==null){
                  return false;
              }
              current=current.child[c-'a'];
              if(current.word!=null){
                  if(i==array.length-1){
                      return count>=1;
                  }
                  
                  if(searchwords(root,array,count+1,i+1)){
                      return true;
                  }
              }
          }
          
          return false;
    }
    
    public static void insert(String str,TrieNode root){
        char[] array=str.toCharArray();
        TrieNode current=root;
        for(int i=0;i<array.length;i++){
            char c=array[i];
            if(current.child[c-'a']==null){
                current.child[c-'a']=new TrieNode();
            }
            current=current.child[c-'a'];
        }
        current.word=str;
    }



}
