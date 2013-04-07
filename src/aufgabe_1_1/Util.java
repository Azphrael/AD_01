package aufgabe_1_1;

/**
 * Wenn ihr was an dem Programm aendert, vergesst nicht die Versionsnummer
 * irgendwie zu aendern.
 * 
 * @author Gruppe 3
 * @version 1.00
 */

public class Util {
    
    // Hilfsmethode um uebergebene ints auf doppelte Eintraege zu pruefen
    public static boolean checkForMultipleNumber(int[] numbers) {

        int start = 0;

        do {
            for (int i = start + 1; i < numbers.length; i++) {
                if (numbers[start] == numbers[i]) {
                    return true;
                }
            }

            start++;

        } while (start < numbers.length - 1);

        return false;
    }

    public static boolean checkForGaps(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers.length) {
                return true;
            }
        }

        return false;
    }

    public static int calculateFaculty(int val) {

        int fakultaet = 1;

        for (int zahl = 1; zahl <= val; zahl++) {
            fakultaet = fakultaet * zahl;
        }

        return fakultaet;
    }

    public static void exchangeInt(int[] arr, int index1, int index2) {

        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static String parseExp(String exp) {

        char[] expStrings = {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};
        StringBuffer ret = new StringBuffer();
        if (exp.length() == 1 && exp.equals("1")) {
            return "";
        }
        for (int i = 0; i < exp.length(); i++) {
            ret.append(expStrings[Integer.parseInt(exp.substring(i, i+1))]);
        }
        return ret.toString();
    }
}
