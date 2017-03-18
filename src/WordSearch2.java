import java.util.*;

public class WordSearch2 {

    public static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        String word;
    }

    public static void main(String[] args){
        char[][] board=new char[][]{
             {'o','a','a','n'},
             {'e','t','a','e'},
             {'i','h','k','r'},
             {'i','f','l','v'}
        };

        String[] words=new String[]{"oath","pea","eat","rain"};
        List<String> res=findWords(board,words);
        for(String ele:res){
            System.out.print(ele+" ");
        }

        System.out.println();

    }

    public static List<String> findWords(char[][] board, String[] words) {
           TrieNode root=buildtrienode(words);
           Set<String> set=new HashSet<>();
           
           for(int i=0;i<board.length;i++){
               for(int j=0;j<board[0].length;j++){
                    findstring(board,root,i,j,set);
               }
           }
           
           return new ArrayList<String>(set);
    }
    
    public static void findstring(char[][] board,TrieNode root,int i,int j,Set<String> set){
         if(root.word!=null){
            set.add(root.word);
            root.word=null;
         }
        
        if(i<0||i>=board.length||j<0||j>=board[0].length) return ;
        if(board[i][j]=='#') return ;
        
        if(root.children[board[i][j]-'a']==null){
            return ;
        }
        
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        char c=board[i][j];
        
        root=root.children[board[i][j]-'a'];
        board[i][j]='#';
        for(int[] dir:dirs){
               findstring(board,root,i+dir[0],j+dir[1],set);
        }
        board[i][j]=c;
    }
    
    public static TrieNode buildtrienode(String[] words){
        TrieNode root=new TrieNode();
        for(String str:words){
            char[] strarray=str.toCharArray();
            TrieNode node=root;
            for(char c:strarray){
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                }
                node=node.children[c-'a'];
            }
            
           node.word=str;
        }
        return root;
    }

    
}