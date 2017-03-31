
public class H_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] citations=new int[]{3,0,6,1,5};
        int h=hIndex(citations);
        System.out.println("the h_index of this array is :" +h);
	}
	
	public static int hIndex(int[] citations) {
        if(citations==null||citations.length<1) return 0;
        int len=citations.length;
        int[] array=new int[len+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>len){
                array[len]++;
            }else{
                array[citations[i]]++;
            }
        }
        
        int sum=0;
        for(int i=len;i>=0;i--){
            sum+=array[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }

}
