import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;

public class ShoppingCartPage extends Application{
	private Song[] songsList = {	new Song("Whispers", "Passenger", 5.0D),
									new Song("Wolves Without Teeth", "Of Monsters And Men", 6.5D),
									new Song("Shiver", "Coldplay", 4.5D),
									new Song("Death & All Of His Friends", "Coldplay", 5.0D),
									new Song("Dirty Paws", "Of Monsters And Men", 7D)};
	
	//Payment
	private TextField tfName;
	private TextField tfEmail;
	private ComboBox tfPayment;
	private Button bCalc;
	private Button bExit;
	private Label lFinalPrice;
	
	//Songs
	private ListView songs;
	private Label lSongsChosen;
	
	
	public void start(Stage myStage) {
		
		//Setup layout
		GridPane rootNode = new GridPane();
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		rootNode.setPadding(new Insets(30));
		
		//Components
		
		
		
		//Setup scene & stage
		Scene myScene = new Scene(rootNode, 1280, 720);
		myStage.setTitle("Shopping cart checkout page");
		myStage.setScene(myScene);
		myStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
