import java.util.*;

class MyLinkedList{
	public Node head;

	/*

	public class Node{
		Exchange value;
		Node next;

		public Node(Exchange value){
			this.value = value;
			next = null;
		}
	}
	*/

	public MyLinkedList()
	{
		head = null;
	}

	public Boolean isEmpty(){
		if(head==null){
			return true;
		}
		else{
			return false;
		}
	}

	public int size(){
		int count =0;
		Node n1 = head;

		if(n1==null){
		//	System.out.println("Count is null");
			return count;
		}
		count = 1;
		while(n1.next!=null){
			n1 = n1.next;
			//	System.out.printf("Count no " + count);
			count ++;

		}
		return count;
	}
	public void add(Exchange a){
		Node n1 = new Node(a);

		n1.next = head;
		head = n1;	
	}

	public void addRear(Exchange a) //throws AlreadyRegistered
	{
		Node n = head;
		Node n1 = new Node(a);

		if(n==null){
			head = n1;
			return;
		}

		while(n.next!=null){
			if(n.value.value()==a.value()){
				//throw new AlreadyRegistered("The Exchange Already Exists");
				return;
			}

			n = n.next;
		}

		n.next = n1;

	}
	public void delete(Exchange a)// throws ElementDoesNotExist
	{
		Node n = head;
		Node prev = head;
		
		if(n==null){
			return;
		}

		while(n.value.value()!=a.value() && n!=null){
			prev = n;
			n = n.next;
		}

		if(n==null){
			//throw new NoSuchElementException();
			return;
		}

		prev.next = n.next;

	}
	 public Exchange readFront(){
	 	return head.value;
	 }

	 public Boolean isMember(Exchange a) throws ElementDoesNotExist{
	 	if(head==null){
	 		return false;
	 	}
	 	Node n = head;

	 	while(n.value!=a && n.next!=null){
	 		n = n.next;
	 	}

	 	if(n.next==null){
	 		throw new ElementDoesNotExist("The exchange is not a member");
	 	}
	 	else{
	 		return true;
	 	}

	 }	

    public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.value.value()+" "); 
            tnode = tnode.next; 

        } 
    }

	public void reverseList(){
		Node reversedPart = null;
		Node current = head;
		while (current != null) {
		    Node next = current.next;
		    current.next = reversedPart;
		    reversedPart = current;
		    current = next;
		}
		head = reversedPart;

	} 

}
