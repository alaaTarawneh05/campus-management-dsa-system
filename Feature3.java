package FinalCode;


// graph

public class Feature3 {
	
	
	public int buildNum;
	private int[][] adjMatrix;
	
	
	
	
	public Feature3(int buildNum ) {
		this.buildNum=buildNum;
		adjMatrix = new int[buildNum][buildNum];
		}
	
	
	
	
	
	// o(1)
	
	public void addPath(int from,int to,int dis) {
		
		if(from<0 || from>=buildNum || to<0 || to>=buildNum) {
			System.out.println("Invalid building number");
			return;
		}if(dis <= 0){
			System.out.println("Invalid distance : ");
			return;
		}
		
		adjMatrix[from][to]=dis;
		adjMatrix[to][from]=dis;
	}
	
	

	
	
	
	public void findShortestPath(int start, int end) {
		
		if( start <0 || start>=buildNum || end<0 || end>=buildNum) {
			System.out.println("Invalid input, it must be between 0 and "+(buildNum-1));
			return;
		}
		
		
		int [] dis=new int[buildNum];
		boolean [] visited = new boolean[buildNum];
		int[] prev = new int[buildNum];
		
		
		for (int i=0 ; i<buildNum ; i++) {
			dis[i]=Integer.MAX_VALUE;
			prev[i]=-1;	// no previous array at beginning
			
		} dis[start]=0; // distance between b0 and b0 is 0
		
		
		
		
		
		
		
		
		// dijkstra'a algorithm
		
		// calculate shortest path
		for (int i=0; i< buildNum-1  ; i++ ) {

		 int u=-1; // to store the building with the smallest distance to calculate the neighbors of it. 
		 
		 int min = Integer.MAX_VALUE;
		 
		 for(int k=0; k<buildNum ; k++) {
			 
			 if(!visited[k] && dis[k]<min) {
             min=dis[k];
        	 u=k;
        	 
          }}
		 
		 // no more vertices to visit
		 if(u==-1) break;
		 
		 
		 visited[u]=true;
		 
		 
         // relaxation

		 for(int v=0; v<buildNum;v++ ) {
			 
	//Check if building `v` is unvisited and 
	// connected to `u` (non-zero entry in adjacency matrix)
			 
			 
			 if(!visited[v] && adjMatrix[u][v] != 0  && dis[u] != Integer.MAX_VALUE && 
					 dis[u]+adjMatrix[u][v]<dis[v] ) {
				 dis[v]=dis[u]+adjMatrix[u][v];
				 prev[v]=u;
			 }
			 }
		 
		 
		 }
		
		
		
		if( dis[end]==Integer.MAX_VALUE ) {
			System.out.println("There is no path between the buildings");
			return;
		}else {
            System.out.println("Shortest distance from building "+start+" to building "+end +": "+ dis[end]);
			System.out.print("path:");
			
			
			pathPrinter(prev,end);
			
			System.out.println();
		}}
	

	
   private void pathPrinter(int[] prev , int curr) {
	   
		if(prev[curr] != -1) {
			
			pathPrinter(prev, prev[curr]);
			System.out.print(" -> ");

		}
		
		System.out.print(curr);
			
		
		
	}
	
	
	
	
	

}
