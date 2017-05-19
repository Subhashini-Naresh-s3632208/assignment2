/**
 * 
 */
package assignment2;

/**
 * @author aditya
 *
 */
public class TooFewAthleteException extends Exception{

	public TooFewAthleteException(String errMsg, int numberOfAthletes) 
	{
			  super(errMsg);
		   } 
}
