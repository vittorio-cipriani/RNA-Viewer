
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Path;

public class Draw {

	final static double canvasWidth = 1000;
	final static double canvasHeight = 600;
	final static double windowWidth = 1200;
	final static double windowHeight = 800;

	final static double pointDim = 20;
	final static double pointY = canvasHeight - pointDim - pointDim / 2;
	final static double baseLineLength = canvasWidth - pointDim;

	public static Canvas arcsCanvas = new Canvas(Draw.canvasWidth, Draw.canvasHeight);
	public static Canvas circularCanvas = new Canvas(Draw.canvasWidth, Draw.canvasHeight);

	static GraphicsContext gcArcs = arcsCanvas.getGraphicsContext2D();
	static GraphicsContext gcCircular = circularCanvas.getGraphicsContext2D();

	final static double diam = canvasHeight - 50;

	static Path path = new Path();

	public static void drawBase_ARCS() {

		// disegno il contorno del canvas
		// gcArcs.setStroke(Color.BLACK);
		// gcArcs.moveTo(0, 0);
		// gcArcs.lineTo(0, canvasHeight);
		// gcArcs.lineTo(canvasWidth, canvasHeight);
		// gcArcs.lineTo(canvasWidth, 0);
		// gcArcs.lineTo(0, 0);
		// gcArcs.setLineWidth(3);
		// gcArcs.stroke();
		//
		gcArcs.setStroke(Color.BLACK);
		gcArcs.setLineWidth(3);
		gcArcs.rect(0, 0, canvasWidth, canvasHeight);

		// base dell'RNA (linea)
		gcArcs.moveTo(10, pointY);
		gcArcs.lineTo(baseLineLength, pointY);
		// gcArcs.setLineWidth(2);
		gcArcs.stroke();

	}

	public static void drawtextandOvals_ARCS() {

		double pointDistance = baseLineLength / Main.aucg.length();
		double x;
		double y = pointY - pointDim / 2;
		String ch;

		for (int i = 0; i < Main.aucg.length(); i++) {

			boolean redOne = false;

			ch = Character.toString(Main.aucg.charAt(i));
			x = pointDistance / 2 + pointDistance * i;

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

	public static void drawArcs_ARCS(double firstIndex, double secondIndex) {

		firstIndex--;
		secondIndex--;

		double x1, x2;
		double pointDistance = baseLineLength / Main.aucg.length();

		// altezza archi

		// X di inizio disegno
		x1 = pointDistance / 2 + pointDistance * firstIndex + pointDim / 2;

		// X di fine
		x2 = pointDistance / 2 + pointDistance * secondIndex + pointDim / 2;

		double h = x2 - x1;
		double w = x2 - x1;

		// sposto l'inizio del disegno in basso
		double y = pointY - h / 2;

		// System.out.prdoubleln(x2 - x1);
		gcArcs.setStroke(Color.RED);
		gcArcs.setLineWidth(2);

		// la X e la Y per strokeARC sono l'inizio in alto a sinsitra del
		// disegno, w e h sono le dimensioni del cerchio che si formerà se verrà
		// disegnato tutto l'arco;
		// i due angoli sono l'inizio e la fine del disegno
		gcArcs.strokeArc(x1, y, w, h, 0, 180, ArcType.OPEN);

	}

	public static void drawBase_CIRCULAR() {

		// x e y di inizio disegno
		double x = (canvasWidth - diam) / 2, y = (canvasHeight - diam) / 2;

		gcCircular.setStroke(Color.BLACK);
		gcCircular.setLineWidth(3);
		gcCircular.rect(0, 0, canvasWidth, canvasHeight);
		gcCircular.stroke();

		gcCircular.setLineWidth(2);
		gcCircular.setStroke(Color.BLACK);
		gcCircular.strokeOval(x, y, diam, diam);
	}

	public static void drawtextandOvals_CIRCULAR() {

		// x e y del punto di origine del cerchio
		double originX, originY;

		// x e y dei punti sulla circonferenza
		double x, y;

		// raggio e distanza tra i punti
		double r, pointDistance;

		// carattere da stampare
		String ch;

		originX = canvasWidth / 2;
		originY = canvasHeight / 2;
		r = diam / 2;

		pointDistance = 360 / (double) Main.aucg.length();

		// scorro tutta la stringa e moltiplico la distanza tra i cerchi per
		// l'indice, così da muovermi sulla circonferenza
		for (int i = 0; i < Main.aucg.length(); i++) {

			boolean redOne = false;

			ch = Character.toString(Main.aucg.charAt(i));

			// punti x e y sul cerchio
			// x = cx + r * cos(a)
			// y = cy + r * sin(a)
			x = originX + r * Math.cos(Math.toRadians(pointDistance * i));
			y = originY + r * Math.sin(Math.toRadians(pointDistance * i));

			// aggiusto x e y per centrare i cerchi
			x -= pointDim / 2;
			y -= pointDim / 2;

			// disegna linea per segnalare inizio stringa
			if (i == 0) {
				gcCircular.setLineWidth(2);
				gcCircular.strokeLine(x - pointDim, y, x + pointDim * 2, y);
				gcCircular.stroke();
			}

			// riempio i cerchi

			gcCircular.setFill(Color.WHITE);
			gcCircular.fillOval(x, y, pointDim, pointDim);

			// scorro le coppie e controllo come colorarle
			for (Pair coppia : Main.coppie) {
				if (i == Integer.parseInt(coppia.getFirst()) - 1 || i == Integer.parseInt(coppia.getSecond()) - 1) {
					gcCircular.setStroke(Color.RED);
					gcCircular.strokeOval(x, y, pointDim, pointDim);

					redOne = true;
					break;
				}
			}

			if (!redOne) {
				gcCircular.setStroke(Color.BLACK);
				gcCircular.strokeOval(x, y, pointDim, pointDim);
			}

			// disegno il carattere dentro al cerchio
			gcCircular.setFill(Color.BLACK);
			gcCircular.fillText(ch, x + pointDim / 3, y + pointDim / 1.4);

		}

		// punto origine del cerchio
		// gcCircular.strokeOval(canvasWidth / 2, canvasHeight / 2, 2, 2);
	}

	public static void drawArcs_CIRCULAR(double firstIndex, double secondIndex) {

		firstIndex--;
		secondIndex--;

		// origini del cerchio
		double originX, originY;

		// x e y dei punti sulla circonferenza
		double x1, x2, y1, y2;

		// raggio e distanza tra i punti
		double r, pointDistance;

		// origine cerchio
		originX = canvasWidth / 2;
		originY = canvasHeight / 2;

		// raggio
		r = diam / 2;

		// distanza tra i punti
		pointDistance = 360 / (double) Main.aucg.length();

		// punti x e y sul cerchio
		// x = cx + r * cos(a)
		// y = cy + r * sin(a)
		x1 = originX + r * Math.cos(Math.toRadians(pointDistance * firstIndex));
		y1 = originY + r * Math.sin(Math.toRadians(pointDistance * firstIndex));

		x2 = originX + r * Math.cos(Math.toRadians(pointDistance * secondIndex));
		y2 = originY + r * Math.sin(Math.toRadians(pointDistance * secondIndex));

		// aggiusto x e y per centrare i cerchi
		// x1 -= pointDim / 2;
		// y1 -= pointDim / 2;
		// x2 -= pointDim / 2;
		// y2 -= pointDim / 2;

		// gcCircular.setLineWidth(1);
		// gcCircular.setStroke(Color.BLACK);
		// gcCircular.strokeText(Double.toString(w), x1, y1);
		// gcCircular.strokeText(Double.toString(h), x2, y2);
		// la X e la Y per strokeARC sono l'inizio in alto a sinsitra del
		// disegno, w e h sono le dimensioni del cerchio che si formerà se verrà
		// disegnato tutto l'arco;
		// i due angoli sono l'inizio e la fine del disegno
		gcCircular.setStroke(Color.RED);
		gcCircular.setLineWidth(2);

		// double centerX, centerY, radiusX, radiusY, startAngle, length;
		//
		// centerX = Math.abs(x1 - x2) / 2 + Math.min(x1, x2);
		//
		// centerY = Math.abs(y1 - y2) / 2 + Math.min(y1, y2);
		//
		// radiusX = Math.abs(x1 - x2);
		// radiusY = Math.abs(y1 - y2)/2;
		//
		// startAngle = pointDistance * firstIndex;
		// double endAngle = pointDistance * secondIndex;
		//
		// length = Math.abs(startAngle - endAngle);
		// gcCircular.beginPath();
		// gcCircular.arc(centerX, centerY, radiusX, radiusY, 0, 360);
		// gcCircular.stroke();
		//
		// gcCircular.setStroke(Color.BLACK);
		// gcCircular.strokeText(".CEntro", centerX, centerY);

		gcCircular.strokeLine(x1, y1, x2, y2);

		// MoveTo moveTo = new MoveTo();
		// moveTo.setX(x1);
		// moveTo.setY(y1);
		//
		// ArcTo arcTo = new ArcTo();
		// arcTo.setX(x2);
		// arcTo.setY(y2);
		// arcTo.setRadiusX(50.0);
		// arcTo.setRadiusY(50.0);
		//
		// path.getElements().add(moveTo);
		// path.getElements().add(arcTo);

	}

	public static void generalDraw() {

		for (int i = 0; i < Main.coppie.size(); i++) {
			Pair trovata = Main.coppie.get(i);
			int indice1 = Integer.parseInt(trovata.getFirst());
			int indice2 = Integer.parseInt(trovata.getSecond());

			Draw.drawArcs_ARCS(indice1, indice2);
		}
		Draw.drawBase_ARCS();
		Draw.drawtextandOvals_ARCS();

		for (int i = 0; i < Main.coppie.size(); i++) {
			Pair trovata = Main.coppie.get(i);
			int indice1 = Integer.parseInt(trovata.getFirst());
			int indice2 = Integer.parseInt(trovata.getSecond());

			Draw.drawArcs_CIRCULAR(indice1, indice2);
		}
		Draw.drawBase_CIRCULAR();
		Draw.drawtextandOvals_CIRCULAR();
	}
}