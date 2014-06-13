import java.util.Stack;

public class NextGreaterElement {
    
	static void printNGE(int[] array){
		Stack stack = new Stack();
        
		for (int i =0; i < array.length; i++){
			int current = array[i];
			
			while(!stack.isEmpty()){
				int top = (Integer) stack.peek();
                if (top < current){
                	stack.pop();
                	//found NGE for top
                	System.out.println(top + "->" + current);
                } else {
                	break;
                }
			}
        	stack.push(current);
		}
        
		while(!stack.isEmpty()){
			int top = (Integer) stack.pop();
        	System.out.println(top + "-> -1");
		}
	}
	
	public static void main(String[] args) {
		printNGE(new int[] {7,6,13,2,17,16,20});
		printNGE(new int[] {7,});
		printNGE(new int[] {});
		printNGE(new int[] {7,6,5,4,3,2,1});
	}

}