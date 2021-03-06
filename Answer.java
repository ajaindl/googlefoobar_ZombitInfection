package testing;

//obviously not the quickest way to solve this problem, but i was focusing on writing modularized code that contained reusable components
//given a change in the problem.
public class Answer {   
    public static int[][] answer(int[][] population, int x, int y, int strength) { 
    	if(population.length<x){
    	    return population;
    	}
    	if(population[y].length<y){
    	    return population;
    	}	
    	if(population[x][y]<=strength) {
    		population[x][y]=-1;
    		int[][] pointList;
    		pointList= CreatePoints(x,y,strength);
    		int length= population[x].length;
    		population = CheckPoints(population, pointList, strength, length);
    		return population;
    	}
    			
    		return population;
    } 

    public static Boolean IsSafeDown(int x) {
    	if (x-1>=0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public static Boolean IsSafeUp(int x, int length) {
    	if (x+1<length) {
    		return true;
    	}
    	else {
    		return false;
    	}
    
    }
    public static int[][] CheckPoints (int[][] arr, int[][] points, int s, int length){
    	int[][] recursivePoints = new int[4][2];
    	boolean notNull = false;
    	for(int[] array : arr){
    	    for(int val : array){
    	      if(val!=0){
    	        notNull=true;
    	        break;
    	      }
    	    }
    	}
    	if(notNull){
    	for(int[] point : points) {
    		if (arr[point[0]][point[1]]<=s && arr[point[0]][point[1]]!=-1) {
    			arr[point[0]][point[1]]=-1;
    			recursivePoints = CreatePoints(point[0], point[1], length);
    			arr = CheckPoints(arr, recursivePoints, s, length);
    		}
    	}
    	}
    	return arr;
    }
    public static int[][] CreatePoints (int x,int y,int s) {
    	int[][] points = new int[4][2];
    	int counter = 0;
    	if(IsSafeDown(x)) {
            int[] point= {x-1, y};
            points[counter]=point;
            counter+=1;
    	}
    	if(IsSafeUp(x, s)) {
        	int[] point= {x+1, y};
        	points[counter]=point;
        	counter+=1;
        	}
    	if(IsSafeDown(y)) {
        	int[] point= {x, y-1};
        	points[counter]=point;
        	counter+=1;
        	}
    	if(IsSafeUp(y, s)) {
        	int[] point= {x, y+1};
        	points[counter]=point;
        	counter+=1;
        	}
    	
    	return points;
    }
    public static void main (String[] args) {
   
    }
}
