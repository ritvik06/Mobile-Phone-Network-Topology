import java.util.*;
import java.lang.*;

public class Exchangelist{
	public MyLinkedList list;

	public Exchangelist(){
		list = new MyLinkedList();	
	}

	public Exchange child(int i){
       // System.out.println(list.size()+ " Size");

        if(i<0 || i>list.size()){
            System.out.println("error-Index out of range");
            System.exit(0);        }

        else
        {
          //  System.out.println("wrong");
            Node n1 = list.head;
            for(int j=0;j<i;j++)
            {
                n1 = n1.next;
            }
            return n1.value;
        }
        return null;
	}

    public void printList() 
    { 
        Node tnode = list.head; 
        while (tnode != null) 
        { 
           System.out.print(tnode.value.value()+" "); 
            tnode = tnode.next; 

        } 
    }
}
