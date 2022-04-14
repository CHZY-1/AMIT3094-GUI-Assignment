package model.domain;

import java.io.Serializable;

public class Card implements Serializable{
    
    private String cardNo;
    private String cardHolderName;
    private String cardType;
    private String expiredMonth;
    private int expiredYear;
    
    public Card(){
    }

    public Card(String cardNo, String cardHolderName, String cardType, String expiredMonth, int expiredYear) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.expiredMonth = expiredMonth;
        this.expiredYear = expiredYear;
    }
    

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpiredMonth() {
        return expiredMonth;
    }

    public void setExpiredMonth(String expiredMonth) {
        this.expiredMonth = expiredMonth;
    }

    public int getExpiredYear() {
        return expiredYear;
    }

    public void setExpiredYear(int expiredYear) {
        this.expiredYear = expiredYear;
    }

    
}
