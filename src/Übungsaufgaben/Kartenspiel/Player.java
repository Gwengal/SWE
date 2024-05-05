package Übungsaufgaben.Kartenspiel;

public class Player {
    private String _sName;
    private Stack<Card> _oStack;

    /**
     * Konstruktor
     * 
     * @param sName
     */
    public Player(String sName) {
        this._sName = sName;
        this._oStack = new Stack<Card>(Card.MAXCARDS);
    }

    /**
     * Getter für den Stack
     * 
     * @return
     */
    public Stack<Card> getStack(){
        return this._oStack;
    }

    @Override
    public String toString() {
        return this._sName;
    }
}
