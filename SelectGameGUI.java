package assignment2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class SelectGameGUI {
	ScrollBar sb=new ScrollBar();
	
	Scene scene2,scene3,ref;
	Game game=null;
	boolean box[]=null;
	public Game select(){
		Group root=new Group();
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Driver3632208 driver=new Driver3632208();
		ExceptionGui ex=new ExceptionGui();
		
		Label label4=new Label("Select the athletes for ur game ");
		VBox layout3= new VBox();
		layout3.getChildren().addAll(label4);
	 
		Label label3=new Label("\nChoose one of the options\n");
		
		Hyperlink swimming = new Hyperlink();
		swimming.setText("\n1)Swimming\n");

		swimming.setOnAction(e ->{
			
			
				try {
					game=driver.selectAGame("SW");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					ex.err=e2.getMessage();
					ex.DisplayException(ex.err);
				}
			
			game.checkedList=new CheckBox[game.listOfAthletes.length];
			box=new boolean[game.listOfAthletes.length];
			for(int i=0;i<game.listOfAthletes.length;i++)
			{
				int k=i;
				game.checkedList[i]=new CheckBox((i+1)+") "+game.listOfAthletes[i].role +" "+game.listOfAthletes[i].name+" "+ game.listOfAthletes[i].athleteId);
				game.checkedList[i].setTranslateX(40);
				game.checkedList[i].setTranslateY(i*10);
				game.checkedList[i].selectedProperty().addListener((obs, wasSelected, isSelected)->box[k]=isSelected);
				game.checkedList[i].setOnAction(e1->{
					if(game.checkedList[k].isSelected())
					{
						
						if(!(game.listOfAthletes[k].role.matches("(swimmer|super)")))
						{
							try
							{
								String msg="Wrong Type of athlete chosen ";
								String role="swimmer";
								game.checkedList[k].setSelected(false);
								throw new WrongTypeException(msg,game.listOfAthletes[k].role,role);
							}
							catch(WrongTypeException exception)
							{
								if(game==null)
									ex.err="NO ATHLETES CHOSEN";
								else
									ex.err=exception.getMessage();
								ex.DisplayException(ex.err);
								
								
							}
							game.checkedList[k].setSelected(false);
							box[k]=false;
						}
						else
						{
							box[k]=true;
						}
			}
				});
				layout3.getChildren().add(game.checkedList[i]);
			}
			try{
					int countSelected=0;
					for(int i=0;i<box.length;i++){
						if(box[i]==true)
							countSelected++;
					}
					if(countSelected>8){
						throw new GameFullExceptions("YOU HAVE CHOSEN MORE THAN EIGHT PARTICIPANTS."
								+ "\nNO MORE THAN 8 PARTICIPANTS ALLOWED");
					}
					
				}		
				catch (Exception exception){
					if(game==null)
						ex.err="NO ATHLETES CHOSEN";
					else
						ex.err=exception.getMessage();
					ex.DisplayException(ex.err);
				}
			window.setScene(scene3);
								
		
		});

		Hyperlink cycling = new Hyperlink();
		cycling.setText("\n2)Cycling\n");

		cycling.setOnAction(e ->{
			
			
			try {
				game=driver.selectAGame("CY");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				ex.err=e2.getMessage();
				ex.DisplayException(ex.err);
			}
			game.checkedList=new CheckBox[game.listOfAthletes.length];
			box=new boolean[game.listOfAthletes.length];
			for(int i=0;i<game.listOfAthletes.length;i++)
			{
				int k=i;
				game.checkedList[i]=new CheckBox((i+1)+") "+game.listOfAthletes[i].role +" "+game.listOfAthletes[i].name+" "+ game.listOfAthletes[i].athleteId);
				game.checkedList[i].setTranslateX(40);
				game.checkedList[i].setTranslateY(i*10);
				game.checkedList[i].selectedProperty().addListener((obs, wasSelected, isSelected)->box[k]=isSelected);
				game.checkedList[i].setOnAction(e1->{
					if(game.checkedList[k].isSelected())
					{
						
								if(!(game.listOfAthletes[k].role.matches("(cyclist|super)")))
								{
									try
									{
										String msg="Wrong Type of athlete chosen ";
										String role="cyclist";
										game.checkedList[k].setSelected(false);
										throw new WrongTypeException(msg,game.listOfAthletes[k].role,role);
									}
									catch(WrongTypeException exception)
									{
										if(game==null)
											ex.err="NO GAME CHOSEN";
										else
											ex.err=exception.getMessage();
										ex.DisplayException(ex.err);
										
										
									}
									game.checkedList[k].setSelected(false);
									box[k]=false;
								}
								else
								{
									box[k]=true;
								}
					}
				});
				layout3.getChildren().add(game.checkedList[i]);
			}
					
			window.setScene(scene3);
		});
	
		Hyperlink running = new Hyperlink();
		running.setText("\n3)Running\n");

		running.setOnAction(e ->{
			
			
			try {
				game=driver.selectAGame("RU");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				ex.err=e2.getMessage();
				ex.DisplayException(ex.err);
			}
			
			box=new boolean[game.listOfAthletes.length];
		
			for(int i=0;i<game.listOfAthletes.length;i++)
			{
				int k=i;
				game.checkedList[i]=new CheckBox((i+1)+") "+game.listOfAthletes[i].role +" "+game.listOfAthletes[i].name+" "+ game.listOfAthletes[i].athleteId);
				//game.checkedList[i].selectedProperty().addListener((obs, wasSelected, isSelected)->game.checkedList[k].setSelected(isSelected));
				game.checkedList[i].setTranslateX(40);
				game.checkedList[i].setTranslateY(i*10);
				game.checkedList[i].selectedProperty().addListener((obs, wasSelected, isSelected)->box[k]=isSelected);
				game.checkedList[i].setOnAction(e1->{
					if(game.checkedList[k].isSelected())
					{
						
						if(!(game.listOfAthletes[k].role.matches("(sprinter|super)")))
						{
							try
							{
								String msg="Wrong Type of athlete chosen ";
								String role="sprinter";
								game.checkedList[k].setSelected(false);
								throw new WrongTypeException(msg,game.listOfAthletes[k].role,role);
							}
							catch(WrongTypeException exception)
							{
								if(game==null)
									ex.err="NO ATHLETES CHOSEN";
								else
									ex.err=exception.getMessage();
								ex.DisplayException(ex.err);
								
							}
							game.checkedList[k].setSelected(false);
							box[k]=false;
						}
						else
						{
							box[k]=true;
						}
			}
				});
				layout3.getChildren().add(game.checkedList[i]);
			}
			try{
			int countSelected=0;
			for(int i=0;i<box.length;i++){
				if(box[i]==true)
					countSelected++;
			}
			if(countSelected>8){
				throw new GameFullExceptions("YOU HAVE CHOSEN MORE THAN EIGHT PARTICIPANTS."
						+ "\nNO MORE THAN 8 PARTICIPANTS ALLOWED");
				
			}
			}		
			catch (Exception exception){
				if(game==null)
					ex.err="NO ATHLETES CHOSEN";
				else
					ex.err=exception.getMessage();
				ex.DisplayException(ex.err);
				
			}
			window.setScene(scene3);
		});
		
		
		VBox layout2= new VBox();
				
		
		VBox layout4=new VBox();
		Button selected=new Button("Select");
		layout3.getChildren().add(selected);
		selected.setOnAction(e -> {
			ToggleGroup group = new ToggleGroup();
		try{				
					int countSelected=0;
					for(int i=0;i<box.length;i++){
						if(box[i]==true)
							countSelected++;
					}				
					if(countSelected>8)
						throw new GameFullExceptions("YOU HAVE CHOSEN MORE THAN EIGHT PARTICIPANTS."
								+ "\nNO MORE THAN 8 PARTICIPANTS ALLOWED");
					else if(countSelected<=8 && countSelected>=4)
					game=driver.chosenAthletes(box, game);
					else
						throw new TooFewAthleteException("MINIMUM NUMBER OF ATHLETES CHOSEN SHOULD BE 4", countSelected);
				
				game=driver.chooseOfficer(game);
				game.radioButtons=new RadioButton[game.listOfOfficial.length];
				
				for(int k=0;k<game.listOfOfficial.length;k++){
					int l=k;
					game.radioButtons[k]=new RadioButton((k+1)+") "+game.listOfOfficial[k].role +" "+game.listOfOfficial[k].name+" "+ game.listOfOfficial[k].officialId);
					layout4.getChildren().add(game.radioButtons[k]);
					
					 game.radioButtons[l].selectedProperty().addListener((obs, wasSelected, isSelected)->game.radioButtons[l].setSelected(isSelected));
					 game.radioButtons[l].setToggleGroup(group);
				}
				
		} 
			catch (TooFewAthleteException e1) 
			{
				if(game==null)
					ex.err="NO GAME CHOSEN";
				else
					ex.err=e1.getMessage();
				ex.DisplayException(ex.err);
			}
			catch(Exception exception)
			{
				if(game==null)
					ex.err="NO ATHLETES CHOSEN";
				else
					ex.err=exception.getMessage();
				ex.DisplayException(ex.err);
			}
	try{		
		if(game.participants[0]==null){
			throw new Exception("No Athletes chosen !");
		}
		else{
			window.setScene(ref);
		}
			}
		catch(Exception exception){
			if(game==null)
				ex.err="NO ATHLETES CHOSEN";
			else
				ex.err=exception.getMessage();
			ex.DisplayException(ex.err);
			window.setScene(scene3);
		}
		
		});
		
		Button back2=new Button("Back To menu");	
		layout4.getChildren().add(back2);
		back2.setOnAction(e ->{
			try{
			for(int i=0;i<game.radioButtons.length;i++){
				if(game.radioButtons[i].isSelected())
					game.chosenOfficer=game.listOfOfficial[i];
			}
			
			if(game.chosenOfficer==null){
				
				throw new NoRefereeException("NO REFEREE CHOSEN");
			}
			
			
			VBox vb1=new VBox();
			System.out.println("Participants of "+game.gameId+" are:");
			for(int i=0;i<game.participants.length;i++){
				System.out.println((i+1)+")"+game.participants[i].athleteId+" "+game.participants[i].name);
			Label athletes=new Label((i+1)+")"+game.participants[i].athleteId+" "+game.participants[i].name);
			vb1.getChildren().add(athletes);
			}if(game.chosenOfficer!=null){
			
			Label referee=new Label("THE refree chosen for the game is:");
			Label refDetails=new Label("ID: "+game.chosenOfficer.officialId+" Name: "+game.chosenOfficer.name);
			vb1.getChildren().addAll(referee,refDetails);
			}
			Button ok=new Button("Close");
			vb1.getChildren().addAll(ok);
			ok.setOnAction(eOk->{
			window.close();
			});
			
			Scene athletesChosen=new Scene(vb1,300,300);
			
			window.setScene(athletesChosen);
		}
			catch(Exception exception){
				ex.err=exception.getMessage();
				ex.DisplayException(ex.err);
				window.setScene(ref);
			}
		});
		
			root.getChildren().addAll(layout3,sb);
			
	       
			ref=new Scene(layout4,400,400);
			scene3=new Scene(root,400,400); 
			sb.setMinHeight(180);
			sb.setLayoutX(scene3.getWidth()-sb.getWidth());
	        sb.setMin(0);
	        sb.setOrientation(Orientation.VERTICAL);
	        sb.setPrefHeight(scene3.getHeight());
	        sb.setMax(1000);
	        sb.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	                    layout3.setLayoutY(-new_val.doubleValue());
	            }});
			Button back=new Button("Back to Menu");	
			back.setLayoutX(200);
			back.setLayoutY(150);
			
			back.setOnAction(e ->{
				
				window.close();
			});	
			layout2.getChildren().addAll(label3,swimming,cycling,running,back);
			scene2=new Scene(layout2,400,400);
			
			window.setScene(scene2);
			window.showAndWait();
			
			return game;
	}
}
