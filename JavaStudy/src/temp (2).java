
public class temp {
	static int findStartNode(int [] petrol, int[] dist){
		int petrolSurplus = 0;
		int startNode = -1;
        for (int i = 0; i < petrol.length; i++){
            
        	petrolSurplus += (petrol[i] - dist[i]);
        	if (startNode == -1 && petrolSurplus >= 0){
        		startNode = i;
        	}
        	if (petrolSurplus < 0) {
            	startNode = -1;
        	}
        }
        return startNode;
	}
}
