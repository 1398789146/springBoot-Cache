package cn.liyang.springredis.pojo;


public class Student {

  private long id;
  private String name;
  private long teacherId;
  private String className;
  private long cardType;
  private Card card;

  @Override
  public String toString () {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + ", teacherId=" + teacherId + ", className='" + className + '\'' + ", cardType=" + cardType + ", card=" + card + '}';
  }

  public Card getCard () {
    return card;
  }

  public void setCard (Card card) {
    this.card = card;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(long teacherId) {
    this.teacherId = teacherId;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public long getCardType() {
    return cardType;
  }

  public void setCardType(long cardType) {
    this.cardType = cardType;
  }

}
