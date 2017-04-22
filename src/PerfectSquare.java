import java.util.*;

public class PerfectSquare {
	public static int numSquares(int n) {
        if(n<1) return 0;
        if(n==1) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int count=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                count=Math.min(count,1+dp[i-j*j]);
            }
            dp[i]=count;
        }
        return dp[n];
        
    }
}
