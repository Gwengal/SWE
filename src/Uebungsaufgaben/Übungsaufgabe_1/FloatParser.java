package Uebungsaufgaben.Übungsaufgabe_1;

import java.util.Scanner;

public class FloatParser {
    public static void main(String[] args) {
        String sInput = "";
        // String sT1 = " \t-123.456f"; // erfolgreich
        // String sT2 = "-.45A3"; // erfolgreich
        // String sT3 = "123.A"; // erfolgreich
        // String sT4 = "ABC"; // erfolgreich
        // String sT5 = "-0.123A"; // erfolgreich
        // String sT6 = "-123.0456f"; // erfolgreich
        Scanner oScan = new Scanner(System.in);

        while (true) {
            System.out.print("Bitte Text erfassen: ");
            sInput = oScan.nextLine();

            // Schleife verlassen
            if (sInput.contains("y") || sInput.contains("Y")) {
                break;
            }

            try {
                FloatParser.parseMyFloat(sInput);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("\n\n\n");
        }

        oScan.close();
    }

    /**
     * Float-Zahl aus dem String auslesen
     * 1. Ermittlung der ersten Zahl aus einem String
     * 2. Vorkommazahl aus dem übergebenen String konvertieren zum float
     * 3. Nachkommazahl aus dem übergebenen String konvertieren zum float
     * 4. Aufsummierung Vorkommastellen mit Nachkommastellen
     * 5. Ggf. Negation durchführen (* -1)
     * 
     * @param sInput
     * @throws Exception
     */
    private static float parseMyFloat(String sInput) throws Exception {
        // Deklaration
        boolean bNeg = false;
        float fReturn = 0.0f;

        System.out.printf("String zu Float! -> Umwandlung für [%s]:\n", sInput);

        // Ermittlung der ersten Zahl aus einem String
        String[] aNumber = FloatParser.getFirstNumber(sInput);

        // String zum Float umwandeln
        for (int i = 0; i < aNumber.length; i++) {
            // Vorkommastellen zum float umwandeln und aufaddieren
            if (i == 0) {
                // String beginnt mit einem Vorzeichen
                // -> Bei '-' Kennzeichen setzen, dass Negation durchgeführt werden soll
                // -> Vorzeichen abschneiden
                if (aNumber[i].charAt(0) == '+' || aNumber[i].charAt(0) == '-') {
                    bNeg = (aNumber[i].charAt(0) == '-' ? true : false);
                    aNumber[i] = aNumber[i].substring(1);
                }

                fReturn += FloatParser.getPreDec(aNumber[i]);
            }
            // Nachkommastellen zum float umwandeln und aufaddieren
            else {
                fReturn += FloatParser.getDec(aNumber[i]);
            }
        }

        // Negation durchführen -> *-1
        if (bNeg) {
            fReturn *= -1;
        }

        System.out.printf("Umandlung erfolgreich durchgeführt. Ergebnis = [%f]", fReturn);

        return fReturn;
    }

    /**
     * Vorkommazahl aus dem übergebenen String konvertieren zum float
     * 
     * @param sPreDec
     * @throws Exception
     * @return
     */
    private static float getPreDec(String sPreDec) throws Exception {
        // Deklaration
        int iCurrValue = 0,
                iSum = 0;
        float fPreDec = 0.0f;

        // String-Objekt ist null
        // -> Logik nicht durchlaufen
        if (sPreDec == null || sPreDec == "") {
            return fPreDec;
        }
        ;

        // Umwandlung in einen Int-Wert
        for (int i = 0; i < sPreDec.length(); i++) {
            iCurrValue = FloatParser.charToInt(sPreDec.charAt(i));
            iCurrValue *= FloatParser.pow(10, (sPreDec.length() - (i + 1)));
            iSum += iCurrValue;
        }

        // Konvertierung des Ints zum Float
        fPreDec = (float) iSum;

        System.out.printf(" Vorkommawert: %f\n", fPreDec);

        return fPreDec;
    }

    /**
     * Nachkommazahl aus dem übergebenen String konvertieren zum float
     * 
     * @param sDec
     * @throws Exception
     * @return
     */
    private static float getDec(String sDec) throws Exception {
        // Deklaration
        int iCurrValue = 0,
                iDiv = 1,
                iSum = 0;
        float fDec = 0.0f;

        // String-Objekt ist null
        // -> Logik nicht durchlaufen
        if (sDec == null || sDec == "") {
            return fDec;
        }
        ;

        // Umwandlung in einen Int-Wert
        for (int i = 0; i < sDec.length(); i++) {
            iDiv *= 10;
            iCurrValue = FloatParser.charToInt(sDec.charAt(i));
            iCurrValue *= FloatParser.pow(10, (sDec.length() - (i + 1)));
            iSum += iCurrValue;
        }

        // Konvertierung des Ints zum Float
        fDec = (float) iSum;

        // Auf Nachkommastellen verschieben
        fDec /= iDiv;

        System.out.printf(" Nachkommawert: %f\n", fDec);

        return fDec;
    }

    /**
     * Potenz zu übergebenen Werten berechnen
     * 
     * @param iVal
     * @param iPow
     * @return
     */
    private static int pow(int iVal, int iPow) {
        if (iPow == 0) {
            return 1;
        }

        return iVal * FloatParser.pow(iVal, iPow - 1);
    }

    /**
     * Umwandlung eines Zeichens zu einer Ziffer
     * 
     * @param cInp
     * @return
     * @throws Exception
     */
    private static int charToInt(char cInp) throws Exception {
        int iReturn = 0;

        switch (cInp) {
            case '0':
                iReturn = 0;
                break;
            case '1':
                iReturn = 1;
                break;
            case '2':
                iReturn = 2;
                break;
            case '3':
                iReturn = 3;
                break;
            case '4':
                iReturn = 4;
                break;
            case '5':
                iReturn = 5;
                break;
            case '6':
                iReturn = 6;
                break;
            case '7':
                iReturn = 7;
                break;
            case '8':
                iReturn = 8;
                break;
            case '9':
                iReturn = 9;
                break;
            default:
                throw new Exception(String.format("Bei dem Zeichen [%s] handelt es sich nicht um eine Ziffer!", cInp));
        }

        return iReturn;
    }

    /**
     * Ermittlung der ersten Zahl aus einem String
     * 
     * @param sInput
     * @return
     * @throws Exception
     */
    private static String[] getFirstNumber(String sInput) throws Exception {
        // Deklaration
        char cCur;
        int iFillCorrString = 0,
                iCount = 0;
        String[] aNumber = new String[2]; // -> Vorkomma- und Nachkommastellen getrennt darstellen

        // Vorkomma- und Nachkommastellen auf ein String-Array aufteilen
        for (int i = 0; i < sInput.length(); i++) {
            cCur = sInput.charAt(i);

            // String beginnt mit SPACE/TABULATOR
            // => Nächstes Zeichen des Strings betrachten
            if (iCount == 0 && (cCur == ' ' || cCur == '\t')) {
                continue;
            }

            // String beginnt nicht mit einer Zahler oder +/-/,/.
            // -> Fehlermeldung schmeißen
            if (iCount == 0 && !(Character.isDigit(cCur) || cCur == '+' || cCur == '-' || cCur == '.' || cCur == ',')) {
                throw new Exception(
                        String.format("ERROR:\nString [%s] startet nicht mit einer Zahl oder [+/-/,/.]!", sInput));
            }
            // Schleife verlassen, da ein Zeichen gekommen ist, welches nicht zu einem
            // float konvertiert werden könnte
            else if (iCount > 0 && !(Character.isDigit(cCur) || cCur == '.' || cCur == ',')) {
                break;
            }
            // Aktuell Zeichen ist ein ,/.
            // Zähler um 1 erhöhen, damit nun der String für die Nachkommastellen befüllt
            // wird
            else if (cCur == ',' || cCur == '.') {
                iFillCorrString += 1;
                iCount += 1;
                continue;
            }

            iCount += 1;
            aNumber[iFillCorrString] = (aNumber[iFillCorrString] == null ? "" + cCur : aNumber[iFillCorrString] + cCur);
        }

        return aNumber;
    }
}