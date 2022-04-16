// Author:Sew Min Yan
// Description:A Java Class that allow  insert user’s card details into database 
package controller.Control;
 
import model.da.CardDA;
import model.domain.Card;

public class CardController {

    private CardDA cardDA;

    public CardController() {
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



