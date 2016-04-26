import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.collections.*;

public class ShoppingCartPage extends Application{	
	//Payment
	private TextField tfName;
	private TextField tfEmail;
	private ComboBox<String> tfPayment;
	private Button bCalc;
	private Button bExit;
	private Label lFinalPrice;
	
	//Songs
	private ListView<Song> songs;
	private Label lSongsChosen;
	
	
	public void start(Stage myStage) {
		
		//Setup layout
		GridPane rootNode = new GridPane();
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		rootNode.setPadding(new Insets(30));
		
		//Components 
		tfName = new TextField();
		tfEmail = new TextField();
		ObservableList<String> paymentChoices = FXCollections.observableArrayList("Visa", "MasterCard", "Amex");
		tfPayment = new ComboBox<String>(paymentChoices);
		tfPayment.setValue("Visa");
		bCalc = new Button("Calculate");
		bExit = new Button("Exit");
		lFinalPrice = new Label("0.0€");
		
		
		ObservableList<Song> songsList = FXCollections.observableArrayList(	new Song("Whispers", "Passenger", 5.0D),
																			new Song("Wolves Without Teeth", "Of Monsters And Men", 6.5D),
																			new Song("Shiver", "Coldplay", 4.5D),
																			new Song("Death & All Of His Friends", "Coldplay", 5.0D),
																			new Song("Dirty Paws", "Of Monsters And Men", 7D));
		songs = new ListView<Song>(songsList);
		songs.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		songs.setPrefSize(350, 200);
		lSongsChosen = new Label("SDAS\nsdasdsdad");
		
		//Add to scene (up part)
		Label lMessage1 = new Label("Choose songs\n\n"); lMessage1.setFont(Font.font(20)); GridPane.setColumnSpan(lMessage1, 3);
		rootNode.add(lMessage1, 0, 0); GridPane.setHalignment(lMessage1, HPos.CENTER);
		rootNode.add(songs, 0, 1); GridPane.setColumnSpan(songs, 2);
		rootNode.add(lSongsChosen, 2, 1); GridPane.setHalignment(lSongsChosen, HPos.CENTER); lSongsChosen.setPrefWidth(350);
				
		
		//Add to scene (down part)
		Label lMessage2 = new Label("\nPayment information\n\n"); lMessage2.setFont(Font.font(20)); GridPane.setColumnSpan(lMessage2, 3);
			rootNode.add(lMessage2, 0, 2); GridPane.setHalignment(lMessage2, HPos.CENTER);
		Label lName = new Label("Name: ");
		rootNode.add(lName, 0, 3); rootNode.add(tfName, 1, 3); 
		rootNode.add(new Label("Email address: "), 0, 4); rootNode.add(tfEmail, 1, 4);
		rootNode.add(new Label("Form of payment: "), 0, 5); rootNode.add(tfPayment, 1, 5);
		rootNode.add(bCalc, 0, 6); GridPane.setHalignment(bCalc, HPos.RIGHT);
		rootNode.add(lFinalPrice, 1, 6);
		rootNode.add(bExit, 3, 7);
		
		//Event handlers		
		bExit.setOnAction((ActionEvent e) -> { //Exit button
			Platform.exit();
			System.exit(0);
		});
		
		songs.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> { //ListView
			String toDisplay = "Your shopping cart contains:\n";
			ObservableList<Song> selected = songs.getSelectionModel().getSelectedItems();
			for (Object o : selected) {
				toDisplay += o.toString() + "\n";
			}
			lSongsChosen.setText(toDisplay);
		});
		
		bCalc.setOnAction((ActionEvent e) -> { //Calculate button
			double fPrice = 0D;
			ObservableList<Song> selected = songs.getSelectionModel().getSelectedItems();
			for (Song o : selected) {
				fPrice += o.getPrice();
			}
			lFinalPrice.setText(String.valueOf(fPrice) + "€");
		});
		
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
