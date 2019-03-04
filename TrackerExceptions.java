
class IndexOutOfRange extends Exception{
	private String error = "";

	public IndexOutOfRange(){
		super();
	}

	public IndexOutOfRange(String error){
		super(error);
		this.error = error;
	}
}

class ElementDoesNotExist extends Exception{
	private String error = "";

	public ElementDoesNotExist(){
		super();
	}

	public ElementDoesNotExist(String error){
		super(error);
		this.error = error;
	}

}

class AlreadyOn extends Exception{
	private String error = "";

	public AlreadyOn(){
		super();
	}

	public AlreadyOn(String error){
		super(error);
		this.error = error;
	}

}

class AlreadyOff extends Exception{
	private String error = "";

	public AlreadyOff(){
		super();
	}

	public AlreadyOff(String error){
		super(error);
		this.error = error;
	}


}

class PhoneOffException extends Exception{
	private String error = "";

	public PhoneOffException(){
		super();
	}

	public PhoneOffException(String error){
		super(error);
		this.error = error;
	}
}

class AlreadyRegistered extends Exception{
	private String error = "";

	public AlreadyRegistered(){
		super();
	}

	public AlreadyRegistered(String error){
		super(error);
		this.error = error;
	}
}

class MobileDoesNotExist extends Exception{
	private String error = "";

	public MobileDoesNotExist(){
		super();
	}

	public MobileDoesNotExist(String error){
		super(error);
		this.error = error;
	}

}

class ExchangeDoesNotExist extends Exception{
	private String error = "";

	public ExchangeDoesNotExist(){
		super();
	}

	public ExchangeDoesNotExist(String error){
		super(error);
		this.error = error;
	}


}


