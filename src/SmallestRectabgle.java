import java.util.*;

public class SmallestRectabgle {
    public static int minArea(char[][] image, int x, int y) {
        if(image==null || image.length<1) return 0;
        
        int left=searchLeftCol(image,0,y,0,image.length-1);
        int right=searchRightCol(image,y+1,image[0].length,0,image.length-1);
        
        int up=searchUpRow(image,left,right,0,x);
        int below=searchLowRow(image,left,right,x+1,image.length);
        
        return (right-left)*(below-up);
    }
    
    public static int searchLeftCol(char[][] image,int left,int right,int up,int low){
        
        while(left<right){
            int k=up;
            int mid=(left+right)>>>1;
            
            while(k<=low&&image[k][mid]=='0') k++;
            
            if(k>low){
              left=mid+1;    
            }else{
              right=mid;
            }
         }
        
        return left;
        }
        
	
    public static int searchRightCol(char[][] image,int left,int right,int up,int low){
        
        while(left<right){
             int k=up;
             int mid=(left+right)>>>1;
            
             while(k<=low&&image[k][mid]=='0') k++;
            
             if(k>low){
               right=mid;    
            }else{
              left=mid+1;
            }
        }
        
        return left;
    }
	
	
	public static int searchUpRow(char[][] image,int left,int right,int up,int low){
        while(up<low){
            int mid=(up+low)>>>1;
            int k=left;
            while(k<right&&image[mid][k]=='0') k++;
            
            if(k>=right){
                up=mid+1;
            }else{
                low=mid;
            }
            
        }
        return up;
    }
	public static int searchLowRow(char[][] image,int left,int right,int up,int low){
        while(up<low){
            int mid=(up+low)>>>1;
        
            int k=left;
            while(k<right&&image[mid][k]=='0') k++;
        
            if(k>=right){
                low=mid;
            }else{
                up=mid+1;
            }
        
        }
        return up;
    }
}
