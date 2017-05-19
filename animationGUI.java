package assignment2;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class animationGUI{
	public static void displayGame(Game game) {
		Stage window=new Stage();
		Pane pane = new Pane();
		
		// Create a rectangle
		window.initModality(Modality.APPLICATION_MODAL);

		
		Image[] runImages= new Image[8];
		Image[] swimImages= new Image[8];
		Image[] images=null;
		runImages[0]=new Image("images/1.gif",35,35,true,true);
		runImages[1]=new Image("images/2.gif",35,35,true,true);
		runImages[2]=new Image("images/3.gif",35,35,true,true);
		runImages[3]=new Image("images/4.gif",35,35,true,true);
		runImages[4]=new Image("images/5.gif",35,35,true,true);
		runImages[5]=new Image("images/6.gif",35,35,true,true);
		runImages[6]=new Image("images/7.gif",35,35,true,true);
		runImages[7]=new Image("images/8.gif",35,35,true,true);
		
		swimImages[0]=new Image("swimImages/1.gif",75,75,true,true);
		swimImages[1]=new Image("swimImages/2.gif",55,75,true,true);
		swimImages[2]=new Image("swimImages/3.gif",75,75,true,true);
		swimImages[3]=new Image("swimImages/4.gif",75,75,true,true);
		swimImages[4]=new Image("swimImages/5.gif",75,75,true,true);
		swimImages[5]=new Image("swimImages/6.gif",75,75,true,true);
		swimImages[6]=new Image("swimImages/7.gif",55,75,true,true);
		swimImages[7]=new Image("swimImages/8.gif",55,75,true,true);
		Scene scene = new Scene(pane, 600, 600);
		if(game.gameId.startsWith("R")){
			images=runImages;
		}
		if(game.gameId.startsWith("S")){
			images=swimImages;
		}
		else
			images=runImages;
		ImageView[] ivs=new ImageView[8];
		for(int i=0;i<8;i++)
		{
			ivs[i]=new ImageView(images[i]);
			ivs[i].setTranslateX(0);
			ivs[i].setTranslateY(0);		
		} 
		Circle circle[] = new Circle[game.participants.length];
		
		PathTransition[] pt = new PathTransition[game.participants.length];
		for(int i=0;i<game.participants.length;i++)
		{
			pane.getChildren().add(ivs[i]);
		       
			int k=i+1;
			pt[i]=new PathTransition();
			
			
			circle[i] = new Circle(200, 200,35*k+2);
			circle[i].setFill(null);
			circle[i].setStroke(Color.BLACK);
			// Add circle and rectangle to the pane
			pane.getChildren().add(circle[i]);
			circle[i].setTranslateX(90);
			circle[i].setTranslateY(80);
			 
			if(game.gameId.startsWith("R"))
				pt[i].setDuration(Duration.millis(game.participants[i].time*500));
			else
				pt[i].setDuration(Duration.millis(game.participants[i].time*50));
			pt[i].setPath(circle[i]);
			pt[i].setNode(ivs[i]);
		
			pt[i].setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt[i].setCycleCount(1);
			pt[i].setAutoReverse(false);
			// Start animation
			pt[i].play();
		
	}	
		
		window.setTitle("PathTransitionDemo");
		window.setScene(scene);
		window.show();
	}
	
}
