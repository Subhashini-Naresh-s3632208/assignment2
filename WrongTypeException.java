/**
 * 
 */
package assignment2;

/**
 * @author aditya
 *
 */

public class WrongTypeException extends Exception {
//Correct the parameters soon
	public WrongTypeException(String errMsg,String type,String a)
	{
		super(errMsg);
		System.out.println("You are trying to assign "+type+" type athlete to a "+a+
				              " type athlete"); 
	    System.out.println("Error: " + errMsg);
	  
	}	
}
