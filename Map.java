package saskes;

import java.util.Arrays;

public class Map {
	/*0- nenaudojami laukai
	 *1-naudojami laukai
	 *2-Baltuju saskes
	 *5-Juoduju saskes
	 */
	 private int map [][] = new int [][] {  
		
		{0,2,0,2,0,2,0,2}, 
		{2,0,2,0,2,0,2,0}, 
		{0,2,0,2,0,2,0,2}, 
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{5,0,5,0,5,0,5,0}, 
		{0,5,0,5,0,5,0,5},  
		{5,0,5,0,5,0,5,0}, 
		 
	 	};  
	    
	 	public int[][] getMap() {
	 		
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}
	
 	public int getMapValues(int y1, int x1) {
 		return map[y1][x1];
}

public void setMapValues(int y1, int x1, int value) {
	this.map[y1][x1] = value;
}

		public boolean isOutOfBorder(int y, int x) {
			if(x>=this.getWidth() || y>=this.getHeight())
				{
				return false;
				}
				else {
					return true;
					}
		}
		
		public int getHeight() {
			return map.length;
		}
		
		public int getWidth() {
			return map[0].length;
		}
		
		public void changeMap(int y1, int x1, int y2, int x2, int value) {
			
			this.map[y1][x1]=1;
			this.map[y2][x2]=value;	
			if(y2==y1-2 && (x2==x1+2))
				{
				this.map[y1-1][x1+1]=1;
				}
			else if(y2==y1-2 && (x2==x1-2))
			{
			this.map[y1-1][x1-1]=1;
			}
			else if(y2==y1+2 && (x2==x1+2))
			{
			this.map[y1+1][x1+1]=1;
			}
			else if(y2==y1+2 && (x2==x1-2))
			{
			this.map[y1+1][x1-1]=1;
			}
				
					}
		
		public boolean doesCheckersExist() {
			if (Arrays.asList(map).contains(2) && Arrays.asList(map).contains(5)) {
				return false;				
			}
			else {
				return true;
			}			
		}
		
	
}
