package cn.liyang.springredis.pojo;


import java.io.Serializable;

public class User implements Serializable {

  private long id;
  private String userName;
  private String userAddress;
  private long userAge;
  private Order order;

  @Override
  public String toString () {
    return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", userAddress='" + userAddress + '\'' + ", userAge=" + userAge + ", order=" + order + '}';
  }

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public String getUserName () {
    return userName;
  }

  public void setUserName (String userName) {
    this.userName = userName;
  }

  public String getUserAddress () {
    return userAddress;
  }

  public void setUserAddress (String userAddress) {
    this.userAddress = userAddress;
  }

  public long getUserAge () {
    return userAge;
  }

  public void setUserAge (long userAge) {
    this.userAge = userAge;
  }

  public Order getOrder () {
    return order;
  }

  public void setOrder (Order order) {
    this.order = order;
  }
}
