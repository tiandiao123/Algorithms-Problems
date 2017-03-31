
public class H_Index2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] citations=new int[]{1,5,6,6,9,10};
        int res=hIndex(citations);
        System.out.println("the h_index of citations is :"+res);
	}
	public static int hIndex(int[] citations) {
        int left=0;
        int right=citations.length-1;
        int len=citations.length;
        while(left<=right){
            int mid=(left+right)>>1;
            if(citations[mid]==len-mid){
                return len-mid;
            }else if(citations[mid]>len-mid){
               right=mid-1; 
            }else{//citaions[mid]<len-mid;
                left=mid+1;
            }
        }
        return len-(right+1);
    }
}
