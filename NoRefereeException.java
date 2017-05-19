/**
 * 
 */
package assignment2;

/**
 * @author aditya
 *
 */
public class NoRefereeException extends Exception{
	public NoRefereeException(String errMsg){
		super(errMsg);
		 System.out.println("Game has no number of Referee."
		 		+ "Game should have atleast one Referee."); 
		 System.out.println("Error message is: " + errMsg);
	}

}
