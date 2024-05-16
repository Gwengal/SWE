package Übungsaufgaben.Kartenspiel;

public class LostException extends Exception {

    private Player _oPlayer;

    /**
     * Konstruktor
     * 
     * @param sMessage
     * @param oPlayer
     */
    public LostException(String sMessage, Player oPlayer) {
        super(sMessage);
        this._oPlayer = oPlayer;
    }

    /**
     * Getter für das Spieler-Objekt
     * 
     * @return
     */
    public Player getPlayer() {
        return this._oPlayer;
    }
}