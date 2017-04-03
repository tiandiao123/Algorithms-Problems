
import java.util.*;
public class countNumbersWithUniqueDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("please enter an num>=0(Integer):");
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        System.out.println("now the total num of Numbers with unqiue digist:"+CountNumbersWithUniqueDigits(num));
        
	}
    public static int CountNumbersWithUniqueDigits(int n) {
        int[] dp=new int[11];
        dp[0]=1;
        dp[1]=9;
        int i=2;
        while(i<=n){
            if(i>10) break;
            dp[i]=(11-i)*dp[i-1];
            i++;
        }
        int res=0;
        for(int j=0;j<=n;j++){
            if(j>n) break;
            res+=dp[j];
        }
        
        return res;
        
    }
}
