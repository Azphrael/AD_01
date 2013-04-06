package aufgabe_1_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;


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

    public int functionValue(int i); // Seite 5, Methode 1

    public ArrayList<Integer> cycle(int i); // Seite 5, Methode 2

    public ArrayList fixpoints(); // Seite 5, Methode 3

    public Permutation composition(Permutation p); // Seite 5, Methode 4

    public Permutation inverse(); // Seite 5, Methode 5

    public boolean equals(Object o); // Seite 5, Methode 6

    public String toString(); // Seite 7, Methode 7

    public String toCycleString(); // Seite 7, Methode 7

    public int numFixpoints();

    public TypeMap<Integer, Integer> cycleType(); // Aufgabe 1.2 Seite 3 Methode 1
}
