import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class GUI {

	static BorderPane root = new BorderPane();
	static TabPane tabPane = new TabPane();

	public static void load() {

		Tab arcsTab = new Tab();
		arcsTab.setText("Arcs");
		arcsTab.setContent(Draw.arcsCanvas);
		arcsTab.setClosable(false);

		Tab circularTab = new Tab();
		circularTab.setText("Circular");
		circularTab.setContent(Draw.circularCanvas);
		circularTab.setClosable(false);


		tabPane.getTabs().add(arcsTab);

		tabPane.getTabs().add(circularTab);

		root.setLeft(null);
		root.setCenter(tabPane);

	}

}
