package Übungsaufgaben.Kartenspiel;

import java.util.Random;

public class Stack<t> {

    private int _iTop;
    private t[] _aStack;

    /**
     * Konstruktor
     * 
     * @param iMax
     */
    @SuppressWarnings("unchecked")
    public Stack(int iMax) {
        this._iTop = 0;
        this._aStack = (t[]) new Object[iMax];
    }

    /**
     * Konstruktor
     * 
     * @param iMax
     * @param Elements
     */
    public Stack(int iMax, t[] aElements) {
        this._iTop = aElements.length;
        this._aStack = aElements;
    }

    /**
     * Getter für den Stack
     * 
     * @return
     */
    private t[] getElements(){
        return this._aStack;
    }

    /**
     * Elemente aus dem übergebenen Array vor die Elemente
     * des bereits vorhanden Stacks einfügen
     * 
     * @param aElements
     */
    public void insert(Stack<t> oStack) {
        int iIndex = 0;
        t[] aElements = oStack.getElements();

        // Bestimmen wie weit der Stapel befüllt wurde
        for (int i = 0; i < aElements.length; i++) {
            if (aElements[i] == null) {
                break;
            }

            iIndex++;
        }

        // Elemente aus dem vorhanden Stack an das neue Array anhängen
        for (int i = 0; i < this._iTop; i++) {
            aElements[iIndex++] = this._aStack[i];
        }

        this._iTop = iIndex + 1;
        this._aStack = aElements;
    }

    /**
     * Element zum Stack hinzufügen
     * 
     * @param element
     */
    public void push(t oElement) throws Exception {
        if (this.isFull()) {
            throw new Exception(String.format("Stapel ist voll (%d/%d)!", this._iTop, this._aStack.length));
        }

        this._aStack[this._iTop++] = oElement;
    }

    /**
     * Oberstes Element des Stapels zurückgeben und
     * aus dem Stapel entfernen
     * 
     * @return
     * @throws Exception
     */
    public t pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception(String.format("Auf dem Stapel befinden sich %d Elemente!", this._iTop));
        }

        t oReturn = this._aStack[--this._iTop];
        this._aStack[this._iTop] = null;

        return oReturn;
    }

    /**
     * Prüft ob Stapel leer
     * 
     * @return
     */
    public boolean isEmpty() {
        return this._iTop == 0;
    }

    /**
     * Rückgabe Anzahl aktueller Elemente
     * 
     * @return
     */
    public int amountElements() {
        return this._iTop;
    }

    /**
     * Elemente zufällig durchsortieren (3-Wege Sortierung)
     */
    public void mix() {
        // Zufällige Sortierung überflüssig
        if (this._iTop < 2) {
            return;
        }

        Random oRandom = new Random();
        t oBuffer;
        int iShuffle1, iShuffle2;

        // Zufällige Sortierung durchführen (min 1 und max Anzahl Elemente * 2)
        for (int i = 0; i < (oRandom.nextInt(this._iTop * this._iTop) + 1); i++) {
            // Index für Shuffle1 und Shuffle2 Random bestimmen
            iShuffle1 = oRandom.nextInt(this._iTop);
            iShuffle2 = oRandom.nextInt(this._iTop);

            // Sortierung überflüssig, da Index auf gleiches Element zeigt
            if (iShuffle1 == iShuffle2) {
                continue;
            }

            // 3-Wege Sortierung durchführen
            oBuffer = this._aStack[iShuffle1];
            this._aStack[iShuffle1] = this._aStack[iShuffle2];
            this._aStack[iShuffle2] = oBuffer;
        }
    }

    /**
     * Prüft ob Stapel voll
     * 
     * @return
     */
    private boolean isFull() {
        return this._iTop == this._aStack.length;
    }
}
