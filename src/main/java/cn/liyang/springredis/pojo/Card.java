package cn.liyang.springredis.pojo;


import java.io.Serializable;

public class Card implements Serializable {

  private long id;
  private long cardId;
  private String cardName;

  @Override
  public String toString () {
    return "Card{" + "id=" + id + ", cardId=" + cardId + ", cardName='" + cardName + '\'' + '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCardId() {
    return cardId;
  }

  public void setCardId(long cardId) {
    this.cardId = cardId;
  }


  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

}
