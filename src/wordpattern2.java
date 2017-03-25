import java.util.*;
import java.lang.*;

public class wordpattern2{

    private static String[] map=new String[26];
    private static Set<String> set=new HashSet<>();
    
    public static boolean wordPatternMatch(String pattern, String str) {
        if(pattern==null||str==null) return str==pattern;
        return findmatch(0,pattern,0,str);
    }
    
    public static boolean findmatch(int p_start,String pattern,int s_start,String str){
          if(p_start==pattern.length()&&s_start==str.length()) return true;
          if(p_start==pattern.length()||s_start==str.length()) return false;
          
          char c=pattern.charAt(p_start);
          if(map[c-'a']!=null){
              String temp=map[c-'a'];
              if(!str.startsWith(temp,s_start)){
                 return false; 
              }
              return findmatch(p_start+1,pattern,s_start+temp.length(),str);
          }else{
              for(int i=s_start;i<str.length();i++){
                  
                  String s=str.substring(s_start,i+1);
                  if(set.contains(s)){
                      continue;
                  }
                  set.add(s);
                  map[c-'a']=s;
                  if(findmatch(p_start+1,pattern,i+1,str)){
                      return true;
                  }
                  set.remove(s);
                  map[c-'a']=null;
              }
          }
          return false;
    }





}
