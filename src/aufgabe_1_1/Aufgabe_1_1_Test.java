package aufgabe_1_1;


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

    public static void getOrderTest() {
        Permutation p;

        System.out.println("Tests fuer Order :::");

        p = new PermutationImplementation(2,1,3,4,6,7,10,8,9,5);

        System.out.println(p.toCycleString());
        System.out.println(p.cycleType());
        System.out.println(p.cycle(0) + ", " + p.cycle(5));
        System.out.println(p.order());
        System.out.println(p.pow(-1));
        System.out.println(p.pow(0));
        System.out.println(p.pow(1));
        System.out.println(p.pow(2));
        System.out.println(p.pow(3));
        System.out.println(p.pow(4));
        System.out.println(p.pow(5));
        System.out.println(p.pow(10000000));
        System.out.println(p.pow(-100000));
    }

    public static void aufgabe1_2 (){
        //Hauptvariablen
        Permutation P1 = new PermutationImplementation(3,4,5,1,2);
        Permutation P5 = new PermutationImplementation(5);
        Permutation P7 = new PermutationImplementation(7);
        Permutation P10 = new PermutationImplementation(10);
        Permutation P12 = new PermutationImplementation(12);
        System.out.println(P5+"."+P7+"."+P10+"."+P12);
        System.out.println("Erwartet:S(S5,S7,S10,NaS,S12)");
        System.out.println();
        //Kein direktes verÃ¤ndern der Permutation mÃ¶glich Ã¼ber eingabe (z.B. Array) /interface eintrag fehlt
        Permutation P2 = P5.composition(new PermutationImplementation(2,4,5,1,3));

        //Im Interface keine Vararg Manipulation enthalten //alternativer versuch
        Permutation P3 = P10.composition(new PermutationImplementation(1,2).composition(new PermutationImplementation(5,6,7,10)));
        System.out.println(P1+"."+P2+"."+P3);
        System.out.println("Erwartet:(3,4,5,1,2)(2,4,5,1,3(2,1,3,4,6,7,10,8,9,5)");
        System.out.println();
        System.out.println(P1.cycleType()+"."+P2.cycleType()+"."+P3.cycleType());
        System.out.println("Erwartet:S5, S5, S10");
        System.out.println();

        System.out.println(P1.functionValue(5)+"."+P2.functionValue(4));
        System.out.println("2, 1");
        System.out.println();
        System.out.println(P1.toCycleString()+"."+P2.toCycleString()+"."+P3.toCycleString());
        System.out.println("Erwartet:(1 3 5 2 4), (1 2 4)(3 5), (1 2)(3)(4)(5 6 7 10)(8)(9)");
        System.out.println();
        System.out.println(P1.equals(new PermutationImplementation(1,3,5,2,4))+"."+P1.equals(P2));
        System.out.println("Erwartet:true, false");
        System.out.println();
        System.out.println(P3.cycle(0)+"."+P3.cycle(5));
        System.out.println("Erwartet:(1 2), (9)");
        System.out.println();
        System.out.println(P3.order());
        System.out.println("Erwartet:4");
        System.out.println();
        //Seitenumbruch Seite 4
        System.out.println(P3.cycleType());
        System.out.println("Erwartet:[1â´ 2 4])");
        System.out.println();
        //kein zwischenschritt id verfÃ¼gbar
        System.out.println(P10.cycleType());
        System.out.println("Erwartet:[1Â¹á´¼]");
        System.out.println();
        //kein zwischenschritt id verfÃ¼gbar
        System.out.println(P12.cycleType());
        System.out.println("Erwartet:[1Â¹Â²]");
        System.out.println();
    	
    	/*
    	//RÃ¼ckgaben nicht ohne weiteres kompatibel !!!??
    	Permutation P4=P10.composition(P3.cycle(0).toArray(a));
    	System.out.println(P3.cycleType());
    	System.out.println("Erwartet:[1â´ 2 4])");
    	System.out.println();
    	*/
        System.out.println(P3.fixpoints());
        System.out.println("Erwartet:List(3, 4, 8, 9)");
        System.out.println();

        System.out.println(P1.composition(P2)+"."+P2.composition(P1)+"."+(P1.composition(P2).equals(P2.composition(P1))));
        System.out.println("Erwartet:(4,1,2,3,5), (5,1,3,2,4), false");
        System.out.println();
    	/*
    	//kein zwischenschritt id verfÃ¼gbar
    	System.out.println(P1.composition(P2.composition(P3)));
    	System.out.println("Erwartet:(4,1,2,3,5)");
    	System.out.println();
    	*/
        System.out.println(P1.inverse()+"."+P1.composition(P1.inverse())+"."+P1.inverse().composition(P1));
        System.out.println("Erwartet:(4,5,1,2,3), (1,2,3,4,5), (1,2,3,4,5)");
        System.out.println();

        System.out.println(new PermutationImplementation(1,5,4,2,1)+"."+P5.composition(new PermutationImplementation(1,3,2,4,6,5)));
        System.out.println("Erwartet:NaP, NaP");
        System.out.println();

        System.out.println(P1.composition(P2).composition(P3));
        System.out.println("Erwartet:NaP");
        System.out.println();
    	/*Test ausgelassen mit java nicht mÃ¶glich
    	System.out.println(P3.fixpoints());
    	System.out.println("Erwartet:List(3, 4, 8, 9)");
    	System.out.println();
    	*/
        System.out.println(P1.composition(P2).composition(P3).cycleType());
        System.out.println("Erwartet:NaS");
        System.out.println();

        P5=P3.pow(3);
        Permutation P6 = P3.pow(10000000);
        System.out.println(P5+"."+P6+"."+P3.pow(-100000));
        System.out.println("Erwartet:(2,1,3,4,10,5,6,8,9,7), (1,2,3,4,5,6,7,8,9,10), (1,2,3,4,5,6,7,8,9,10)");
        System.out.println();

        System.out.println(P10.composition(new PermutationImplementation(1,2).composition(new PermutationImplementation(3,4).composition(new PermutationImplementation(5,6,7,11)))));
        System.out.println("Erwartet:NaP");
        System.out.println();

        Permutation err1= new PermutationImplementation(2,5,8,5,4,6,3);
        Permutation err2= new PermutationImplementation(2,5,8,5,4,6,3,1);
        Permutation err3= new PermutationImplementation(2,5,9,5,4,6,3,1);
        System.out.println(err1+"."+err2+"."+err3);
        System.out.println("Erwartet:NaP NaP NaP");
        System.out.println();
    	
    	/*Rest Statments ab println(S) nicht mehr zu realisieren, mÃ¶glichkeit zur realisierung err - Wert zur Nap Syntese*/



    }

    public static void main(String[] args) {
        //Test Aufgabe2
    	/* 
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

        Aufgabe_1_1_Test.getOrderTest();
    	 */
        //test der Aufgabe2
        Aufgabe_1_1_Test.aufgabe1_2();
    }

}