/**
* @author Julien PROUDY
* @version 0.1 : Date : Fri Jan 15 10:03:18 CET 2021
*
*/
public class InvalidDateException extends Exception {
	
	public InvalidDateException(){
		super();
	}
	
	public InvalidDateException(String s){
		super(s);
	}
}