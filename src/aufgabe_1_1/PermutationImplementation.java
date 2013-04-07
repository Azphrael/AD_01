package aufgabe_1_1;

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
    private Liste<Liste<Integer>> cyclenListe;

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

                for (int j = 0; j < i.length; j++) {
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
        if (i > valArr.length - 1) {
            // Ja
            System.out
                    .println("Fehler: Kein korrekter Wert fuer getFunctionValue uebergeben!");

            return ERROR;
        }

        // Nein
        return valArr[i - 1];
    }

    public Liste<Integer> cycle(int val) throws IndexOutOfBoundsException {

        this.toCycleString();

        if (nap) {
            System.out.println("getCycle(): NaP!");
        }

        // TmpListe für ein cycle erstellen
        Liste<Integer> tmpCycle = new Liste<Integer>();

        // gewünsche Cycle in die TmpListe abspeichern
        tmpCycle.addAll(cyclenListe.get(val));

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
        for (int i = 0; i < valArr.length; i++) {
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

            // p2(3,5,1,4,2,) o p1(2,4,5,1,3) -> (5,4,2,3,1)
            for (int i = 0; i < arrP1.length; i++) {
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
                    for (int i = 0; i < valArr.length; i++) {
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

    public Liste<Liste<Integer>> fixpoints() {

        if (nap) {
            System.out.println("getFixpoints(): NaP!");
        }

        // Wenn ein Wert aus der Permutation mit dem
        // gegenueberliegendem Wert aus der Id uebereinstimmt,
        // ist es ein Fixpoint.

        // (1,2,3,4,5)
        // ( | )
        // (3,5,1,4,2)

        // äußere Temporäre-Liste, die mit dem return zurück gegeben wird.
        Liste<Liste<Integer>> tmpList = new Liste<Liste<Integer>>();

        for (int i = 0; i < valArr.length; i++) {
            // Innere tmp, zwischenspeichert den aktuellen fixpoint
            Liste<Integer> tmp = new Liste<Integer>();
            if (valArr[i] == i + 1) {
                tmp.add(valArr[i]);
            }
            if (tmp.size() > 0) {
                // Fixpunkte werden abgesichert für die rückgabe.
                tmpList.add(tmp);
            }
        }
        return tmpList;
    }

    public int numFixpoints() {

        int count = 0;

        for (int i = 0; i < valArr.length; i++) {
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

        for (int i = 0; i < valArr.length; i++) {
            sb.append(valArr[i]);

            if ((i >= 0) && (i < valArr.length - 1)) {
                sb.append(",");
            }
        }

        sb.append(")");

        return sb.toString();
    }

    public String toCycleString() {

        this.cyclenListe = new Liste<Liste<Integer>>();

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
        for (int i = 0; i < valArr.length; i++) {

            // Temporäre Liste für ein Cycle
            Liste<Integer> tmpCycle = new Liste<Integer>();

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
                    for (int j = 0; j < cycleCandidates.length; j++) {
                        for (int k = 0; k < cycleBuffer.length; k++) {
                            if (cycleBuffer[k] > 0) {
                                cycleCandidates[j] = cycleBuffer[k];
                                j++;
                            } // if
                        } // for
                    } // for

                    // cycleCandidates mit Bubble-Sort aufsteigend sortieren
                    while (unsorted) {

                        unsorted = false; // Bubble-Sort Flag zuruecksetzen

                        for (int k = 0; k < cycleCandidates.length - 1; k++) {
                            if (cycleCandidates[k] > cycleCandidates[k + 1]) {

                                temp = cycleCandidates[k];
                                cycleCandidates[k] = cycleCandidates[k + 1];
                                cycleCandidates[k + 1] = temp;
                                unsorted = true; // Bubble-Sort Flag setzen
                            } // if
                        } // for
                    } // while

                    // Gefundene und sortierte cycleCandidates im StringBuilder
                    // ablegen
                    for (int j = 0; j < cycleCandidates.length; j++) {
                        sb.append(cycleCandidates[j]);
                        sb.append(" ");

                        // Cyclen paare in die tmp-Liste absichern
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

                    // Fixpunkte in die tmp-Liste sichern.
                    tmpCycle.add(valArr[i]);
                } // if

                // Operation an Zyklus, bzw. Fixpunkt mit Klammer beenden,
                // counter und cycleBuffer leeren
                sb.append(')');
                counter = 0;
                cycleBuffer = new int[valArr.length];
            } // if

            // Wenn die tmp-Liste nicht leer ist, dann wird sie in der
            // CycleListe abgesichert.
            if (tmpCycle.size() > 0) {
                cyclenListe.add(tmpCycle);
            }

        } // for

        return sb.toString();
    }

    public TypeMap<Integer, Integer> cycleType() {

        if (nap) {
            System.out.println("NaP!");
        }

        // erstelle alle cycles
        this.toCycleString();
        //TreeMap erstellen, Key als Basis und Value für den Exponent
        TypeMap<Integer, Integer> retMap = new TypeMap<Integer, Integer>();
        int tmpIndex = 0;

        for (int i = 0; i < this.cyclenListe.size(); i++) {
            // hole cycle länge und sicher sie in tmpIndex ab
            tmpIndex = cyclenListe.get(i).size();

            //Wenn die Cycle Länge vorhanden ist, dann....
            if (retMap.containsKey(tmpIndex)) {
                //erhöhe Value um 1 (Exponent)
                retMap.put(tmpIndex, (retMap.get(tmpIndex)) + 1);
            } else {
                //Füge neue Key (Basis) hinzu
                retMap.put(tmpIndex, 1);
            }

        }

        return retMap;

    }


    /**
     * berrechnet die order einer Permutation
     */
    public int order(){
        this.toCycleString();
        Liste<Liste<Integer>> list = this.cyclenListe;
        Liste<Integer> temp = new Liste<Integer>();
        for(int i = 0; i < list.size(); i++){
            temp.add(list.get(i).size());
        }
        return calckgv(temp);
    }


    /**
     * berrechnet das kleinste gemeinsame vielfache des Arrays
     * @param numbers
     * @return
     */
    private int calckgv(ArrayList<Integer> numbers) {
        if(numbers == null){
            throw new NullPointerException();
        }

        int kgv = 1;
        int exp = 0;
        int n = 2;
        int count = 0;

        while(numbers.size() > 0){
            for(int i = 0; i < numbers.size(); i++){
                while(numbers.get(i) % n == 0){
                    numbers.set(i, numbers.get(i) / n);
                    count++;
                }
                if(count > exp){
                    exp = count;
                }
                count = 0;
                if(numbers.get(i) < 2){
                    numbers.remove(i);
                    i--;
                }
            }
            kgv *= Math.pow(n, exp);
            n++;
            exp = 0;
        }
        return kgv;
    }


    public Permutation pow(int exp){
        if(exp == 0){
            return null;
        }
        int order = order();
        Permutation p = new PermutationImplementation(this.valArr);
        exp = (order + ((exp - 1) % order)) % order;
        for(int i = 0; i < exp; i++){
            p = p.composition(this);
        }
        return p;
    }

}

// ToString Methoden von ArrayList Redefinierten

class Liste<E> extends ArrayList<E> {

    @Override
    public String toString() {

        StringBuilder ret = new StringBuilder();

        ret.append("(");

        for (E index : this) {
            ret.append(index + " ");
        }

        ret.deleteCharAt(ret.length() - 1);

        return ret.append(")").toString();

    }
}

// Redifinierung der toString-Methode der TreeMap
class TypeMap<K, V> extends TreeMap<K, V> {
    @Override
    public String toString() {

        StringBuilder ret = new StringBuilder();

        ret.append("(");

        for (int i = 1; i <= this.size(); i++) {

            ret.append(this.keySet().toArray(new Integer[this.size()])[i - 1].toString()
                    + Util.parseExp(this.get(this.keySet().toArray(new Integer[this.size()])[i - 1]).toString())
                    + " ");
        }

        ret.deleteCharAt(ret.length() - 1);

        return ret.append(")").toString();

    }
}