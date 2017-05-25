public class maze2{
    
    class static point{
        int x;
        int y;
        int distance;
        point(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.distance=z;
        }
    }
     
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
          int[][] dis = new int[maze.length][maze[0].length];
          for(int i=0;i<maze.length;i++){
              Arrays.fill(dis[i],Integer.MAX_VALUE);
          }
          PriorityQueue<point> pq = new PriorityQueue<>(1,new Comparator<point>(){
                 public int compare(point a,point b){
                      return a.distance-b.distance;
                 }
          });     
          
          pq.offer(new point(start[0],start[1],0));
          dis[start[0]][start[1]]=0;
          
          int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
          
          while(!pq.isEmpty()){
              point t=pq.poll();
              
              for(int[] dir:dirs){
                  int i=t.x;
                  int j=t.y;
                  //if(i<0||i>=maze.length||j<0||j>=maze[0].length||maze[i][j]==1) continue;
                  
                  while(i+dir[0]>=0&&i+dir[0]<maze.length&&j+dir[1]>=0&&j+dir[1]<maze[0].length&&maze[i+dir[0]][j+dir[1]]==0){
                      j+=dir[1];
                      i+=dir[0];
                  }
                  
                  int r=t.distance+Math.abs(j-t.y)+Math.abs(i-t.x);
                  if(dis[i][j]>r){
                      dis[i][j]=r;
                      pq.offer(new point(i,j,r));
                  }
      
                }
              }
              
           int res=dis[destination[0]][destination[1]];
           return res==Integer.MAX_VALUE ? -1:res;
          }
}