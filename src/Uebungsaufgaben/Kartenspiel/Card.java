package Uebungsaufgaben.Kartenspiel;

enum Color {
    Heart,
    Spade,
    Cross,
    Diamonds
}

enum Value {
    two,
    three,
    four,
    five,
    six,
    seven,
    eight,
    nine,
    ten,
    Jack,
    Queen,
    King,
    Ace;

    public String numericValue() {
        String sReturnValue = "";

        switch (this) {
            case two:
                sReturnValue = "2";
                break;
            case three:
                sReturnValue = "3";
                break;
            case four:
                sReturnValue = "4";
                break;
            case five:
                sReturnValue = "5";
                break;
            case six:
                sReturnValue = "6";
                break;
            case seven:
                sReturnValue = "7";
                break;
            case eight:
                sReturnValue = "8";
                break;
            case nine:
                sReturnValue = "9";
                break;
            case ten:
                sReturnValue = "10";
                break;
            default:
                sReturnValue = this.name();
                break;
        }

        return sReturnValue;
    }
}

public class Card {
    // Farbe der Karte
    private Color _eColor;
    // Wert der Karte
    private Value _eValue;
    // Max. Anzahl mögliche Karten
    public static int MAXCARDS = Color.values().length * Value.values().length;

    /**
     * Konstruktor
     * 
     * @param eColor
     * @param eValue
     */
    public Card(Color eColor, Value eValue) {
        this._eColor = eColor;
        this._eValue = eValue;
    }

    /**
     * Getter für die Farbe
     * 
     * @return
     */
    public Color getColor() {
        return this._eColor;
    }

    /**
     * Getter für den Wert
     * 
     * @return
     */
    public String getValue() {
        return this._eValue.numericValue();
    }

    @Override
    public String toString() {
        return String.format("---> %s %s", this.getColor(), this.getValue());
    }

    /**
     * Gibt alle möglichen Kartenkombinationen zurück
     * 
     * @return
     */
    public static Card[] allCards() {
        int iCounter = 0;
        Color[] aColors = Color.values();
        Value[] aValues = Value.values();
        Card[] aCards = new Card[Card.MAXCARDS];

        for (int i = 0; i < aColors.length; i++) {
            for (int j = 0; j < aValues.length; j++) {
                aCards[iCounter++] = new Card(aColors[i], aValues[j]);
            }
        }

        return aCards;
    }

    /**
     * Vergleicht die Kartenwerte
     * 
     * @param oCard
     * @return
     */
    public int compare(Card oCard) {
        return this._eValue.ordinal() - oCard._eValue.ordinal();
    }

}