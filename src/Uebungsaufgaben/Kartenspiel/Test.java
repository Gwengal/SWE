package Uebungsaufgaben.Kartenspiel;

public class Test {
    public static void main(String[] args) {
        Card[] aCards = Card.allCards();
        for (Card card : aCards) {
            System.out.println(card);
        }
    }
}
