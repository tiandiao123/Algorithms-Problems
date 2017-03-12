import java.util.*;

public class slidingwindowmin{

    public static void main(String[] args){
    	int[] nums=new int[]{1,2,5,3,8,9,10,11,3,4,-1};
    	int[] res=maxSlidingWindow(nums,3);
    	System.out.println("the final return res is:");
    	for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
    	}
    	System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<1) return new int[0];
        Deque<Integer> deque=new ArrayDeque<>();
        int[] res=new int[nums.length-k+1];
        
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&deque.peek()<=i-k){
                  deque.poll();
            }
            while(!deque.isEmpty()&&nums[deque.peekLast()]>=nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                res[j++]=nums[deque.peek()];
            }
        }
        
        return res;
    }
}