import java.util.*;


public class AdditiveNumber{

    public static void main(String[] args){
        String num="199100199";

        System.out.println("the num 199100199 is AdditiveNumber? the answer is :"+isAdditiveNumber(num));


    }

    public static boolean isAdditiveNumber(String num) {
        if(num==null||num.length()<3) return false;
        
        for(int i=0;i<=num.length()-3;i++){
            if(i!=0&&num.charAt(0)=='0') break;
            for(int j=i+1;j<=num.length()-2;j++){
                if(j!=i+1&&num.charAt(i+1)=='0') break;
                
                long num1=Long.parseLong(num.substring(0,i+1));
                long num2=Long.parseLong(num.substring(i+1,j+1));
                if(check(num,j+1,num1,num2)) return true;
            }
        }
        
        return false;
    }
    
    public static boolean check(String num,int index,long num1,long num2){
        if(index==num.length()) return true;
        
        long nextnum=num1+num2;
        
        for(int i=index;i<num.length();i++){
            if(i!=index&&num.charAt(index)=='0') break;
            
            if(Long.parseLong(num.substring(index,i+1))==nextnum&&check(num,i+1,num2,nextnum)){
                return true;
            }
        }
        
        return false;
    }


}