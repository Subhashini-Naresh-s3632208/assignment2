package assignment2;



import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class Game implements java.io.Serializable
{
	//Written by Aditya Vijayakumar
		//Student ID: s3632205

		public String timeStamp;
		public String gameId;
		public RadioButton[] radioButtons=null;
		public Athlete[] participants=new Athlete[8];
		public Athlete[] listOfAthletes=null;
		public Official[] listOfOfficial=null;
		public Official chosenOfficer=null;
		public CheckBox[] checkedList=null;
		public Athlete[] winners=null;
		public static int count=00;
		
		public Game chooseAthletes(Game game) throws Exception{
			
			this.listOfAthletes=AthleteDetails.chooseAthletes();
			this.checkedList=new CheckBox[this.listOfAthletes.length];
			
			return game;
		}
		public Game createGameId(Game game,String option)
		{
			count++;
		    if(option.equals("SW")){
				game.gameId="S"+count;
				
			}
			else if(option.equals("CY"))
			{
				game.gameId="C"+count;
				
			}
			else {
				game.gameId="R"+count;
				
			}
		    return game;
		}
		public Game cooseOfficer(Game game){
			game.listOfOfficial=Official.chooseReferee(game);
			game.checkedList=new CheckBox[game.listOfOfficial.length];
			return game;
		}
	}


