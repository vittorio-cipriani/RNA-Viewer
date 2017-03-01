
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class Recognise_input {
static String message;

	public static boolean check_insert(String answer) {

		boolean result1 = false;
		boolean result2 = false;

		for (int i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) == 'A' || answer.charAt(i) == 'U' || answer.charAt(i) == 'C'
					|| answer.charAt(i) == 'G')
				result2 = true;
			else
				result2 = false;
		}

		return result1 || result2;

	}

	public static boolean insertAUCG() throws IllegalArgumentException {
		 message = JOptionPane.showInputDialog("Inserisci una stringa del tipo AUCG...");
		
		for(int i=0; i<message.length(); i++)
			switch(message.charAt(i)){
				case 'A':
				case 'a':
				case 'U':
				case 'u':
				case 'C':
				case 'c':
				case 'G':
				case 'g':
					break;
				//default: throw new IllegalArgumentException();
					default:return false;
			
			}

		return true;

	}

	private static void showError(String message2) {
		message2="BOOOO";
	}

	public static List<Pair> insertAdjList() {
		String appoggio = JOptionPane
				.showInputDialog("Inserisci una stringa del tipo (numero,numero);...;(numero,numero)");
		String splitArr[] = appoggio.split("[\\;]");

		List<String> x = Arrays.asList(splitArr);
		String tmp = new String();
		List<Pair> arrayOfPairs = new ArrayList<Pair>(x.size());
		for (int i = 0; i < x.size(); i++) {
			tmp = x.get(i).substring(1, x.get(i).length() - 1);
			splitArr = tmp.split(",");
			arrayOfPairs.add(new Pair(splitArr[0], splitArr[1]));
		}

		return arrayOfPairs;
	}

}