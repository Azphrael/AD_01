package aufgabe_1_1;

/**
 * Wenn ihr was an dem Programm aendert, vergesst nicht die Versionsnummer
 * irgendwie zu aendern.
 * 
 * @author Gruppe 3
 * @version 1.00
 */

class PermutationGroupImplementation implements PermutationGroup {

    private Permutation[] permArr;
    private int testPermarrCounter = 0;
    private boolean nas = false;

    public PermutationGroupImplementation(int count) {

        int[] tmpVal; // enthaelt zu Beginn die Id, Werte werden fuer weitere Permutationen getauscht.

        // Ist ein Korrekter Wert uebergeben worden?
        if (count < 1) {
            // Nein
            System.out.println("Fehler: Wert fuer Konstruktor PermutationGroupImplementation < 1!: NaS");

            nas = true;

            // Ist ein Wert groesser 1 uebergeben worden?
        } else if (count == 1) {
            // Nein
            permArr = new PermutationImplementation[1];
            permArr[0] = new PermutationImplementation(1);

        } else {
            // Ja

            // Laenge der Id
            tmpVal = new int[count];

            // Wert der Id
            for (int i = 0; i < tmpVal.length; i++) {
                tmpVal[i] = i + 1;
            }

            permArr = new PermutationImplementation[Util.calculateFaculty(count)];

            calculatePermutation(tmpVal, tmpVal.length - 1);
        }
    }

    public boolean contains(Permutation test) {

        for (int i = 0; i < permArr.length; i++) {
            if (test.equals(permArr[i])) {
                return true;
            }
        }
        return false;
    }

    // Rekursive Methode zum erzeugen aller Permutationen
    private void calculatePermutation(int[] p, int endIndex) {

        if (endIndex == 0) {
            permArr[testPermarrCounter] = new PermutationImplementation(p);
            testPermarrCounter++;

        } else {
            calculatePermutation(p, endIndex - 1);

            for (int i = 0; i < endIndex; i++) {
                Util.exchangeInt(p, i, endIndex);
                calculatePermutation(p, endIndex - 1);
                Util.exchangeInt(p, i, endIndex);
            }
        }
    }

    @Override
    public String toString() {
        if (nas) {
            return "toString(): NaS!";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < permArr.length; i++) {
            sb.append(permArr[i].toString());
        }

        return sb.toString();
    }
}
