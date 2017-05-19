package assignment2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class DisplayResultsGUI {
public static void displayResults(Game[] games,int count) throws Exception{
	
	ScrollBar sb=new ScrollBar();
	Group root=new Group();
	
	String[] titles=new String[3];
	
	titles[0]="First";
	titles[1]="Second";
	titles[2]="Third";
	VBox vb1=new VBox();
	Stage window=new Stage();
	
	for(int i=0;i<count;i++){
		if(games[i]!=null)
		if(games[i].winners==null){
			Label athletes=new Label("\nThe game "+games[i].gameId+" was aborted due to various reasons!\n");
			vb1.getChildren().add(athletes);
		}
		else{
			Label athletes=new Label("\nWinners Of Game-"+games[i].gameId+" are:\n========================================================\nTITLE\t\tATLHLETE\tID\tAGE\tPOINTS\tSTATE");
			vb1.getChildren().add(athletes);
			for(int j=0;j<games[i].winners.length;j++){
	    		Label winner=new Label(titles[j]+"\t\t"+games[i].winners[j].name+"\t\t"+games[i].winners[j].athleteId+"\t"+games[i].winners[j].role+"\t"+games[i].winners[j].points+"\t"+games[i].winners[j].state+"\n");
	    		vb1.getChildren().add(winner);
			}
		}
		else {
			Label athletes=new Label("\nThe game was not run!\n");
			vb1.getChildren().add(athletes);
	}
	}
	/*else if(games[0]!=null && games[0].winners==null){
		System.out.println("here");
		Label athletes=new Label("\nThe game "+games[0].gameId+" was aborted due to various reasons!\n");
		vb1.getChildren().add(athletes);
	}
	
	else{*/
		/*if(games[0]==null)
			throw new Exception("NO GAMES HAVE RUN YET!");*
	/*}*/
	
	Button ok=new Button("Close");
	ok.setOnAction(eOk->{
	window.close();
	});
	vb1.getChildren().add(ok);
	root.getChildren().addAll(vb1,sb);
	Scene athletesChosen=new Scene(root,500,500);
	
	sb.setMinHeight(500);
	sb.setLayoutX(athletesChosen.getWidth()-sb.getWidth());
    sb.setMin(0);
    sb.setOrientation(Orientation.VERTICAL);
    sb.setPrefHeight(180);
    sb.setMax(800);
    sb.valueProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) {
                vb1.setLayoutY(-new_val.doubleValue());
        }});
	
	window.setScene(athletesChosen);
	
	window.showAndWait();
		}
	 
}

