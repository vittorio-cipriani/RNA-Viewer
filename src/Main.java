import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * Classe per disegnare grafi lineari non orientati
 * prova2
 * @author vcipr
 *
 */
public class Main extends Application {

	Path path;
	Group root;
	static List<Pair> coppie;

	List<Path> pathList;
	// Stringa in input di nucleotidi

	static String aucg;

	public Main() {
		path = new Path();
		root = new Group();
		coppie = TestString.check_list();

		pathList = new ArrayList<Path>();
		// Stringa in input di nucleotidi

		// try {
		// aucg = Recognise_input.insertAUCG();
		// } catch (Exception e) {
		// aucg=Recognise_input.insertAUCG();
		// }
		while (Recognise_input.insertAUCG() == false) {
			JOptionPane.showMessageDialog(null, "Errore inserimento");

		}
		aucg = Recognise_input.message;

	}

	/**
	 * Metodo che fa partire tutto
	 */
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setResizable(false);

			for (int i = 0; i < coppie.size(); i++) {
				Pair trovata = coppie.get(i);

				int indice1 = Integer.parseInt(trovata.getFirst()) - 1;
				int indice2 = Integer.parseInt(trovata.getSecond()) - 1;
				System.out.println(aucg.charAt(indice1));
				System.out.println(aucg.charAt(indice2));

				 Draw.drawArcs(indice1, indice2);

			}

			//Draw.drawArcs();
			Draw.drawBase();
			Draw.drawLineAndOvals();

			// root.getChildren().add(path);
			root.getChildren().add(Draw.canvas);

			Scene scene = new Scene(root, Draw.windowWidth, Draw.windowHeight);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
