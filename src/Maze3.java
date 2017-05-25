import java.util.*;
import java.lang.*;

public class Maze3{
    
    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        point[][] points=new point[maze.length][maze[0].length];
        
        PriorityQueue<point> pq=new PriorityQueue<>();
        
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points[0].length;j++){
                points[i][j]=new point(i,j,Integer.MAX_VALUE,"");
            }
        }
        
        points[ball[0]][ball[1]].l=0;
        pq.offer(points[ball[0]][ball[1]]);
        
        while(!pq.isEmpty()){
            point t=pq.poll();
            int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
            for(int[] dir:dirs){
                int i=t.x;
                int j=t.y;
                while(i+dir[0]>=0&&i+dir[0]<maze.length&&j+dir[1]>=0&&j+dir[1]<maze[0].length&&maze[i+dir[0]][j+dir[1]]==0&&(i!=hole[0]||j!=hole[1])){
                    i+=dir[0];
                    j+=dir[1];
                }
                
                if(i==t.x&&j==t.y) continue;
                int r=Math.abs(i-t.x)+Math.abs(j-t.y);
                
                char c=get(dir);
                point temp=new point(i,j,r+t.l,points[t.x][t.y].str+c);
                
                if(points[i][j].compareTo(temp)>0){
                    pq.offer(points[i][j]);
                    points[i][j].l=r+t.l;
                    points[i][j].str=points[t.x][t.y].str+c;
                }
            }
        }
        
        String str=points[hole[0]][hole[1]].str;
        if(str==""){
            return "impossible";
        }
        return str;
    }
    
    public static char get(int[] dir){
            char c=' ';
            if(dir[0]==1&&dir[1]==0){
                c='d';
            }else if(dir[0]==0&&dir[1]==-1){
                c='l';
            }else if(dir[0]==0&&dir[1]==1){
                c='r';
            }else if(dir[0]==-1&&dir[1]==0){
                c='u';
            }
            
            return c;
    }
    
    class static point implements Comparable<point> {
        int x;int y;
        int l;
        String str="";
        
        point(int x,int y,int l,String str){
            this.x=x;
            this.y=y;
            this.l=l;
            this.str=str;
        }
        
        public int compareTo(point b){
            if(l==b.l){
                return str.compareTo(b.str);
            }else{
                return l-b.l;
            }
        }
    }
}