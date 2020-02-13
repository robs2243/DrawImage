/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rd
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

	// Hier legen wir einen Button an
	//Button button;
        ImageView img;
        Image bild;

	@Override
	public void start(Stage primaryStage) {
		try {
			// 1. STAGE
			// Damit setzen wir den Titel unseres Fensters
			primaryStage.setTitle("Unser erstes Fenster");

			// Wir verwenden einen StackPane, dabei handelt es sich um eine Layoutklasse,
			// welche die Eigenschaften
			// und Funktionalität des Layouts bestimmen
			StackPane root = new StackPane();

			// 2.SCENE
			// Wir legen unsere Scene an, welche innerhalb des StackPanes root ist
			// und eine Größe von 400 * 400 Pixel hat
			Scene scene = new Scene(root,400,400);

			// 3. NODE
			// Initialisieren des Buttons und setzen des Textes der auf dem Button auftaucht
			//button = new Button();
			//button.setText("Klick mich");
                        img = new ImageView();
                        bild = new Image("lou2.png");
                        img.setOnMouseDragged(event -> {
                        double x=event.getX();
                        double y=event.getY();
                        WritableImage wi=new WritableImage(bild.getPixelReader(),(int)bild.getWidth(),(int)bild.getHeight());
                        PixelWriter pw=wi.getPixelWriter();
                        pw.setColor((int)x,(int)y,new Color(0,0,0,1));
                        bild=wi;
                        img.setImage(bild);
                        
                    });

			// Fügen den Button zu unserem StackPane (Fenster) hinzu
			root.getChildren().add(img);

			// nun Setzen wir die Scene zu unserem Stage und zeigen ihn an
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// In der Main Methode rufen wir launch auf, welches unser Fenster startet
		launch(args);
	}
}