package linkedlist;

class MergeSortLinkedList {

    static class Node {
    	Node next;
    	int data;
    	
    	public Node(int data){
    		this.data = data;
    		next = null;
    	}
    
        static Node breakLL(Node head){
        	assert head.next != null;
        	
            Node slow = head;
            Node slowPrev = null;
            Node fast = head.next;
            
            if (fast.next == null){
            	//only 2 nodes
            	Node second = head.next;
            	head.next = null;
            	return second;
            }
            
            //keep going till fast is null. when that happens slow will point to the 2nd list
            while(fast != null){
            	fast = fast.next;
            	if (fast != null){
            		fast = fast.next;
                    slowPrev = slow;
            		slow = slow.next;
            	}
            }
        	
            slowPrev.next = null;
            return slow;
        }
        
        static Node merge(Node part1, Node part2){
            assert part1 != null;
            assert part2 != null;
            
            Node mergedHead = null;
            Node mergedTail = null;
            
            Node p = part1;
            Node q = part2;
            
            //lets initialize mergedHead & mergedTail
        	if (p.data < q.data){
                mergedHead = mergedTail = p;
                p = p.next;
        	} else {
                mergedHead = mergedTail = q;
                q = q.next;
        	}
            mergedTail.next = null;
            
            while (p != null && q != null){
            	if (p.data < q.data){
            		//copy over p to merged
                	mergedTail.next = p;
                	mergedTail = p;
                    
                	Node pnext = p.next;
                	p.next = null;
                    p = pnext;
            	} else {
            		//copy over q to merged
                	mergedTail.next = q;
                	mergedTail = q;
                	Node qnext = q.next;
                	q.next = null;
                    q = qnext;
            	}
            }
            
            if (p != null){
            	mergedTail.next = p;
            }
            if (q != null){
            	mergedTail.next = q;
            }
            
            return mergedHead;
        }
        
        static Node mergesort(Node head){
        	
        	//base condition
        	if (head.next == null){
        		return head;
        	}
        	
        	//break up into 2 parts
            Node secondHalf = breakLL(head);
            assert secondHalf != null;
        	
        	//recursively mergesort
            Node part1 = mergesort(head);
            Node part2 = mergesort(secondHalf);
        	
            //merge both parts
            Node mergedHead = merge(part1, part2);
            
        	//return new head
            return mergedHead;
        }
        
        static void dump(Node head){
        	while(head != null){
        		System.out.print(head.data + "->");
                head = head.next;
        	}
    		System.out.println();
        }
        
        static void test() {
    		Node head = new Node(10); 
    		Node.dump(head);
    		Node merged = Node.mergesort(head); 
    		Node.dump(merged);
                       
    		Node second = new Node(5);
            merged.next = second;
            dump(head);
            merged = mergesort(head); 
            dump(merged);
            
    		Node third = new Node(1);
            head.next = third;
            dump(merged);
            merged = mergesort(merged); 
            dump(merged);
            
            merged.next.next.next = new Node(0);
            dump(merged);
            merged = mergesort(merged); 
            dump(merged);
            
            second = merged.next;
            merged = new Node(6);
            merged.next = second;
            dump(merged);
            merged = mergesort(merged); 
            dump(merged);
            
            Node first = merged;
            merged = new Node(60);
            merged.next = first;
            dump(merged);
            merged = mergesort(merged); 
            dump(merged);
        }
    }
    
    public static void main(String[] args) {
        Node.test();
	}
}
