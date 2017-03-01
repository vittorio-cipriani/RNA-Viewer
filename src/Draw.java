
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Draw {

	public final static int canvasWidth = 800;
	public final static int canvasHeight = 400;
	public final static int windowWidth = 800;
	public final static int windowHeight = 600;

	public final static int pointDim = 20;
	public final static int pointY = canvasHeight - pointDim - pointDim / 2;
	public final static int baseLineLength = 780;

	public static Canvas canvas = new Canvas(Draw.canvasWidth,
			Draw.canvasHeight);
	static GraphicsContext gc = canvas.getGraphicsContext2D();

	public static void drawBase() {

		// disegno il contorno del canvas
		gc.setStroke(Color.BLACK);
		gc.moveTo(0, 0);
		gc.lineTo(0, canvasHeight);
		gc.lineTo(canvasWidth, canvasHeight);
		gc.lineTo(canvasWidth, 0);
		gc.lineTo(0, 0);
		gc.setLineWidth(3);
		gc.stroke();

		// base dell'RNA (linea)
		gc.moveTo(10, pointY);
		gc.lineTo(790, pointY);
		gc.setLineWidth(2);
		gc.stroke();

	}

	public static void drawLineAndOvals() {

		int pointDistance = baseLineLength / Main.aucg.length();
		int x;
		int y = pointY - pointDim / 2;
		String ch;

		for (int i = 0; i < Main.aucg.length(); i++) {

			ch = Character.toString(Main.aucg.charAt(i));
			x = 10 + pointDistance / 2 + pointDistance * i;

			gc.setLineWidth(1);
			gc.setFill(Color.WHITE);

			// cerchio
			gc.fillOval(x, y, pointDim, pointDim);
			gc.strokeOval(x, y, pointDim, pointDim);

			// testo
			gc.setFill(Color.BLACK);
			gc.fillText(ch, x + pointDim / 3, y + pointDim / 1.4);

		}

	}

	public static void drawArcs(int firstIndex,int secondIndex) {

		int x1, x2;
		int pointDistance = baseLineLength / Main.aucg.length();
		//String first, second;
		// indici per disegnare

		// gli inidic per cercare nella aucg
		//int firstIndex, secondIndex;
		int offSet = 10;

		// variabile per abbassare l'altezza dell'arco
//		float radiusRatio = 1;
//		// raggio Y dell'arco
//		float radiusY = 100;

		//y = pointY;

		// for each nella lista coppie
	//	for (Pair coppia : Main.coppie) {

			// estraggo gli elementi della coppia
			//first = coppia.getFirst();
			//second = coppia.getSecond();

			// inizializzo punti di inizio e fine arco
			// MoveTo moveTo = new MoveTo();
			// ArcTo arcTo = new ArcTo();

			// moveTo.setY(y);
			// arcTo.setY(y);
			//
			//
			// arcTo.setRadiusY(radiusY);
			// arcTo.setLargeArcFlag(false);
			// arcTo.setSweepFlag(true);

			// cerco gli indici dei caratteri nella aucg per capire dove
			// inizierà l'arco
			//firstIndex = Main.aucg.indexOf(first);
			//secondIndex = Main.aucg.lastIndexOf(second);

			// X di inizio
			x1 = 10 + pointDistance / 2 + pointDistance * firstIndex
					+ pointDim / 2;
			//
			// x=x1;
			// moveTo.setX(x);

			// X di fine
			x2 = 10 + pointDistance / 2 + pointDistance * secondIndex
					+ pointDim / 2;

			// x=x2;
			// arcTo.setX(x);

			// aggiusto l'altezza dell'arco ad ogni ciclo
			// float radiusX = radiusY * radiusRatio;
			// arcTo.setRadiusX(radiusX);

			// aggiungo l'arco all'oggetto path
			// path.getElements().add(moveTo);
			// path.getElements().add(arcTo);

			gc.setStroke(Color.RED);
			gc.setLineWidth(2);
			gc.strokeArc(x1, 0 + offSet, x2 - x1, pointY * 2 - offSet * 2, 0,
					180, ArcType.OPEN);
			offSet += 10;

			// aumento il rapporto tra raggioX e raggioY dell'arco, quindi
			// abbasso l'arco
			// radiusRatio += 0.002;

			// aggiungo ad una collezione di archi
			// pathList.add(path);

		//}

		// radius y deve cambiare in base alla distanza
		// il rapporto è quello che conta, se è 1 ho un semi cerchio
		// con radiusY maggiore l'ovale si sviluppa in altezza

	}

}
