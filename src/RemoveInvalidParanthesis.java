import java.util.*;

public class RemoveInvalidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="(a)())()";
		List<String> lists=removeInvalidParentheses(s);
		for(String ele:lists){
			System.out.println(ele);
		}

	}
    public static List<String> removeInvalidParentheses(String s) {
        List<String> list=new ArrayList<>();
        
        int rmL=0;
        int rmR=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                rmL++;
            }else if(s.charAt(i)==')'){
                if(rmL==0){
                    rmR++;
                }else{
                    rmL--;
                }
            }
        }
       Set<String> set=new HashSet<>();
       dfs(0,s,new StringBuilder(),set,rmL,rmR,0);
       for(String ele:set){
           list.add(ele);
       }
       return list;
   }
	
    public static void dfs(int start,String s,StringBuilder sb,Set<String> ans,int rmL,int rmR,int open){
        if(rmL<0||rmR<0||open<0) return;
        if(start==s.length()){
            if(rmL==0&&rmR==0&&open==0){
                ans.add(sb.toString());
            }
            return;
        }
        char c=s.charAt(start);
        //int len=sb.length();
        
        if(c=='('){
            dfs(start+1,s,sb.append(c),ans,rmL,rmR,open+1);
            sb.deleteCharAt(sb.length()-1);
            dfs(start+1,s,sb,ans,rmL-1,rmR,open);
        }else if(c==')'){
            dfs(start+1,s,sb.append(c),ans,rmL,rmR,open-1);
            sb.deleteCharAt(sb.length()-1);
            dfs(start+1,s,sb,ans,rmL,rmR-1,open);
        }else{
            dfs(start+1,s,sb.append(c),ans,rmL,rmR,open);
            sb.deleteCharAt(sb.length()-1);
        }
        
        //sb.setLength(len);
        
   }

}
