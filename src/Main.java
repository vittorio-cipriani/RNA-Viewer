import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe per disegnare grafi lineari non orientati prova2
 * 
 * @author vcipr
 *
 */
public class Main extends Application {

	static List<Pair> coppie = new ArrayList<Pair>();

	// List<Path> pathList = new ArrayList<Path>;
	// Stringa in input di nucleotidi

	static String aucg; // Stringa in input di nucleotidi

	public static int indiceFirst;
	public static int indiceSecond;

	/**
	 * Metodo che fa partire tutto
	 */
	@Override
	public void start(Stage primaryStage) {

		//metodo per prendere gli input dell'utente
		// TestString.general_check();

		try {

			// USO QUESTI INPUT PER EVITARE DI INSERIRLI OGNI VOLTA
			// 40LETTERE
			aucg = "CAGCACGACACUAGCAGUCAGUGUCAGACUGCAIACAGCG";

			coppie.add(new Pair("1", "8"));
			coppie.add(new Pair("6", "10"));
			coppie.add(new Pair("2", "12"));
			coppie.add(new Pair("11", "23"));
			coppie.add(new Pair("4", "16"));
			coppie.add(new Pair("10", "26"));
			coppie.add(new Pair("18", "30"));
			coppie.add(new Pair("22", "40"));
			coppie.add(new Pair("31", "39"));

			// test
			// System.out.println(coppie.toString());

			primaryStage.setResizable(false);

			Draw.generalDraw();
			GUI.load();

			Scene scene = new Scene(GUI.root, Draw.windowWidth, Draw.windowHeight);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// primaryStage.setResizable(true);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Eccezzione nel main, contattare i developerz!");
			Platform.exit();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
