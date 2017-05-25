import java.util.*;
import java.lang.*;

public class Maze1 {
	    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
	         boolean[][] visited=new boolean[maze.length][maze[0].length];
	         if(dfs(maze,visited,start,destination)){
	             return true;
	         }
	         
	         return false;
	    }
	    
	    public static boolean dfs(int[][] maze,boolean[][] visited,int[] start,int[] destination){
	          if(visited[start[0]][start[1]]) return false;
	          int x=start[0];
	          int y=start[1];
	          if(x==destination[0]&&y==destination[1]){
	              return true;
	          }
	          visited[x][y]=true;
	          
	          int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
	          for(int[] dir:dirs){
	              int i=dir[0]+x;
	              int j=dir[1]+y;
	              
	              if(i<0||i>=maze.length||j<0||j>=maze[0].length||maze[i][j]==1){
	                  continue;
	              }
	              
	              if(dir[0]!=0){
	                 while(i>0&&i<maze.length-1&&maze[i+dir[0]][j]==0){
	                     i+=dir[0];
	                 }
	              }else if(dir[1]!=0){
	                  while(j>0&&j<maze[0].length-1&&maze[i][j+dir[1]]==0){
	                      j+=dir[1];
	                  }
	              }
	              
	              if(dfs(maze,visited,new int[]{i,j},destination)){
	                  return true;
	              }
	          }
	          
	          return false;
	    }
	
}
