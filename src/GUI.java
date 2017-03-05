
//import javafx.scene.control;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GUI {

	static BorderPane root = new BorderPane();
	static TabPane tabPane = new TabPane();
	static VBox vbox = new VBox();

	static ListView<Pair> listView;

	public static void load() {

		// oggetti nella barra del menu
		final Menu file = new Menu("File");
		final Menu options = new Menu("Options");
		final Menu help = new Menu("Help");

		final MenuItem about = new MenuItem("About		");

		// creo l'hanlder dell'about e lo setto nel oggetto ABOUT nel menu
		EventHandler<ActionEvent> action = showAbout();
		about.setOnAction(action);

		// inserisco l'about nella sezione help
		help.getItems().add(about);

		// barra del menu
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(file, options, help);

		// tab rappresentazione archi
		Tab arcsTab = new Tab();
		arcsTab.setText("Arcs");
		arcsTab.setContent(Draw.arcsCanvas);
		arcsTab.setClosable(false);

		// tab rappresentazione circolare
		Tab circularTab = new Tab();
		circularTab.setText("Circular");
		circularTab.setContent(Draw.circularCanvas);
		circularTab.setClosable(false);

		tabPane.getTabs().add(arcsTab);

		tabPane.getTabs().add(circularTab);

		// root.setRight(vbox);
		// root.setLeft(null);

		root.setTop(menuBar);

		// root.setRight(listView);
		root.setCenter(tabPane);

		loadVBox();
		root.setRight(vbox);

	}

	// evento da lanciare per l'about
	private static EventHandler<ActionEvent> showAbout() {
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("RNA Viewer");
				alert.setHeaderText("About this software");
				alert.setContentText("Software svilluppato ecc...");
				// alert.setContentText("I have a great message for you!");

				alert.showAndWait();
			}
		};

	}

	public static void loadVBox() {

		
		populateListView();
		Label labelList = new Label("Lista di adiacenza");
		vbox.getChildren().add(labelList);
		vbox.setSpacing(6);
		vbox.setPadding(new Insets(5, 10, 5 ,12));
		vbox.setMaxWidth(Draw.windowWidth - Draw.canvasWidth + Draw.pointDim / 2);
		vbox.getChildren().add(listView);
	}

	public static void populateListView() {

		//per cambiare visualizzazione delle coppie ridefinire listView
		ObservableList<Pair> coppie = FXCollections.observableArrayList(Main.coppie);
		listView = new ListView<Pair>(coppie);

	}
}
