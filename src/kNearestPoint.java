import java.util.PriorityQueue;
import java.util.Comparator;

public class kNearestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Point[] points=new Point[11];
       for(int i=10;i>=0;i--){
    	   points[10-i]=new Point(i,i);
       }
       
       Point[] res=Solution(points,new Point(0,0),5);
       for(int i=0;i<5;i++){
    	   System.out.println("N0. "+i+" :"+res[i].x);
       }
	}
	
	public static Point[] Solution(Point[] array, Point origin, int k) {
        Point[] rvalue = new Point[k];
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(a, origin) - getDistance(b, origin));
            }
        });
        
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k)
                System.out.println(pq.poll().x+" ");
        }
        while (!pq.isEmpty())
            rvalue[index++] = pq.poll();
        return rvalue;
    }
    private static double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

}
