package aufgabe_1_1;

/**
 * Wenn ihr was an dem Programm aendert, vergesst nicht die Versionsnummer
 * irgendwie zu aendern.
 * 
 * @author Gruppe 3
 * @version 1.00
 */

interface Permutation {

    public static final int NaP = -1;
    public static final int ERROR = -2;

    public int getFunctionValue(int i); // Seite 5, Methode 1

    public String getCycle(int i); // Seite 5, Methode 2

    public String getFixpoints(); // Seite 5, Methode 3

    public Permutation getComposition(Permutation p); // Seite 5, Methode 4

    public Permutation getInverse(); // Seite 5, Methode 5

    public boolean equals(Object o); // Seite 5, Methode 6

    public String toString(); // Seite 7, Methode 7

    public String toCycleString(); // Seite 7, Methode 7

    public int numFixpoints();
}
