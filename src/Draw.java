
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Draw {

	final static int canvasWidth = 1000;
	final static int canvasHeight = 500;
	final static int windowWidth = 1200;
	final static int windowHeight = 800;

	final static int pointDim = 20;
	final static int pointY = canvasHeight - pointDim - pointDim / 2;
	final static int baseLineLength = canvasWidth - 20;

	public static Canvas arcsCanvas = new Canvas(Draw.canvasWidth, Draw.canvasHeight);
	public static Canvas circleCanvas = new Canvas(Draw.canvasWidth, Draw.canvasHeight);
	
	
	static GraphicsContext gcArcs = arcsCanvas.getGraphicsContext2D();
	static GraphicsContext gcCircle = circleCanvas.getGraphicsContext2D();

	public static void drawBase_ARCS() {

		// disegno il contorno del canvas
		gcArcs.setStroke(Color.BLACK);
		gcArcs.moveTo(0, 0);
		gcArcs.lineTo(0, canvasHeight);
		gcArcs.lineTo(canvasWidth, canvasHeight);
		gcArcs.lineTo(canvasWidth, 0);
		gcArcs.lineTo(0, 0);
		gcArcs.setLineWidth(3);
		gcArcs.stroke();

		// base dell'RNA (linea)
		gcArcs.moveTo(10, pointY);
		gcArcs.lineTo(baseLineLength, pointY);
		gcArcs.setLineWidth(2);
		gcArcs.stroke();

	}

	public static void drawLineAndOvals_ARCS() {

		int pointDistance = baseLineLength / Main.aucg.length();
		int x;
		int y = pointY - pointDim / 2;
		String ch;

		for (int i = 0; i < Main.aucg.length(); i++) {

			boolean redOne = false;

			ch = Character.toString(Main.aucg.charAt(i));
			x = 10 + pointDistance / 2 + pointDistance * i;

			gcArcs.setLineWidth(1);
			gcArcs.setFill(Color.WHITE);

			// cerchio
			gcArcs.fillOval(x, y, pointDim, pointDim);

			for (Pair coppia : Main.coppie) {
				if (i == Integer.parseInt(coppia.getFirst()) - 1 || i == Integer.parseInt(coppia.getSecond()) - 1) {
					gcArcs.setStroke(Color.RED);
					gcArcs.strokeOval(x, y, pointDim, pointDim);

					redOne = true;
					break;

				}

			}

			if (!redOne) {
				gcArcs.setStroke(Color.BLACK);
				gcArcs.strokeOval(x, y, pointDim, pointDim);
			}

			// testo
			gcArcs.setFill(Color.BLACK);
			gcArcs.fillText(ch, x + pointDim / 3, y + pointDim / 1.4);

		}

	}

	public static void drawArcs_ARCS(int firstIndex, int secondIndex) {

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
		gcArcs.setStroke(Color.RED);
		gcArcs.setLineWidth(2);
		gcArcs.strokeArc(x1, y, w, h, 0, 180, ArcType.OPEN);

	}

	public static void drawBase_CIRCLE(){
		
		//TODO
	}
}