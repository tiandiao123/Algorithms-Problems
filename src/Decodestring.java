import java.util.*;

public class Decodestring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(decode("3[a2[bd]g4[ef]h]"));   
	}
	
	public static String decode(String str){
	    if(str==null||str.length()<1) return null;

	    Stack<String> st=new Stack<>();
	    char[] strarray=str.toCharArray();
	    int num=1;
	    st.add("");
	    
	    String temp="";
	    String sumstr="";
	    for(int i=0;i<strarray.length;i++){
	    	if(Character.isLetter(strarray[i])){
	    	     temp=""+strarray[i];
	    	     while(i+1<strarray.length&&Character.isLetter(strarray[i+1])){
	    	     	temp=temp+strarray[i+1];
	    	     	i++;
	    	     }
	    	      sumstr+=temp;
	    	}else if(Character.isDigit(strarray[i])){
	    		num=strarray[i]-'0';
	    		while(i+1<strarray.length&&Character.isDigit(strarray[i+1])){
	                num=num*10+strarray[i+1]-'0';
	    			i++;
	    		}
	    	}else if(strarray[i]=='['){
	             st.add(sumstr);
	             st.add(String.valueOf(num));
	             sumstr="";
	             num=1;
	    	}else if(strarray[i]==']'){
	             int getnum=Integer.parseInt(st.pop());
	             String t=st.pop();
	             for(int j=0;j<getnum;j++){
	                 t=t+sumstr;
	             }
	             sumstr=t;
	    	}
	    }

	     return sumstr;

	}

}
