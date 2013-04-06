
<!-- saved from url=(0229)https://s3.amazonaws.com/data.teamlab.com/15/82/31/forum/22809/34460/f8993294-eb73-469f-87f8-40437ff96025/aufgabe_1_1_test.java?AWSAccessKeyId=AKIAJ6F26BFDPKHVPHIA&Expires=1365276756&Signature=YxUxdIF%2Bqz19%2Btl%2FACpd0qJwUIc%3D -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></head><body><pre style="word-wrap: break-word; white-space: pre-wrap;">package aufgabe_1_1;


/**
 * Wenn ihr was an dem Programm aendert, vergesst nicht die Versionsnummer
 * irgendwie zu aendern.
 * 
 * @author Gruppe 3
 * @version 1.00
 */

public class Aufgabe_1_1_Test {

	public static void toStringTest() {

		Permutation p = new PermutationImplementation(1, 2, 3, 4, 5, 6);

		System.out.println("\nStarte toStringTest()");

		System.out
				.print("Ausgabe einer Permutation mit den Werten 1,2,3,4,5,6: ");
		System.out.println(p);
	}

	public static void toCycleStringTest() {
		Permutation p;

		System.out.println("\nStarte toCycleStringTest()");

		System.out
				.print("Ausgabe einer Permutation mit den Werten 1,2,3,4,5,6: ");
		p = new PermutationImplementation(1, 2, 3, 4, 5, 6);
		System.out.println(p.toCycleString());

		System.out.print("Ausgabe einer Permutation mit den Werten 1: ");
		p = new PermutationImplementation(1);
		System.out.println(p.toCycleString());

		System.out.print("Ausgabe einer Permutation mit den Werten 2,1,3: ");
		p = new PermutationImplementation(2, 1, 3);
		System.out.println(p.toCycleString());

		System.out.print("Ausgabe einer Permutation mit den Werten 3,2,1: ");
		p = new PermutationImplementation(3, 2, 1);
		System.out.println(p.toCycleString());
	}

	public static void getCycleTest() {
		try{
		Permutation p = new PermutationImplementation(1, 3, 2, 5, 4, 6);

		System.out.println("\nStarte getCycleTest()");

		System.out.print("Zeige Cycle 1 von (1,3,2,5,4,6): ");
        
		System.out.println(p.cycle(1));
		System.out.print("Zeige Cycle 2 von (1,3,2,5,4,6): ");
		System.out.println(p.cycle(2));

		System.out.print("Zeige Cycle 3 von (1,3,2,5,4,6): ");
		System.out.println(p.cycle(3));

		System.out.print("Zeige Cycle 4 von (1,3,2,5,4,6): ");
		System.out.println(p.cycle(4));

		System.out.print("Zeige Cycle 5 von (1,3,2,5,4,6): ");
		System.out.println(p.cycle(5));
		
		}
		catch(IndexOutOfBoundsException e)
	    {			
	      System.out.print("Keine weiteren cyclen vorhanden!!!");	
	    }
	}

	public static void equalsTest() {
		Permutation p1 = new PermutationImplementation(1, 2, 3, 4, 5, 6);
		Permutation p2 = new PermutationImplementation(1, 2, 3, 4, 5, 6);
		String s = "test";

		System.out.println("\nStarte equalsTest()");

		System.out.print("Vergleich mit String: ");
		System.out.println(p1.equals(s));

		System.out
				.print("Vergleich mit Permutation unterschiedlicher Laenge: ");
		System.out.println(p1.equals(p2));

		System.out.print("Vergleich mit Permutation gleicher Laenge "
				+ "und unterschiedlichem Inhalt: ");
		p2 = new PermutationImplementation(1, 2, 3, 4, 6, 5);
		System.out.println(p1.equals(p2));

		System.out.print("Vergleich mit Permutation gleicher Laenge "
				+ "und gleichem Inhalt: ");
		p2 = new PermutationImplementation(1, 2, 3, 4, 5, 6);
		System.out.println(p1.equals(p2));
	}

	public static void getInverseTest() {
		Permutation p = new PermutationImplementation(2, 4, 5, 1, 3);

		System.out.println("\nStarte getInverseTest()");

		System.out.print("Zeige inverse Permutation von (2,4,5,1,3): ");
		System.out.println(p.inverse());

		System.out.print("Zeige davon inverse Permutation: ");
		System.out.println(p.inverse().inverse());
	}

	public static void getCompositionTest() {
		Permutation p1 = new PermutationImplementation(2, 4, 5, 1, 3);
		Permutation p2 = new PermutationImplementation(3, 5, 1, 4, 2);

		System.out.println("\nStarte getCompositionTest()");

		System.out.print("Zeige Kompostion von (2,4,5,1,3) mit (3,5,1,4,2): ");
		System.out.println(p1.composition(p2));

		System.out
				.print("Zeige Kompostion von (2,4,5,1,3) mit Identitaet (1,2,3,4,5): ");
		p2 = new PermutationImplementation(1, 2, 3, 4, 5);
		System.out.println(p1.composition(p2));

		System.out.print("Zeige Komposition von (2,4,5,1,3) mit Inverse: ");
		System.out.println(p1.composition(p1.inverse()));

		System.out
				.print("Zeige Kompostion von (2,4,5,1,3) mit Permutation ungleicher Laenge (3,5,1,4,2,6): ");
		p2 = new PermutationImplementation(3, 5, 1, 4, 2, 6);
		System.out.println(p1.composition(p2));
	}

	public static void testForAssociativity() {
		Permutation p1 = new PermutationImplementation(1, 3, 2);
		Permutation p2 = new PermutationImplementation(2, 3, 1);
		Permutation p3 = new PermutationImplementation(3, 2, 1);
		Permutation pTmp;

		System.out.println("\nStarte testForAssociativity()");

		System.out.print("Komponiere ((3,2,1) o (2,3,1)) o (1,3,2): ");
		pTmp = p2.composition(p3);
		System.out.println(p1.composition(pTmp));

		System.out.print("Komponiere (3,2,1) o ((2,3,1) o (1,3,2)): ");
		pTmp = p1.composition(p2);
		System.out.println(pTmp.composition(p3));
	}

	public static void checkForMultipleNumberTest() {
		Permutation p;

		System.out.println("\nStarte testCheckForMultipleNumber()");

		System.out
				.print("Erstelle Permutation ohne doppelte Werte (1,2,3,4,5,6): ");
		p = new PermutationImplementation(1, 2, 3, 4, 5, 6);
		System.out.println(p);

		System.out.print("Erstelle kurze Permutation (1): ");
		p = new PermutationImplementation(1);
		System.out.println(p);

		System.out
				.print("Erstelle lange Permutation (1,2,3,4,5,6,7,8,9,10,11): ");
		p = new PermutationImplementation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		System.out.println(p);

		System.out
				.print("Erstelle Permutation mit einem doppelten Wert (1,2,3,4,5,6,7,8,9,10,1): ");
		p = new PermutationImplementation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1);
		System.out.println(p);
	}

	public static void calculateFacultyTest() {
		System.out.println("\nStarte testCalculateFaculty()");

		System.out.print("Berechne Fakultaet von 3: ");
		System.out.println(Util.calculateFaculty(3));
	}

	public static void PermutationGroupConstruktorTest() {
		PermutationGroup pgrp;

		System.out.println("\nPermutationGroupConstruktorTest()");

		System.out.print("Erstelle PermutationGroup, Laenge 1: ");
		pgrp = new PermutationGroupImplementation(1);
		System.out.println(pgrp);

		System.out.print("Erstelle PermutationGroup, Laenge 3: ");
		pgrp = new PermutationGroupImplementation(3);
		System.out.println(pgrp);

		System.out.print("Erstelle PermutationGroup, Laenge -1: ");
		pgrp = new PermutationGroupImplementation(-1);
		System.out.println(pgrp);
	}

	public static void getFixpointsTest() {
		Permutation p;

		System.out.println("\ntestGetFixpoints()");

		System.out.print("Zeige Fixpunkte von Permutation (1): ");
		p = new PermutationImplementation(1);
		System.out.println(p.fixpoints());

		System.out.print("Zeige Fixpunkte von Permutation (1,2,3,4): ");
		p = new PermutationImplementation(1, 2, 3, 4);
		System.out.println(p.fixpoints());

		System.out.print("Zeige Fixpunkte von Permutation (3,5,1,4,2): ");
		p = new PermutationImplementation(3, 5, 1, 4, 2);
		System.out.println(p.fixpoints());
	}

	
public static void main(String[] args) {
		
		System.out.println("\n::: Test fuer Util :::");
		Aufgabe_1_1_Test.checkForMultipleNumberTest();
		Aufgabe_1_1_Test.calculateFacultyTest();

		System.out.println("\n::: Tests fuer Permutation :::");
		Aufgabe_1_1_Test.toStringTest();
		Aufgabe_1_1_Test.toCycleStringTest();
		Aufgabe_1_1_Test.getCycleTest();
		Aufgabe_1_1_Test.equalsTest();
		Aufgabe_1_1_Test.getInverseTest();
		Aufgabe_1_1_Test.getCompositionTest();
		Aufgabe_1_1_Test.testForAssociativity();
		Aufgabe_1_1_Test.getFixpointsTest();
		
		System.out.println("\n::: Tests fuer PermutationGroup :::");
		Aufgabe_1_1_Test.PermutationGroupConstruktorTest();

		PermutationGroup pgrp = new PermutationGroupImplementation(3);
		Permutation p = new PermutationImplementation(2, 1, 3);
		System.out.println(pgrp.contains(p));

		p = new PermutationImplementation(2, 1, 3, 4);
		System.out.println(pgrp.contains(p));

		System.out.println(p.numFixpoints()); 
		
	}
}</pre></body></html>