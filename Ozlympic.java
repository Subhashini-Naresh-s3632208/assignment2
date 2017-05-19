package assignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ozlympic extends Application
{
	Stage window;
	Scene scene1,scene2,scene3,ref;
	Game game=null;
	public static int count=0;
	Game[] games=new Game[15];
	
	boolean[] box=null;
	public void start(Stage primaryStage)
	{
		
			try{
					Driver3632208 driver=new Driver3632208();
					window= primaryStage;
					ExceptionGui ex=new ExceptionGui();
					
					SelectGameGUI selectGui=new SelectGameGUI();
					Label label1=new Label("Welcome to Ozlympic Sports!");
					Label label2= new Label("\nPlease choose the options 1-6 from the menu below:"); 
					// \n1)Select a game to run\n2)Predict the winner of the game\n3)Start the game\n4)Display the final result of all games\n5)Display the points of all Athletes\n6)Exit\n
					Hyperlink selectGame = new Hyperlink();
					selectGame.setText("\n1)Select a game to run\n");
					selectGame.setOnAction(e ->{
						try{
							
							game=selectGui.select();
							if(game!=null)
							games[count]=game;
							count++;
							
						}
						catch(Exception ex1)
						{
							if(game.participants!= null && game.chosenOfficer==null)
								ex.err="NO REFEREE CHOSEN FOR THE GAME ";
							else if(game==null)
								ex.err="NO GAME CHOSEN";
							else
								ex.err=ex1.getMessage();
							ex.DisplayException(ex.err);
						}
					    });					
					
					Hyperlink startGame = new Hyperlink();
					startGame.setText("2)Start the game\n");
					startGame.setOnAction(e ->{
					   try{
							if( game.participants[0]==null){
								
								throw new Exception("NO ATHLETES CHOSEN");
							}
							game =driver.startGame(game);
							animationGUI.displayGame(game);
							int prevGame=count-1;
							if(!((games[prevGame].gameId).matches(game.gameId)))
							{
									games[count]=game;
									count++;
							}
							
							primaryStage.show();
						}
						catch(Exception exception){
							if(game!= null && game.participants[0]==null)
							{
								ex.err="NO ATHLETES CHOSEN\nTHIS GAME CANNOT RUN.\nPlease Select a game again!";
								ex.DisplayException(ex.err);
							}
							else if(game==null){
								ex.err="NO GAME CHOSEN";
							ex.DisplayException(ex.err);
							}
							
							else if(game!=null && game.chosenOfficer==null)
							{
								ex.err="NO REFEREE CHOSEN";
								ex.DisplayException(ex.err);
								SelectRefereeGUI srf=new SelectRefereeGUI();
								game=srf.ChooseReferee(game);
							}
							else{
								ex.err=exception.getMessage();
								ex.DisplayException(ex.err);
							}
							
						}
					});	
					Hyperlink displayResult = new Hyperlink();
					displayResult.setText("3)Display the results\n");
					displayResult.setOnAction(e ->{
						try{
							DisplayResultsGUI.displayResults(games, count);
							driver.displayResults(games, count);
						}
						catch(Exception exception){
								ex.err=exception.getMessage();
							ex.DisplayException(ex.err);
							
							
							}
					    });	
					Hyperlink displayPoints = new Hyperlink();
					displayPoints.setText("4)Display the points\n");
					displayPoints.setOnAction(e ->{
						
					try{
						driver.displayPoints();
						DisplayPointsGUI.displayPoints();
						
					}
					catch(Exception exception){
						if(game==null)
							ex.err="NO GAME CHOSEN";
						else
							ex.err=exception.getMessage();
						ex.DisplayException(ex.err);	
						}
					    });	
					Hyperlink exitGame = new Hyperlink();
					exitGame.setText("5)Exit the game\n");
					exitGame.setOnAction(e ->{
						
						System.exit(0);
						
					    });
				
			
			VBox pane=new VBox();
			pane.getChildren().addAll(label1,label2,selectGame,startGame,displayResult,displayPoints,exitGame);
			Scene scene1 = new Scene(pane,500,500);
			
			primaryStage.setTitle("Ozlympic Sports");
			primaryStage.setScene(scene1);
			primaryStage.show();
			
		 
			}
			catch(Exception e){
				
				System.out.println(e.getMessage());
			}		
	}
	public static void main(String[] args) {
	     
			Application.launch(args);
	    }
}

