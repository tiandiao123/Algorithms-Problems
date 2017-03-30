import java.util.*;

public class perfectnum{
    
    public static void main(String[] args){

        System.out.println("please enter a number ");
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        System.out.println("so the num "+num+" is perfect num?"+checkPerfectNumber(num));

    }

    public static boolean checkPerfectNumber(int num) {
         if(num<=0) return false;
         int sum=0;
         for(int i=1;i*i<=num;i++){
             if(num%i==0){
                 sum+=i;
                 if(i!=num/i){
                     sum+=num/i;
                 }
             }
         }
         
         return sum==2*num;
    }




}
