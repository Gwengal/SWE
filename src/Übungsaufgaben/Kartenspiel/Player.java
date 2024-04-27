package Übungsaufgaben.Kartenspiel;

public class Player {
    private String _sName;
    private Stack<Card> _oStack;

    public Player(String sName, Stack<Card> oStack){
        this._sName = sName;
        this._oStack = oStack;
    }    
}
