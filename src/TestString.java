
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class TestString {

	static String message;
	static String prova;
	static List<Pair> coppie;
	static int indice1, indice2;

	/*
	 * Metodo che splitta la lista passata in input: - Se gli indici sono del
	 * tipo (2,1) cioè il secondo è maggiore del primo li scambia - Se sono
	 * uguali restituisce false - Altrimenti aggiunge array of pairs e ritorna
	 * true. Il metodo verrà poi richiamato nel Main
	 */

	public static void insert_adj_list() {
		prova = new String(
				JOptionPane.showInputDialog("Inserisci una stringa del tipo (numero,numero);...;(numero,numero)"));
		coppie = split_and_order();

	}

	public static List<Pair> split_and_order() {

		List<Pair> arrayOfPairs = null;
		try {
			// splitto sui punti e virgola
			String splitArr[] = prova.split("[\\;]");
			
			//test
			System.out.println(Arrays.asList(splitArr));
			
			List<String> x = Arrays.asList(splitArr);
			String tmp = new String();
			arrayOfPairs = new ArrayList<Pair>(x.size());
			
			for (int i = 0; i < x.size(); i++) {
				// tolgo le tonde
				tmp = x.get(i).substring(1, x.get(i).length() - 1);
				// splitto sulle virgole
				splitArr = tmp.split(",");
				//controllo se gli indici sono in ordine
				if (Integer.parseInt(splitArr[0]) > Integer.parseInt(splitArr[1])) {
					String tmpstr = splitArr[1];
					splitArr[1] = splitArr[0];
					splitArr[0] = tmpstr;
				}

				arrayOfPairs.add(new Pair(splitArr[0], splitArr[1]));

			}

			for (Pair element : arrayOfPairs) {
				System.out.println(element);
				System.out.println(element.getFirst());
				System.out.println(element.getSecond());

			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Errore inserimento: Rispettare il pattern della lista di adiacenze!");
			TestString.general_check();

		}

		return arrayOfPairs;
	}

	/*
	 * Metodo che restituisce true o false a seconda che l' input sia AUCG o no.
	 * Metodo richiamato nel main
	 */
	public static boolean insertAUCG() {
		message = JOptionPane.showInputDialog("Inserisci una stringa del tipo AUCG...");

		for (int i = 0; i < message.length(); i++)
			switch (message.charAt(i)) {
			case 'A':
			case 'a':
			case 'U':
			case 'u':
			case 'C':
			case 'c':
			case 'G':
			case 'g':
				break;
			default:
				return false;

			}

		return true;

	}

	public static boolean checkIfNumbers() {
		String regex = "[0-9]+";
		Pair trovata;
		for (int i = 0; i < coppie.size(); i++) {
			trovata = coppie.get(i);
			if (!trovata.getFirst().matches(regex) || !trovata.getSecond().matches(regex)) {
				return false;
			}
		}

		return true;

	}

	/*
	 * Metodo che restituisce true o false nel caso in cui gli indici non siano
	 * presenti nella stringa iniziale
	 */
	public static boolean out_Of_Size() {

		for (int i = 0; i < coppie.size(); i++) {
			Pair trovata = coppie.get(i);
			indice1 = Integer.parseInt(trovata.getFirst()) - 1;
			indice2 = Integer.parseInt(trovata.getSecond()) - 1;
			if (indice1 > message.length() || indice2 > message.length())
				return false;

		}

		return true;
	}

	/*
	 * controlla che non siano uguali
	 */
	public static boolean check_if_equals() {

		for (int i = 0; i < coppie.size(); i++) {
			Pair trovata = coppie.get(i);
			indice1 = Integer.parseInt(trovata.getFirst()) - 1;
			indice2 = Integer.parseInt(trovata.getSecond()) - 1;
			if (indice1 == indice2)
				return false;

		}

		return true;
	}

	/*
	 * Controlla che un nucleotide abbia un solo legame
	 */
	public static boolean only_one_link() {
		ArrayList<String> tmp = new ArrayList<>();
		for (int i = 0; i < coppie.size(); i++) {
			Pair trovata = coppie.get(i);
			tmp.add(trovata.getFirst());
			tmp.add(trovata.getSecond());

		}
		for (int i = 0; i < tmp.size(); i++) {
			for (int j = i + 1; j < tmp.size(); j++) {
				if (tmp.get(i).equals(tmp.get(j))) {
					return false;
				}
			}

		}
		return true;
	}

	public static boolean only_with() {

		for (Pair trovata : coppie) {
			indice1 = Integer.parseInt(trovata.getFirst()) - 1;
			indice2 = Integer.parseInt(trovata.getSecond()) - 1;
			if ((message.charAt(indice1) == 'A' && message.charAt(indice2) == 'U')
					|| (message.charAt(indice1) == 'U' && message.charAt(indice2) == 'A')
					|| (message.charAt(indice1) == 'U' && message.charAt(indice2) == 'G')
					|| (message.charAt(indice1) == 'G' && message.charAt(indice2) == 'U')
					|| (message.charAt(indice1) == 'C' && message.charAt(indice2) == 'G')
					|| (message.charAt(indice1) == 'G' && message.charAt(indice2) == 'C')) {

				return true;

			}

		}

		return false;
	}

	public static void general_check() {

		while (insertAUCG() == false) {
			JOptionPane.showMessageDialog(null, "Errore inserimento stringa");

		}

		insert_adj_list();

		while (out_Of_Size() == false || check_if_equals() == false || only_one_link() == false
				|| only_with() == false) {

			if (TestString.checkIfNumbers() == false) {
				JOptionPane.showMessageDialog(null, "Errore inserimento: Inserire soltanto numeri nelle coppie!");
			} else if (TestString.out_Of_Size() == false) {
				JOptionPane.showMessageDialog(null, "Errore inserimento: Indici non esistenti nella stringa iniziale!");
			} else if (check_if_equals() == false) {
				JOptionPane.showMessageDialog(null, "Errore inserimento: Indici uguali");
			} else if (only_one_link() == false) {
				JOptionPane.showMessageDialog(null, "Errore: un elemento ha solo un legame!");

			} else if (only_with() == false) {
				JOptionPane.showMessageDialog(null, "Errore: legame sbagliato. Gli indici in posizione" + (indice1 + 1)
						+ "," + (indice2 + 1) + "sono sbagliati");
				System.out.println(only_with());

			}
			insert_adj_list();

		}

		Main.aucg = message;
		//
		Main.coppie = coppie;
		Main.indiceFirst = indice1;
		Main.indiceSecond = indice2;
	}

}