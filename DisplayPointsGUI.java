package assignment2;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class DisplayPointsGUI {

	public static void displayPoints() throws Exception{
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		VBox vb1=new VBox();
		ScrollBar sb=new ScrollBar();
		Group root=new Group();
		if(AthleteDetails.chosenAthletes==null)
			AthleteDetails.chooseAthletes();
		
		for(int i=0;i<AthleteDetails.chosenAthletes.length;i++){
			if(!(AthleteDetails.chosenAthletes[i].role.matches("officer")))
			{
				Label athletes=new Label(AthleteDetails.chosenAthletes[i].athleteId+"\t  "+AthleteDetails.chosenAthletes[i].name+"    \t\t"+AthleteDetails.chosenAthletes[i].points);
				vb1.getChildren().add(athletes);
				
			}
		}
			
			
			Button ok=new Button("Close");
			ok.setOnAction(eOk->window.close());
			vb1.getChildren().addAll(ok);
			root.getChildren().addAll(sb,vb1);
			
			Scene athletesChosen=new Scene(root,600,600);
			sb.setMinHeight(400);
			sb.setLayoutX(athletesChosen.getWidth()-sb.getWidth());
	        sb.setMin(0);
	        sb.setOrientation(Orientation.VERTICAL);
	        sb.setPrefHeight(180);
	        sb.setMax(360);
	        sb.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	                    vb1.setLayoutY(-new_val.doubleValue());
	            }});
			window.setScene(athletesChosen);
			window.showAndWait();
		}
	}

