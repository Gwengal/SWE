package Übungsaufgaben.Kartenspiel;

public class Player {
    private String _sName;
    private Stack<Card> _oStack;

    public Player(String sName, Stack<Card> oStack) {
        this._sName = sName;
        this._oStack = oStack;
    }

    /**
     * Getter für den Stack
     * 
     * @return
     */
    public Stack<Card> getStack() {
        return this._oStack;
    }

    /**
     * Getter für Name
     * 
     * @return
     */
    public String getName() {
        return this._sName;
    }

    @Override
    public String toString() {
        return this._sName;
    }
}
