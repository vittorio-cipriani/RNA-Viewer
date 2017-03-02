
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Draw {

	final static int canvasWidth = 800;
	final static int canvasHeight = 400;
	final static int windowWidth = 800;
	final static int windowHeight = 600;

	final static int stcArcHeight = 50;

	final static int pointDim = 20;
	final static int pointY = canvasHeight - pointDim - pointDim / 2;
	final static int baseLineLength = 780;

	public static Canvas canvas = new Canvas(Draw.canvasWidth, Draw.canvasHeight);
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

			boolean redOne = false;

			ch = Character.toString(Main.aucg.charAt(i));
			x = 10 + pointDistance / 2 + pointDistance * i;

			gc.setLineWidth(1);
			gc.setFill(Color.WHITE);

			// cerchio
			gc.fillOval(x, y, pointDim, pointDim);

			for (Pair coppia : Main.coppie) {
				if (i == Integer.parseInt(coppia.getFirst()) - 1 || i == Integer.parseInt(coppia.getSecond()) - 1) {
					gc.setStroke(Color.RED);
					gc.strokeOval(x, y, pointDim, pointDim);

					redOne = true;
					break;

				}
				
			}
			
			if (!redOne) {
				gc.setStroke(Color.BLACK);
				gc.strokeOval(x, y, pointDim, pointDim);
			}


			// testo
			gc.setFill(Color.BLACK);
			gc.fillText(ch, x + pointDim / 3, y + pointDim / 1.4);

		}

	}

	public static void drawArcs(int firstIndex, int secondIndex) {

		int x1, x2;
		int pointDistance = baseLineLength / Main.aucg.length();

		// altezza archi

		// X di inizio disegno
		x1 = 10 + pointDistance / 2 + pointDistance * firstIndex + pointDim / 2;

		// X di fine
		x2 = 10 + pointDistance / 2 + pointDistance * secondIndex + pointDim / 2;

		int h = (x2 - x1);
		int w = x2 - x1;

		// sposto l'inizio del disegno in basso
		int y = pointY - h / 2;

		System.out.println(x2 - x1);
		gc.setStroke(Color.RED);
		gc.setLineWidth(2);
		gc.strokeArc(x1, y, w, h, 0, 180, ArcType.OPEN);

	}

}