import java.util.*;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	
	public static int calculate(String s) {
        char[] s_array=s.toCharArray();
        
        Stack<Integer> st=new Stack<>();
        int sign=1;
        int res=0;
        int sum=0;
        for(int i=0;i<s_array.length;i++){
               if(Character.isDigit(s_array[i])){
                   sum=s_array[i]-'0';
                   while(i+1<s_array.length&&Character.isDigit(s_array[i+1])){
                       sum=sum*10+s_array[i+1]-'0';
                       i++;
                   }
                   res+=sign*sum;
                   //System.out.println(res);
               }else if(s_array[i]=='+'){
                   sign=1;
               }else if(s_array[i]=='-'){
                   sign=-1;
               }else if(s_array[i]=='('){
                   st.push(res);
                   st.push(sign);
                   sign=1;
                   res=0;
               }else if(s_array[i]==')'){
                   res=res*st.pop()+st.pop();
                 
               }
        }
        return res;
        
    }

}
