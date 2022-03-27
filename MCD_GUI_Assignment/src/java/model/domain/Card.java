package model.domain;

import java.io.Serializable;

public class Card implements Serializable{
    
    private String Card_Holder_Name;
    private String Card_Type;
    private float Expired_Month;
    private float Expired_Year;
    
    public Card(){
    }

    public Card(String Card_Holder_Name, String Card_Type, float Expired_Month, float Expired_Year) {
        this.Card_Holder_Name = Card_Holder_Name;
        this.Card_Type = Card_Type;
        this.Expired_Month = Expired_Month;
        this.Expired_Year = Expired_Year;
    }

    public String getCard_Holder_Name() {
        return Card_Holder_Name;
    }

    public void setCard_Holder_Name(String Card_Holder_Name) {
        this.Card_Holder_Name = Card_Holder_Name;
    }

    public String getCard_Type() {
        return Card_Type;
    }

    public void setCard_Type(String Card_Type) {
        this.Card_Type = Card_Type;
    }

    public float getExpired_Month() {
        return Expired_Month;
    }

    public void setExpired_Month(float Expired_Month) {
        this.Expired_Month = Expired_Month;
    }

    public float getExpired_Year() {
        return Expired_Year;
    }

    public void setExpired_Year(float Expired_Year) {
        this.Expired_Year = Expired_Year;
    }
}
