import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * Classe per disegnare grafi lineari non orientati prova2
 * 
 * @author vcipr
 *
 */
public class Main extends Application {

	Path path = new Path();
	Group root = new Group();
	static List<Pair> coppie = new ArrayList<Pair>();

	// List<Path> pathList = new ArrayList<Path>;
	// Stringa in input di nucleotidi

	static String aucg; // Stringa in input di nucleotidi

	/**
	 * Metodo che fa partire tutto
	 */
	@Override
	public void start(Stage primaryStage) {

		try {

			/*
			 * while (Recognise_input.insertAUCG() == false) {
			 * JOptionPane.showMessageDialog(null, "Errore inserimento");
			 * 
			 * } aucg = Recognise_input.message;
			 * 
			 * coppie = TestString.check_list();
			 */
			
			aucg = "AUCGAUCGAUCGAUCGAUCGAUCG";
			coppie.add(new Pair("1","2"));
			coppie.add(new Pair("3","9"));
			coppie.add(new Pair("4","6"));
			
			//test
			System.out.println(coppie.toString());
			
			
			primaryStage.setResizable(false);

			for (int i = 0; i < coppie.size(); i++) {
				Pair trovata = coppie.get(i);

				int indice1 = Integer.parseInt(trovata.getFirst()) - 1;
				int indice2 = Integer.parseInt(trovata.getSecond()) - 1;
				System.out.println(aucg.charAt(indice1));
				System.out.println(aucg.charAt(indice2));

				Draw.drawArcs(indice1, indice2);

			}

			Draw.drawBase();
			Draw.drawLineAndOvals();

			// root.getChildren().add(path);
			root.getChildren().add(Draw.canvas);

			Scene scene = new Scene(root, Draw.windowWidth, Draw.windowHeight);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
