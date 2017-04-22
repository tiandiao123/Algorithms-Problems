import java.util.*;
public class FlipGame {
	public static void main(String[] args){
		String s="++++";
		boolean win=canWin(s);
		if(win){
			System.out.println("yes, we have won!");
		}else{
			System.out.println("no we didn't win");
		}
	}
    public static boolean canWin(String s) {
        if(s.length()<2) return false;
        Map<String,Boolean> map=new HashMap<>();
        return isWin(map,s);
    }
    public static boolean isWin(Map<String,Boolean> map,String s){
            if(map.containsKey(s)){
                return map.get(s);
            }
            
            for(int i=0;i<=s.length()-2;i++){
                  if(s.startsWith("++",i)){
                      String temp=s.substring(0,i)+"--"+s.substring(i+2);
                      if(!isWin(map,temp)){
                          map.put(s,true);
                          return true;
                      }
                  }
            }
            map.put(s,false);
            return false;
    }
}
