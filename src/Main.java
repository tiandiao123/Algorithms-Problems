    import java.util.*;
    import java.io.*;
    import java.lang.*;
     
    public class Main
    {
              public static void main (String[] args) throws IOException
              {
                       BufferedReader r=new BufferedReader(new InputStreamReader(System.in));

                       int a=Integer.parseInt(r.readLine());
                       for(int i=0;i<a;i++){
                       		int length=Integer.parseInt(r.readLine());
                       		String str=r.readLine();
                       		if(checkvalid(str)){
                       			System.out.println("Valid");
                       		}else{
                       			System.out.println("Invalid");
                       		}
                       }
     
              }
     
              public static boolean checkvalid(String str){
                    char[] array=str.toCharArray();
                    
                    char pre='.';
                    int i=0;
                    while(i<array.length&&array[i]=='.'){
                    	i++;
                    }
     				if(i==array.length) return true;

                    if(array[i]=='T') return false;
                    else{
                    	pre=array[i++];
                    }
     
                    for(;i<str.length();i++){
                       if(array[i]=='.'){
                          continue;
                       }else if(array[i]=='H'){
                       	   if(pre!='T'){
                       	   	return false;
                       	   }
                       	   pre='H';
     
                       }else if(array[i]=='T'){
                       	  if(pre!='H'){
                       	  	return false;
                       	  }
                       	  pre='T';
                       }
                    }
     
                    return pre=='T';
              }
    }  