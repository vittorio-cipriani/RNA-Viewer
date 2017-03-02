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

		Tab circleTab = new Tab();
		circleTab.setText("Circle");
		circleTab.setContent(Draw.circleCanvas);
		circleTab.setClosable(false);

		tabPane.getTabs().add(arcsTab);

		tabPane.getTabs().add(circleTab);


		root.setLeft(null);
		root.setCenter(tabPane);

	}

}
