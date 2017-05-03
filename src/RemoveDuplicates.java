public class RemoveDuplicates{

   public static void main(String[] args) {
   	    String test="cbacdcbc";

   	    System.out.println("the final result is: "+removeDuplicateLetters(test));
   	    
   }


   public static String removeDuplicateLetters(String s) {
        char[] array=s.toCharArray();
        
        int[] hash=new int[26];
        boolean[] visited=new boolean[26];
        for(char c:array){
            hash[c-'a']++;
        }
        
        StringBuilder strbuild=new StringBuilder();
        for(int i=0;i<array.length;i++){
            int index=array[i]-'a';
            hash[index]--;
            
            if(visited[index]==true){
                continue;
            }
            
            while(strbuild.length()>0 && strbuild.charAt(strbuild.length()-1)>array[i] && hash[strbuild.charAt(strbuild.length()-1)-'a']!=0){
                visited[strbuild.charAt(strbuild.length()-1)-'a']=false;
                strbuild.deleteCharAt(strbuild.length()-1);
            }
            
            visited[index]=true;
            strbuild.append(array[i]);
        }
        return strbuild.toString();
    }



}