package assignment2;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SelectRefereeGUI {
Game game=null;
	public Game ChooseReferee(Game game){
		this.game=game;
		Driver3632208 driver= new Driver3632208();
		this.game=driver.chooseOfficer(this.game);
		VBox layout4=new VBox();
		ToggleGroup group = new ToggleGroup();
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Scene ref=new Scene(layout4,300,300);
		
		this.game.radioButtons=new RadioButton[this.game.listOfOfficial.length];
		
		for(int k=0;k<this.game.listOfOfficial.length;k++){
			int l=k;
			this.game.radioButtons[k]=new RadioButton((k+1)+") "+this.game.listOfOfficial[k].role +" "+this.game.listOfOfficial[k].name+" "+this.game.listOfOfficial[k].officialId);
			layout4.getChildren().add(this.game.radioButtons[k]);
			
			this.game.radioButtons[l].selectedProperty().addListener((obs, wasSelected, isSelected)->this.game.radioButtons[l].setSelected(isSelected));
			this.game.radioButtons[l].setToggleGroup(group);
		}
		
		Button back3=new Button("Back to menu");
		layout4.getChildren().add(back3);
		back3.setOnAction(e->{
			for(int i=0;i<this.game.radioButtons.length;i++){
				if(this.game.radioButtons[i].isSelected())
					this.game.chosenOfficer=this.game.listOfOfficial[i];
			}
			try{
			if(this.game.chosenOfficer==null){
				throw new Exception("PLEASE PRESS SELECT TO CHOOSE REFEREE");
			}
			else
				window.close();
			}
			catch(Exception ex1){
				ExceptionGui ex=new ExceptionGui();
				ex.err=ex1.getMessage();
				ex.DisplayException(ex.err);
			}
		});
		window.setScene(ref);
		window.showAndWait();
		return this.game;
	}
}
