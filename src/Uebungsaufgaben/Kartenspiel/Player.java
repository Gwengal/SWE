package Uebungsaufgaben.Kartenspiel;

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
    public Stack<Card> getStack() {
        return this._oStack;
    }

    /**
     * Karte aus dem Stapel ziehen und spielen
     * 
     * @return
     * @throws Exception
     */
    public Card draw() throws LostException {
        try {
            Card oCard = this._oStack.pop();
            System.out.printf("%s von %s\n", oCard, this);

            return oCard;
        } catch (Exception e) {
            throw new LostException(String.format("\n%s hat keine Karten mehr.", this), this);
        }
    }

    /**
     * Ausgabe Anzahl Karten des Spielers
     * 
     * @throws Exception
     */
    public void amountCards() throws LostException {
        System.out.printf("%s: Karten: %d\n", this, this._oStack.amountElements());

        if (this._oStack.amountElements() == 0) {
            throw new LostException(String.format("\n%s hat keine Karten mehr!", this), this);
        }
    }

    @Override
    public String toString() {
        return this._sName;
    }
}