package linkedlist;

public class LinkedList {
	LinkedList next;
	int data;
	
	public LinkedList(){
		next = null;
		data = -1;
	}
	public LinkedList(int data){
		next = null;
		this.data = data;
	}
    
	void dump(){
		LinkedList n = this;
		while (n != null){
			System.out.print(n.data);
            n = n.next;
            if (n!=null){
    			System.out.print("->");
            }
		}
		System.out.println();		
	}
    
	// The real list is contained in this.next
	boolean removeKthElement(final int k){
		//traverse the list k times and keep the first pointer.
		
		//From that point onwards, increment both at the same time.
		
		//when second pointer reaches the end, delete the element pointed by the first pointer
        int count = 0;
        LinkedList next = this.next;
        while(count < k && next != null){
        	next = next.next;
        	count++;        	
        }
        
        if (next == null){
            if (count == k){
            	//remove element pointed by l
            	this.next = this.next.next;
                return true;
            }else {
            	//list has less than k elements
            	return false;
            }
        }
        LinkedList previous = this.next;
        LinkedList pp = null;
        
        while(next !=null){
        	next 	 = next.next;
        	pp 	  	 = previous;
        	previous = previous.next;
        }
        
        //now we should remove the object pointed by previous
        pp.next = previous.next;
		return true;      	
	}
    
    //swap every 3i and 3i+2 node
    //asked at zynga interview
	static LinkedList swapThirdNode(LinkedList head) {
        LinkedList first = head;
        LinkedList second;
        LinkedList third;
        LinkedList first2;
        
        LinkedList retval = null;
        if (head == null) return head;
        if (head.next == null) return head;
        if (head.next.next == null) return head;
        retval = head.next.next;

        LinkedList thirdNodeFromLastLoop = null;
        while (true) {
            if (first == null) break;
            second = first.next;
            if (second == null) break;
            third = second.next;
            if (third == null) break;
            LinkedList fourth = third.next;

            //now do the swap
            first2 = first;
            fourth = third.next;
            first = third;
            first.next = second;
            second.next = first2;
            first2.next = fourth;

            if (thirdNodeFromLastLoop != null) {
                thirdNodeFromLastLoop.next = first;
            }

            thirdNodeFromLastLoop = first2;

            first = fourth;
        }

        return retval;
    }
	
    public static void testSwapThirdNode(){
		LinkedList list = new LinkedList(0);
		LinkedList n = new LinkedList(1);
		LinkedList n2 = new LinkedList(2);
		LinkedList n3 = new LinkedList(3);
        list.next = n;
		n.next  = n2;
		n2.next = n3;
//        list.dump(); list = LinkedList.swapThirdNode(list);list.dump();
    	
		LinkedList n4 = new LinkedList(4);
		LinkedList n5 = new LinkedList(5);
		LinkedList n6 = new LinkedList(6);
        n3.next = n4;
		n4.next = n5;
		n5.next = n6;
        
        list.dump(); list = LinkedList.swapThirdNode(list);list.dump();
    }
    
    public static void test2(){
		LinkedList list = new LinkedList(-1);
		LinkedList n = new LinkedList(1);
		LinkedList n2 = new LinkedList(2);
		LinkedList n3 = new LinkedList(3);
        list.next = n;
		n.next  = n2;
		n2.next = n3;
        list.dump();
        list.removeKthElement(1);
        list.dump();
        list.removeKthElement(1);
        list.dump();
        list.removeKthElement(1);
        list.dump();
        list.removeKthElement(1);
        list.dump();
    }
    
	public static void main(String args[]){
		//test2();
		testSwapThirdNode();
        //TODO do junit testcases
	}
}
