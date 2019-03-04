import java.util.*;
import java.lang.*;

public class Exchange{
	private int number;
	private Exchange parent;
	private Exchangelist children;
	private MobilePhoneSet residentSet;
	private Boolean isRoot=false;

	public Exchange(int number){
		this.number = number;
		children = new Exchangelist();
		residentSet = new MobilePhoneSet();
	}

	public int value(){
		return number;
	}

	public Exchange parent(){
		return parent;
	}

	public Exchangelist children(){
		return children;
	}

	public int numChildren(){
		return children.list.size();
	}

	public Exchange child(int i){
		return children.child(i);
	}

	public Boolean isRoot(){
		return isRoot; 	
	}

	public void addRoot(){
		isRoot = true;
	}

	public RoutingMapTree subtree(int i){
		Exchange child_i = child(i);
		if(child_i!=null){
			RoutingMapTree subT = new RoutingMapTree(child_i);
			return subT;
		}
		else{
			return null;
		}
	} 

	public MobilePhoneSet residentSet(){
		return residentSet;
	}

	public void register(MobilePhone a){
		//System.out.println("Register function being deployed");
		residentSet.addRear(a);
	}
	

	public void Deregister(MobilePhone a){
		residentSet.Delete(a);
	}

	public void setParent(Exchange a){
		parent = a;
	}

	public String strCaste(){
		String caste = "";
		return (caste + String.valueOf(number));
	}
	
}
