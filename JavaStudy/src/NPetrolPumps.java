// http://www.careercup.com/question?id=11316872

/* Suppose there is a circle. You have five points on that circle. Each
point corresponds to a petrol pump. You are given two sets of data.

1. The amount of petrol that petrol pump will give.
2. Distance from that petrol pump tp the next petrol pump.

(Assume for 1 lit Petrol the truck will go 1 km)

Now calculate the first point from where a truck will be able to
complete the circle.
(The truck will stop at each petrol pump and it has infinite
capacity).
Give o(n) solution. You may use o(n) extra space.
*/

public class NPetrolPumps {
    
	static int findStartNode(int [] petrol, int[] dist){
		int sum = 0;
		int startPoint = -1;
		for (int i=0;i< petrol.length;i++){
			sum += (petrol[i]-dist[i]);
			if (sum < 0){
				startPoint = -1;
			}else if (startPoint == -1){
				startPoint = i;
			}
		}
		if (startPoint == -1){
//			System.out.println("Can not find");	
		}else{
//			System.out.println("found start point:" + startPoint);
		}
		
        return startPoint;
	}
	
	static int findStartNode2(int [] petrol, int[] dist){
		int petrolSurplus = 0;
		int startNode = -1;
        for (int i = 0; i < petrol.length; i++){
            
        	petrolSurplus += (petrol[i] - dist[i]);
        	if (petrolSurplus >= 0){
            	if (startNode == -1 )
            		startNode = i;
        	} else {
            	startNode = -1;
        	}
        }
        return startNode;
	}
    
	public static void main(String[] args) {
		int[] petrol = {3,5,4}; int[] dist= {3,7,3}; int startNode = findStartNode(petrol, dist); System.out.println("startNode = " + startNode);
	}
}
