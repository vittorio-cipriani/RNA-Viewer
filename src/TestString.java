
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

public class TestString {
	public static List<Pair> check_list() {
		/*
		 * Testato: (10,4);(5,3);(35543,8);(0,0)
		 */
		String prova = new String(
				JOptionPane.showInputDialog("Inserisci una stringa del tipo (numero,numero);...;(numero,numero)"));

		String splitArr[] = prova.split("[\\;]");
		System.out.println(Arrays.asList(splitArr));
		List<String> x = Arrays.asList(splitArr);
		String tmp = new String();
		List<Pair> arrayOfPairs = new ArrayList<Pair>(x.size());
		for (int i = 0; i < x.size(); i++) {
			tmp = x.get(i).substring(1, x.get(i).length() - 1);
			splitArr = tmp.split(",");
			arrayOfPairs.add(new Pair(splitArr[0], splitArr[1]));
		}

		for (Pair element : arrayOfPairs){
			System.out.println(element);
			System.out.println(element.getFirst());
			System.out.println(element.getSecond());
		}
		
		

		return arrayOfPairs;

	}

}
