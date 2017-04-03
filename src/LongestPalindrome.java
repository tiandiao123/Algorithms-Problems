import java.util.*;
import java.lang.*;

public class LongestPalindrome {
    static private int maxlen=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        maxlen=0;
        
        String s="abccccdd";
        System.out.println("the maxlen of palindrome can be formed by this string is:");
        System.out.println(longestPalindrome(s));
        
	}
	public static int longestPalindrome(String s) {
        int[] lower=new int[26];
        int[] upper=new int[26];
        char[] sarray=s.toCharArray();
        for(int i=0;i<sarray.length;i++){
            if(sarray[i]>='a'&&sarray[i]<='z'){
                lower[sarray[i]-'a']++;
            }else{
                upper[sarray[i]-'A']++;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(lower[i]%2==1) count++;
            if(upper[i]%2==1)count++;
        }
        if(count==0) return sarray.length;
        return sarray.length-(count-1);
   }
   
   
}
