
<!-- saved from url=(0232)https://s3.amazonaws.com/data.teamlab.com/15/82/31/forum/22809/34460/f8993294-eb73-469f-87f8-40437ff96025/permutationimplementation.java?AWSAccessKeyId=AKIAJ6F26BFDPKHVPHIA&Expires=1365276756&Signature=ingl8FsFWMbY4gtcGCpJJBheJTY%3D -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></head><body><pre style="word-wrap: break-word; white-space: pre-wrap;">package aufgabe_1_1;

import java.util.ArrayList;
import java.util.TreeMap;
/**
 * Wenn ihr was an dem Programm aendert, vergesst nicht die Versionsnummer
 * irgendwie zu aendern.
 * 
 * @author Gruppe 3
 * @version 1.00
 */

class PermutationImplementation implements Permutation {

	
	private int[] valArr;
	private int[] error = { 0, 0, 0, 0 };
	boolean nap = false;
	private Liste&lt;Liste&lt;Integer&gt;&gt; cyclenListe;

	
	public PermutationImplementation(int... i) {

		// sind Werte uebergeben worden?
		if (i.length == 0) {
			// Nein
			System.out
					.println("Fehler: Parameterlaenge bei Konstruktor PermutationImplementation = 0!");
			System.exit(1);
		} else {
			// Ja

			// Sind doppelte Werte, oder Werte mit Luecken uebergeben worden ?
			if (Util.checkForMultipleNumber(i) || Util.checkForGaps(i)) {
				// Ja
				System.out
						.println("Fehler: Keine korrekte Permutation uebergeben! Nap");

				nap = true;
				valArr = error;

			} else {
				// Nein
				valArr = new int[i.length];

				for (int j = 0; j &lt; i.length; j++) {
					valArr[j] = i[j];
				}
			}
		}
	}

	public boolean getNaP() {
		return nap;
	}

	public int functionValue(int i) {

		if (nap) {
			System.out.println("getFunctionValue(): NaP!");
			return NaP;
		}

		// Ist i groesser als die Permutation lang ist ?
		if (i &gt; valArr.length - 1) {
			// Ja
			System.out
					.println("Fehler: Kein korrekter Wert fuer getFunctionValue uebergeben!");

			return ERROR;
		}

		// Nein
		return valArr[i - 1];
	}

	public Liste&lt;Integer&gt; cycle(int val) throws IndexOutOfBoundsException {

		this.toCycleString();
		
		if (nap) {
			System.out.println("getCycle(): NaP!");
			;
		}
		

		
		//TmpListe für ein cycle erstellen
		Liste&lt;Integer&gt; tmpCycle = new Liste&lt;Integer&gt;();
		
		// gewünsche Cycle in die TmpListe abspeichern
		tmpCycle.addAll(cyclenListe.get(val - 1));

		return tmpCycle;

	}

	public Permutation inverse() {

		if (nap) {
			System.out.println("getInverse(): NaP!");

			return new PermutationImplementation(error);
		}

		int[] arrRes = new int[valArr.length];
		int tmp;

		// Bilden der Inversen Permutation
		// (1,2,3) (3,1,2) (1,2,3)
		//
		// (3,1,2) (1,2,3) (2,3,1)
		for (int i = 0; i &lt; valArr.length; i++) {
			tmp = valArr[i];
			arrRes[tmp - 1] = i + 1;
		}

		return new PermutationImplementation(arrRes);
	}

	public Permutation composition(Permutation p) {

		if (nap || ((PermutationImplementation) p).getNaP()) {
			System.out.println("getComposition(): NaP!");

			return new PermutationImplementation(error);
		}

		int[] arrP1 = valArr;
		int[] arrP2 = ((PermutationImplementation) p).getValues();
		int[] arrRes = new int[((PermutationImplementation) p).getValues().length];
		int tmp;

		// Hat die uebergebene Permutation dieselbe Laenge?
		if (arrP1.length == arrP2.length) {
			// Ja

			// p2(3,5,1,4,2,) o p1(2,4,5,1,3) -&gt; (5,4,2,3,1)
			for (int i = 0; i &lt; arrP1.length; i++) {
				tmp = arrP1[i];
				arrRes[i] = arrP2[tmp - 1];
			}

			return new PermutationImplementation(arrRes);

		} else {
			// Nein

			System.out
					.println("\nDie uebergebe Permutation hat nicht dieselbe Laenge! "
							+ "Das Ergebnis ist falsch!");

			return this;
		}
	}

	@Override
	public boolean equals(Object o) {

		if (!nap || !((PermutationImplementation) o).getNaP()) {
			int[] tmp;

			// Ist das uebergebene Object vom Typ Permutation?
			if (o instanceof Permutation) {
				// Ja
				tmp = ((PermutationImplementation) o).getValues();

				// Hat die uebergebene Permutation die selbe Laenge?
				if (valArr.length == tmp.length) {
					// Ja

					// Sind alle Elemente gleich?
					for (int i = 0; i &lt; valArr.length; i++) {
						if (valArr[i] != tmp[i]) {
							// Nein
							return false;
						}
					}

					// Ja
					return true;
				}

				// Nein
			}

			// Nein
			return false;
		} else {
			System.out.println("equals(): NaP!");

			return false;
		}
	}

	public Liste&lt;Liste&lt;Integer&gt;&gt; fixpoints() {

		if (nap) {
			System.out.println("getFixpoints(): NaP!");
		}
		
		// Wenn ein Wert aus der Permutation mit dem
		// gegenueberliegendem Wert aus der Id uebereinstimmt,
		// ist es ein Fixpoint.

		// (1,2,3,4,5)
		// ( | )
		// (3,5,1,4,2)
		
		//äußere Temporäre-Liste, die mit dem return zurück gegeben wird.
		Liste&lt;Liste&lt;Integer&gt;&gt; tmpList = new Liste&lt;Liste&lt;Integer&gt;&gt;();

		for (int i = 0; i &lt; valArr.length; i++) {
			//Innere tmp, zwischenspeichert den aktuellen fixpoint
			Liste&lt;Integer&gt; tmp = new Liste&lt;Integer&gt;();
			if (valArr[i] == i + 1) {
				tmp.add(valArr[i]);
			}
			if (tmp.size() &gt; 0) {
				//Fixpunkte werden abgesichert für die rückgabe.
				tmpList.add(tmp);
			}
		}
		return tmpList;
	}

	public int numFixpoints() {

		int count = 0;

		for (int i = 0; i &lt; valArr.length; i++) {
			if (valArr[i] == i + 1) {
				count++;
			}
		}

		return count;
	}

	public int[] getValues() {
		return valArr;
	}

	@Override
	public String toString() {

		if (nap) {
			return "toString(): NaP!";
		}

		StringBuilder sb = new StringBuilder("(");

		for (int i = 0; i &lt; valArr.length; i++) {
			sb.append(valArr[i]);

			if ((i &gt;= 0) &amp;&amp; (i &lt; valArr.length - 1)) {
				sb.append(",");
			}
		}

		sb.append(")");

		return sb.toString();
	}

	
	
	
	public String toCycleString() {

		this.cyclenListe = new Liste&lt;Liste&lt;Integer&gt;&gt;();
		
		if (nap) {
			return "toCycleString(): NaP!";
		}

		int value; // Variable, um index-richtig einen Zyklus abzulaufen
		int cycleIndex = 0; // Index, an dem das Vorkommen einer Variablen eines
							// Zyklus im cycleBuffer Array abgelegt wird

		boolean cycle; // Flag, ob gerade ein Zyklus abgearbeitet wurde
		int[] cycleBuffer = new int[valArr.length]; // Puffer fuer die
													// Variablen, die in einem
													// Zyklus vorkommen
		boolean[] visited = new boolean[valArr.length]; // Array zum Pruefen,
														// welche Zahlen bereits
														// abgearbeitet wurden

		int counter = 0; // Zaehler fuer die Summe der Zyklus-Kandidaten
		boolean unsorted; // Flag, um Zyklus-Array im Bubble-Sort zu sortieren
		int temp; // Temp-Variable fuer Bubble-Sort

		StringBuilder sb = new StringBuilder(); // StringBuilder fuer den
												// Ouput-String

		// START
		// Anfangen die Permutation zu durchlaufen
		for (int i = 0; i &lt; valArr.length; i++) {
			
			//Temporäre Liste für ein Cycle
			Liste&lt;Integer&gt; tmpCycle = new Liste&lt;Integer&gt;();

			// Wenn der Wert in Index i noch nicht geprueft wurde
			if (!visited[i]) {

				cycle = false; // Zyklus-Flag zuruecksetzen
				sb.append('('); // Klammern oeffnen fuer naechsten Zyklus /
								// Fixpunkt
				cycleBuffer[cycleIndex] = valArr[i]; // Wert i der Permutation
														// wird im cycleBuffer
														// abgelegt
				counter++; // Zyklus-Kandidat gefunden
				visited[i] = true; // Wert in i als abgearbeitet markieren

				// value dekrementieren, so ist es index-richtig.
				// Dadurch kann ein Zyklus anhand des Wertes durchlaufen werden.
				// Die Arrays starten bei Index 0, die Permutationen bei 1!
				value = (valArr[i] - 1);

				// Falls der (index-richtige) Wert noch nicht geprueft wurde,
				// wird der Zyklus nun Wert fuer Wert durchlaufen
				while (!(visited[value])) {

					cycleIndex++; // Im cycleBuffer zum naechsten Index zum
									// Speichern vorruecken
					cycleBuffer[cycleIndex] = valArr[value]; // Wert des Zyklus
																// im
																// cycleBuffer
																// ablegen
					counter++; // Zyklus-Kandidat gefunden
					visited[value] = true; // Wert in visited als abgearbeitet
											// markieren
					value = (valArr[value] - 1); // value index-richtig setzen
					cycle = true; // Zyklus-Flag setzen
				} // while

				// Wenn ein Zyklus gefunden wurde, die Zyklus-Kandidaten korrekt
				// sortierten
				if (cycle) {

					// Bubble-Sort Flag setzen und Array fuer Zyklus-Kandidaten
					// anlegen
					unsorted = true;
					int[] cycleCandidates = new int[counter];

					// Gueltige Zyklus-Variablen (groesser 0) aus cycleBuffer
					// nach cycleCandidates uebertragen
					for (int j = 0; j &lt; cycleCandidates.length; j++) {
						for (int k = 0; k &lt; cycleBuffer.length; k++) {
							if (cycleBuffer[k] &gt; 0) {
								cycleCandidates[j] = cycleBuffer[k];
								j++;
							} // if
						} // for
					} // for

					// cycleCandidates mit Bubble-Sort aufsteigend sortieren
					while (unsorted) {

						unsorted = false; // Bubble-Sort Flag zuruecksetzen

						for (int k = 0; k &lt; cycleCandidates.length - 1; k++) {
							if (cycleCandidates[k] &gt; cycleCandidates[k + 1]) {

								temp = cycleCandidates[k];
								cycleCandidates[k] = cycleCandidates[k + 1];
								cycleCandidates[k + 1] = temp;
								unsorted = true; // Bubble-Sort Flag setzen
							} // if
						} // for
					} // while

					// Gefundene und sortierte cycleCandidates im StringBuilder
					// ablegen
					for (int j = 0; j &lt; cycleCandidates.length; j++) {
						sb.append(cycleCandidates[j]);
						sb.append(" ");
						
						//Cyclen paare in die tmp-Liste absichern
						tmpCycle.add(cycleCandidates[j]);
					} // for

					// Wenn ein Leerzeichen am Ende eines Zyklus vorhanden ist,
					// dieses entfernen
					if (sb.charAt(sb.length() - 1) == ' ') {
						sb.deleteCharAt(sb.length() - 1);
					} // if

				} // if - ENDE der Zyklus-Verarbeitung

				// Wenn KEIN Zyklus abgearbeitet wurde, gefundenen Fixpunkt im
				// StringBuilder ablegen
				if (!cycle) {
					sb.append(valArr[i]);
					
					//Fixpunkte in die tmp-Liste sichern.
					tmpCycle.add(valArr[i]);
				} // if

				// Operation an Zyklus, bzw. Fixpunkt mit Klammer beenden,
				// counter und cycleBuffer leeren
				sb.append(')');
				counter = 0;
				cycleBuffer = new int[valArr.length];
			} // if
			
			//Wenn die tmp-Liste nicht leer ist, dann wird sie in der CycleListe abgesichert.
			if (tmpCycle.size() &gt; 0) {
				cyclenListe.add(tmpCycle);
			}

		} // for

		return sb.toString();
	}

	

	
	
} 





// ToString Methoden von ArrayList Redefinierten

class Liste&lt;E&gt; extends ArrayList&lt;E&gt;{
	
	@Override
	public String toString(){
		
		StringBuilder ret = new StringBuilder();
		
		ret.append("(");
		 
		for (E index : this){ 
			ret.append(index + " ") ;
			}
		
		ret.deleteCharAt(ret.length()-1);
		
		return ret.append( ")").toString();
		
	}
}

</pre></body></html>