import java.util.*;
import java.lang.*;


public class MobilePhoneSet{
	public MobilePhoneNode head;
	public MobilePhoneSet()
	{
		head = null;
	}

	public MobilePhoneSet Union(MobilePhoneSet a){ // Gives the union of two MobilePhoneSet Datatype
		MobilePhoneNode n1 = head;
		MobilePhoneNode n2 = a.head;

		while(n2.next!=null){
			n2 = n2.next;
		}
		n2.next = n1;

		return a;
	}

	public MobilePhoneSet Intersection(MobilePhoneSet a){// Creates a new MobilePhoneSet, it being the intersection of two given MobilePhoneSets.
		MobilePhoneNode n = head;

		MobilePhoneSet inter = new MobilePhoneSet();

		MobilePhoneNode n2 = inter.head;

		if(a.head==null || n==null){

		}

		while(n.next!=null){
			if(a.IsMember(n.value)){
				n2.value = n.value;
				n2 = n2.next;				 
			}
			n = n.next;
		}
	return inter;	
	}

public MobilePhone searchMobile(int value) { // Searches the existence of a mobile phone with the given number as value in a given MobilePhoneSet
	 	if(head==null)
	 		return null;

	 	MobilePhoneNode n = head;

	 	while(n.value.num()!=value && n.next!=null){
	 		n = n.next;
	 	}

	 	if(n.next==null && n.value.num()==value){
	 		return n.value;
	 	}
	 	else if(n.next==null && n.value.num()!=value){
	 		return null;
	 	}
	 	else if(n.next!=null){
	 		return n.value;
	 	}
	 	return null;
	 }
	public Boolean IsMember(MobilePhone o){// Similar utility as the function above
		MobilePhoneNode n = head;

		if(n==null){
			return false;
		}

		while(n.next!=null){
			if(n.value.num()==o.num()){
				return true;	
			}
			n = n.next;
		}
		if(n.next==null){
			return false;
		}
		else{
			return true; 
		}
	}
	public void Insert(MobilePhone o) //throws AlreadyRegistered
	{
		MobilePhoneNode n = head;
		MobilePhoneNode new_node = new MobilePhoneNode(o);

		if(IsMember(o)){
			//throw new AlreadyRegistered("Phone Already Exists");
			return;
		}

		new_node.next = head;
		head = new_node;
	}

	public void addRear(MobilePhone a) //throws AlreadyRegistered
	{
		MobilePhoneNode n = head;
		MobilePhoneNode n1 = new MobilePhoneNode(a);

		if(n==null){
			//System.out.println("Resident List of Exchange " + a.location().value() + " was empty,now being filled");
			head = n1;
			//System.out.println(head.value.num());
			return;
		}
		while(n.next!=null){
			if(n.value.num()==a.num()){
				//throw  new AlreadyRegistered("Phone Already Exists");
				return;
			} 
			else{
				n = n.next;
			}
		}

		n.next = n1;

	}

	public void Delete(MobilePhone o) //throws ElementDoesNotExist
	{
		MobilePhoneNode n = head;
		MobilePhoneNode prev = head;

		if(IsMember(o)==false){
			//throw new ElementDoesNotExist("Removable Element Not Found");
			return;
		}

		if(n==null){
			return;
		}

		if(n.next == null){
			if(n.value.num()==o.num()){
				head = null;
				return;
			}
			else 
				return;
		}

		while(n.value.num()!=o.num() && n!=null){	
			prev = n;
			n = n.next;
		}

		if(n==null){
			System.out.println("Not Found");
			return;
		}

		prev.next = n.next;
	}

	public int size(){
		int count =0;
		MobilePhoneNode n1 = head;

		if(n1==null){
			return count;
		}
		count = 1;
		while(n1.next!=null){
			n1 = n1.next;
			count ++;
		}
		return count;
	}

	    public void printList() 
    { 
        MobilePhoneNode tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.value.num()+" "); 
            tnode = tnode.next; 

        } 
    }

}	
