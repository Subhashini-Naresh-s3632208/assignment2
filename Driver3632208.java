package assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

//Written by Subhashini Naresh
//Student ID: s3632208

import java.util.Date;
import java.util.Scanner;

import javafx.scene.control.CheckBox;

class Driver3632208
{
		//Written by Subhashini Naresh
		//Student ID: s3632208
	
	int countFull=0;

		public Game selectAGame(String choose) throws Exception
		
		{ 
		    Game game=new Game();
		    game=game.createGameId(game, choose);
			
			game=game.chooseAthletes(game);
			
			return game;
		}
		
		public Game chosenAthletes(boolean[] checkedList,Game game) throws GameFullExceptions,TooFewAthleteException
		{
			try{
				Athlete[] participants1=new Athlete[checkedList.length];
				countFull=0;
				
				for(int i=0;i<checkedList.length;i++)
				{
					
					if(countFull>8)
						{
							throw new GameFullExceptions("YOU HAVE CHOSEN MORE THAN EIGHT PARTICIPANTS."
									+ "\nNO MORE THAN 8 PARTICIPANTS ALLOWED");
						}
					
				
					if(checkedList[i] && game.gameId.startsWith("S") && (game.listOfAthletes[i].role.matches("swimmer") || game.listOfAthletes[i].role.matches("super")))
							{
								participants1[countFull]=game.listOfAthletes[i];
								countFull++;
							}
					if(checkedList[i] && game.gameId.startsWith("C") && (game.listOfAthletes[i].role.matches("cyclist") || game.listOfAthletes[i].role.matches("super")))
					{
						participants1[countFull]=game.listOfAthletes[i];
						countFull++;
					}
					if(checkedList[i] && game.gameId.startsWith("R") && (game.listOfAthletes[i].role.matches("sprinter") || game.listOfAthletes[i].role.matches("super")))
					{
						participants1[countFull]=game.listOfAthletes[i];
						countFull++;
					}
				}
				if(countFull<4)
				{
					throw new TooFewAthleteException("LESS THAN 4 PARTICIPANTS CHOSEN\nPLEASE CHOOSE MINIMUM OF 4 ATHLETES.", 4);
				}
				game.participants=new Athlete[countFull];
				for(int i=0;i<countFull;i++)
				{
					game.participants[i]=participants1[i];
				}
			}
			catch(TooFewAthleteException e)
			{
				throw e;
			}
			catch(GameFullExceptions e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return game;
		}

		public Game chooseOfficer(Game game){
			game=game.cooseOfficer(game);
			return game;
		}
		
		
		public Game startGame(Game game) throws Exception
		{	Game newGame=new Game();
			try{
				if(game.participants==null){
			throw new Exception("No Athletes CHOSEN");
			}
			if(game.winners!=null){
			if(game.gameId.startsWith("S")){
				newGame=newGame.createGameId(newGame, "SW");
			}
			else if(game.gameId.startsWith("C"))
				newGame=newGame.createGameId(newGame, "CY");
			else
				newGame=newGame.createGameId(newGame, "RU");
			newGame.chosenOfficer=game.chosenOfficer;
			newGame.participants=game.participants;
			game=newGame;
			}
			
			int minTime1=999,minTime2=999,minTime3=999;
			int firstWinner=0,secondWinner=0,thirdWinner=0;
			game.winners=new Athlete[3];
			for(int i=0;i<game.participants.length;i++)
			{
				game.participants[i].compete(game.gameId);
			}
			game.timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			
		
			for(int i=0;i<game.participants.length;i++)
			{
				if(game.participants[i].time<minTime1)
				{
					minTime1=game.participants[i].time;
					firstWinner=i;	
					
				}
				
			}
			game.participants[firstWinner].points+=5;
			game.winners[0]=new Athlete();
			game.winners[0].athleteId=game.participants[firstWinner].athleteId;
			game.winners[0].name=game.participants[firstWinner].name;
			game.winners[0].role=game.participants[firstWinner].role;
			game.winners[0].age=game.participants[firstWinner].age;
			game.winners[0].state=game.participants[firstWinner].state;
			
			for(int i=0;i<game.participants.length;i++)
			{
				if(minTime1 <=game.participants[i].time && !(game.participants[i].athleteId.equals(game.participants[firstWinner].athleteId)) && game.participants[i].time<minTime2)
				{
					minTime2=game.participants[i].time;
					secondWinner=i;
					
				}
				
			}
			
			game.participants[secondWinner].points+=2;
			game.winners[1]=new Athlete();
			game.winners[1].athleteId=game.participants[secondWinner].athleteId;
			game.winners[1].name=game.participants[secondWinner].name;
			game.winners[1].role=game.participants[secondWinner].role;
			game.winners[1].age=game.participants[secondWinner].age;
			game.winners[1].state=game.participants[secondWinner].state;
			
			for(int i=0;i<game.participants.length;i++)
			{
				if(game.participants[i].time>minTime2 && !(game.participants[i].athleteId.equals(game.participants[secondWinner].athleteId)) && game.participants[i].time<minTime3)
				{	minTime3=game.participants[i].time;
					thirdWinner=i;
					
				}
			}
			
			game.participants[thirdWinner].points+=1;
			game.winners[2]=new Athlete();
			game.winners[2].athleteId=game.participants[thirdWinner].athleteId;
			game.winners[2].name=game.participants[thirdWinner].name;
			game.winners[2].role=game.participants[thirdWinner].role;
			game.winners[2].age=game.participants[thirdWinner].age;
			game.winners[2].state=game.participants[thirdWinner].state;
			
			game.winners[0].points=5;
			game.winners[2].points=1;
			game.winners[1].points=2;
			game.winners[0].time=game.participants[firstWinner].time;
			game.winners[1].time=game.participants[secondWinner].time;
			game.winners[2].time=game.participants[thirdWinner].time;
			System.out.println("Game "+game.gameId+" has been successfully completed");
			System.out.println("The winners are: \n");
			System.out.println("\n==========================================================================");
			try(FileWriter br=new FileWriter( "src/assignment2/gameResults.txt", true))
			{
				
				String main=game.gameId+", "+game.chosenOfficer.officialId+", "+game.timeStamp+"\n";
				br.write(main);
			
				for(int j=0;j<game.winners.length;j++){
					br.write(game.winners[j].athleteId+", "+game.winners[j].time+", "+game.winners[j].points+"\n");
	        		System.out.println((j+1)+")\t\t"+game.winners[j].name+"\t\t"+game.winners[j].time+"\t\t"+game.winners[j].athleteId+"\t"+game.winners[j].role+"\t"+game.winners[j].points+"\t"+game.winners[j].state+"\n");
				}
				for(int j=0;j<game.participants.length;j++){
					if(!(j==firstWinner || j==secondWinner || j==thirdWinner))
					br.write(game.participants[j].athleteId+", "+game.participants[j].time+", "+0+"\n");
				}
				
				br.flush();
			}
			catch(FileNotFoundException e){
				System.err.println("File not found");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			catch(IOException e){
				System.err.println("File cannot be created, or cannot be opened");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			catch(Exception exception){
				if(game.chosenOfficer==null)
					throw new NoRefereeException("REFEREE NOT CHOSEN FOR GIVEN GAME");
				else
					throw exception;
			}
			}
			catch(Exception ex){
				throw ex;
			}
			return game;
		}
		
		public void displayResults(Game[] games,int count) throws Exception
		{
			String[] titles=new String[3];
			titles[0]="First";
			titles[1]="Second";
			titles[2]="Third";
			
			
			for(int i=0;i<count;i++){
				if(games[i]!=null)
				if(games[i].winners==null)
					System.out.println("\nThe game "+games[i].gameId+" was aborted due to various reasons!\n");
				else
				{
					//print soooooooooooon!!!!!!!!!!!!!
					
					//System.out.println("\nResults of the Game "+games[i].gameId+" with Referee "+games[i].referee.name+","+games[i].referee.age+" ID: "+games[i].referee.officialId+" from "+games[i].referee.state);
					System.out.println("\nWinners Of Game-"+games[i].gameId+" are:\n========================================================================\nTITLE\t\tATLHLETE\tID\tAGE\tPOINTS\tSTATE");
					for(int j=0;j<games[i].winners.length;j++)
	        		System.out.println(titles[j]+"\t\t"+games[i].winners[j].name+"\t\t"+games[i].winners[j].athleteId+"\t"+games[i].winners[j].role+"\t"+games[i].winners[j].points+"\t"+games[i].winners[j].state+"\n");
					
				}
			} 
		}
		public void displayPoints() throws Exception
		{
			System.out.println("\nPoints of all Athletes are displayed as below:\n");
			System.out.println("\nID      ATHLETE NAME\t\tPOINTS\n");
			if(AthleteDetails.chosenAthletes==null)
				AthleteDetails.chooseAthletes();
			for(int i=0;i<32;i++){
				if(!(AthleteDetails.chosenAthletes[i].role.matches("officer")))
					System.out.println(AthleteDetails.chosenAthletes[i].athleteId+"\t  "+AthleteDetails.chosenAthletes[i].name+"   \t\t"+AthleteDetails.chosenAthletes[i].points);
		
			}}}