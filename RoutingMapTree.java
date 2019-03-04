import java.util.*;

public class RoutingMapTree{
	Exchange root;

	public RoutingMapTree(){
		root = new Exchange(0);	
		root.addRoot();
	}

	public RoutingMapTree(Exchange root){
		this.root = root;
	}	

	public Boolean containsNode(Exchange a) {
		int i;

		if(root==a){
			return true;
		}

		for(i=0;i<root.numChildren();i++){
				if(root.subtree(i+1).containsNode(a)){
					return true;
				}
		}

		return false;

	}

	public Exchange searchTree(int id) {
		Exchange check=null;

		if(root.value()==id)
			return root;
	

		for(int i =0;i<root.numChildren();i++){
			if(root.subtree(i)!=null){
				check = root.subtree(i).searchTree(id);
						if(check!=null){
							return check;
						}
			}
		}
	

		return null;
	}

	public void switchOff(MobilePhone a) {
		//root.residentSet().printList();
			if(a.status()==true){
				Exchange b = a.location();
				a.switchOff();

			/*b.Deregister(a);

				while(b.isRoot()!=true){
					b = b.parent();
					b.Deregister(a);
				}*/

			}

			else if(a.status()==false){
				System.out.println("Mobile Phone " + a.num() + " already switched off");
			}
	}

	public void switchOn(MobilePhone a,Exchange b){
		if(a.status()==true){
			System.out.println("Mobile Phone Already Turned On");
			return;			
		}

		else{
			a.switchOn();
			a.setBts(b);

			//System.out.println(a.num() + " is now switched on with " + b.value());

			//System.out.println("The status of mobile " + a.num() +" is " + a.status());

			b.register(a);

			



			while(b.isRoot()!=true){
				b=b.parent();
				b.register(a);
			}
		}

	}

 	public Exchange findPhone(MobilePhone m){
		 		

 		if(m==null){
 			return null;
 		}

 		else if(m.status()==false){
 			return m.location();
 			
 		}

 		else{
 			return m.location();
 		}

 	}

 	public Exchange lowestRouter(Exchange a,Exchange b){
 		if(a==null || b==null){
 			return null;	
 		}

 		if(a==b){
 			return a;
 		}

 		else if(a.parent()==root && b.parent()==root){
 				return root;
 			}
 		else{
 			return lowestRouter(a.parent(),b.parent());
 		}
 	}

 	public Exchangelist routeCall(MobilePhone a, MobilePhone b){
 		Exchangelist route1 = new Exchangelist();
 		Exchangelist route2 = new Exchangelist();

 		MobilePhone mobile1 = root.residentSet().searchMobile(a.num());
 		MobilePhone mobile2 = root.residentSet().searchMobile(b.num());

 		if(mobile1==null || mobile2==null){                                                       
 			System.out.println("error-Mobile Phone not found");
 		}

 		Exchange lowestA = findPhone(a);
 		Exchange lowestB = findPhone(b);

 		

 		//System.out.println("route call " + lowestA.value() + " " + lowestB.value());

 		if(lowestA==lowestB){
 			route1.list.addRear(lowestA);
 			return route1;
 		}

 		Exchange itr = lowestA;
 		while(itr!=lowestRouter(lowestA,lowestB)){
 			route1.list.addRear(itr);
 			itr = itr.parent();
 		}

 		route1.list.addRear(itr);

 		itr = lowestB;

 		while(itr!=lowestRouter(lowestA,lowestB)){
 			route2.list.addRear(itr);
 			itr = itr.parent();
 		}

 		route2.list.reverseList();

 		Node itr2 = route1.list.head;

 		while(itr2.next!=null){
 			itr2 = itr2.next;
 		}

 		itr2.next = route2.list.head;

 		return route1;
 	}

 	public void movePhone(MobilePhone a,Exchange b){
 		MobilePhone m1 = root.residentSet().searchMobile(a.num());
 		if(m1==null){
 			System.out.println("Mobile Phone to be moved does not exist");
 			return;
 		}
 		else if(m1.status()==false){
 			System.out.println("Mobile Phone currently switched off");
 			return;
 		}

 		else{
 			switchOff(m1);
 			switchOn(m1,b);
 		}
 		return;
 	}

	public String performAction(String actionMessage){
		Scanner input = new Scanner(actionMessage);
		String message = input.next();
		//System.out.println(actionMessage);

		if(message.equals("addExchange")){
		//	System.out.println("addExchange");
			Exchange a = searchTree(input.nextInt());
			if(a==null){
			//	System.out.println(" error in reading while handling addExchange\n");
				//return error
				
			System.out.print("error-the exchange does not exist");
			}

			//else{
			//	System.out.println(" adding exchange");
				Exchange b = new Exchange(input.nextInt());
				a.children().list.addRear(b);
				b.setParent(a);
				//System.out.println(b.parent().value());
				//System.out.print("\n");
				//System.out.println(b.value());
			//} 
			
			

		}	


		else if(message.equals("switchOnMobile")){
			int num = input.nextInt();
			Exchange exc2b = searchTree(input.nextInt());

		//	System.out.println("switchOnMobile " + num + " to exchange " + exc2b.value());	

			//System.out.print("the resident set is ");
			//exc2b.residentSet().printList();

			MobilePhone mobile = root.residentSet().searchMobile(num);

			if(exc2b==null){
				//return error
				System.out.print("error-Exchange does not exist");
				//System.out.println("Exchange Does Not Exist");
			}

			if(mobile == null){
				mobile = new MobilePhone(num);
				//System.out.println("New Mobile being added with number " +  num);
				switchOn(mobile,exc2b);
				//exc2b.residentSet().printList();
			}
			
			else{
				if(mobile.status()){
					System.out.println("Mobile phone " + mobile.num() +  "already exists and is on");
					
				}
				else{
					mobile.setStatus(true);
					Exchange der = mobile.location();
					//System.out.println("Mobile was earlier registered at " + der.value());
					mobile.switchOff();
					der.Deregister(mobile);

					while(der.isRoot()!=true){
						der = der.parent();
						der.Deregister(mobile);
					}
					switchOn(mobile,exc2b);
				}
			}


		}
		
		else if(message.equals("switchOffMobile")){
			//System.out.println("switchOffMobile");
			int num = input.nextInt();

			MobilePhone mobile = root.residentSet().searchMobile(num);

			if(mobile==null){
				System.out.print("error-Mobile does not exist");
				
			}

			else{
				if(!mobile.status()){
					System.out.println("Mobile Phone is already off");
					
				}
				else{
					switchOff(mobile);
					Exchange der = mobile.location();	
					der.Deregister(mobile);

					while(der.isRoot()!=true){
						der = der.parent();
						der.Deregister(mobile);
					}
				}

			}
			//root.residentSet().printList();

		}

		else if(message.equals("queryNthChild")){

			Exchange exc4a = searchTree(input.nextInt());

			//System.out.println("afterSearchTree");
			int exc4b = input.nextInt();
				

			if(exc4a!=null){
					//System.out.println(exc4a.child(exc4b));
					return("queryNthChild " + exc4a.value() + " " + exc4b + ": " + exc4a.child(exc4b).value());
				//else
					//print error
			}
			else{
				return("error-Exchange a does not exist");
			}

		}
		else if(message.equals("queryMobilePhoneSet")){
			Exchange exc5a = searchTree(input.nextInt());

			//exc5a.residentSet().printList();

			String phoneSet = "";

			if(exc5a==null){
				//print error
				//return set;
				return("error-Exchange does not exist");
			}

			else{
				int count = 0;

				MobilePhoneSet mobilePhones = exc5a.residentSet();

				MobilePhoneNode n1 = mobilePhones.head;

			if(n1==null){
				return phoneSet;	
			}

				while(n1!=null){
					if(count<(mobilePhones.size()-1)){
						if(n1.value.status()==true){
							phoneSet += n1.value.strCaste() + ", ";
						}
					}	
					else{
						phoneSet += n1.value.strCaste();
					}
					count++;
					n1 = n1.next;
				}

				return("queryMobilePhoneSet " + exc5a.value() + ": " + phoneSet);
				//exc5a.residentSet().printList();
			}


		}

		else if(message.equals("findPhone")){
			int Mnumber = input.nextInt();

			MobilePhone findMobile = root.residentSet().searchMobile(Mnumber);

			if(findMobile==null){
 				System.out.println("queryFindPhone " + Mnumber + ": Error - No mobile phone with identifier " + Mnumber  + " found in the network");
			}



			Exchange newExchange = findPhone(findMobile);
			/*if(newExchange==null){
				System.out.println("Exchange for registered Mobile Phone cannot be found");
				System.exit(0);	
			}*/
			if(newExchange!=null  && findMobile.status()==true){ 	
				return("queryFindPhone "+ Mnumber + ": " + newExchange.value());
			}
			else if(newExchange!=null && findMobile.status()==false){
				System.out.println("queryFindPhone " + Mnumber + ": " + "Error - Mobile phone with identifier " + Mnumber + " is currently switched off");
			}
			
		}

		else if(message.equals("lowestRouter")){
			Exchange query1 = searchTree(input.nextInt());
			Exchange query2 = searchTree(input.nextInt());

			return("queryLowestRouter " + query1.value() + " " + query2.value() + ": " + lowestRouter(query1,query2).value());
		}

		else if(message.equals("findCallPath")){
			MobilePhone callM1 = root.residentSet().searchMobile(input.nextInt());
			MobilePhone callM2 = root.residentSet().searchMobile(input.nextInt());

			if(callM1.status()==true && callM2.status()==true){
				Exchangelist routeList = routeCall(callM1,callM2);
				String  routePath = "";
				Node routeBTS = routeList.list.head;
				int count = 0;

				while(routeBTS!=null){
					if(count<(routeList.list.size()-1)){
							routePath += routeBTS.value.strCaste() + ", ";
					}	
					else{				
						routePath += routeBTS.value.strCaste();
					}
					count++;
					routeBTS = routeBTS.next;
				}
				System.out.println("queryFindCallPath " + callM1.num() + " " + callM2.num() + ":" + " " + routePath);
				return ("queryFindCallPath " + callM1.num() + " " + callM2.num() + ":" + " " + routePath);

			}
			else if(callM1.status()==false){
System.out.println("queryFindCallPath " + callM1.num() + " " + callM2.num() + ":" + " Error - Mobile phone with identifier " + callM1.num() + " is currently switched off");
				// throw new NullPointerException("queryFindCallPath " + callM1.num() + " " + callM2.num() + ":" + " Error - Mobile phone with identifier " + callM1.num() + " is currently switched off");
			}

			else if(callM2.status()==false){
System.out.println("queryFindCallPath " + callM1.num() + " " + callM2.num() + ":" + " Error - Mobile phone with identifier " + callM2.num() + " is currently switched off");

					//throw new NullPointerException	("queryFindCallPath " + callM1.num() + " " + callM2.num() + ":" + " Error - Mobile phone with identifier " + callM2.num() + " is currently switched off");
			}
			return("");
		}

		else if(message.equals("movePhone")){
			MobilePhone mobile6 = new MobilePhone(input.nextInt());
			Exchange exc6b = searchTree(input.nextInt());

			if(exc6b == null){
				return("error-Exchange does not exist");
			}
			else{
				movePhone(mobile6,exc6b);
			}
		}
		else{
			return("Wrong input-try again");
			//System.exit(0);
		}
	return null;
	}
}





	





