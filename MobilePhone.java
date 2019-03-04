import java.util.*;
import java.lang.*;

public class MobilePhone{
	private int number;
	private Boolean status;
	private Exchange bts;

	public MobilePhone(int number){
		this.number = number;
		this.status = false;
	}

	public int num(){
		return number;
	}

	public Boolean status(){
		if(status==true){
			return true;
		}
		else 
			return false;
	}

	public void setStatus(Boolean status){
		this.status=status;
	}

	public void switchOn(){
		this.status = true;
	}

	public void switchOff(){
		this.status = false;
	}

	public Exchange location(){
			 return bts;
	}

	public void setBts(Exchange b){
		bts = b;
	}

	public String strCaste(){
		String caste = "";

		if(status==true){
			return (caste + String.valueOf(number));
		}
		else{
			return caste;
		}
	}	
 	
}