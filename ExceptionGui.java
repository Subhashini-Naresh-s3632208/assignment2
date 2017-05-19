package assignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExceptionGui {
	public String err;
	Ozlympic oz=new Ozlympic();
	
	public void DisplayException(String err){
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		VBox vb1=new VBox();
		Button ok=new Button("Close");
		ok.setOnAction(e->window.close());
		ok.setTranslateX(125);
		ok.setTranslateY(20);
		Label error=new Label(err);
		error.setTranslateX(30);
		vb1.getChildren().addAll(error,ok);
		
		Scene Errordisplay=new Scene(vb1,300,100);
		Errordisplay.setRoot(vb1);
		
		System.out.println(err);
		window.setTitle("Warning!!");
		window.setScene(Errordisplay);
		window.showAndWait();
	}
}
