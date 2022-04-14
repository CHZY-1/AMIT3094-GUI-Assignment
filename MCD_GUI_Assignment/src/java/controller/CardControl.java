package controller;
 
import model.da.CardDA;
import model.domain.Card;

public class CardControl {

    private CardDA cardDA;

    public CardControl() {
        cardDA = new CardDA();
    }

    public Card selectRecord(String CardNo) {
        return cardDA.getRecord(CardNo); 
    }

    public boolean insertRecord(Card card) {
        return cardDA.addRecord(card); 
    }

    public void updateRecord(Card card) {
        cardDA.updateRecord(card); 
    }

    public void deleteRecord(String CardNo) {
        cardDA.deleteRecord(CardNo); 
    }
}



