package cn.liyang.springredis.pojo;

public class Order {

  private long id;
  private long orderNo;
  private String goods;
  private long userId;
  private User user;

  @Override
  public String toString () {
    return "Order{" + "id=" + id + ", orderNo=" + orderNo + ", goods='" + goods + '\'' + ", userId=" + userId + ", user=" + user + '}';
  }

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public long getOrderNo () {
    return orderNo;
  }

  public void setOrderNo (long orderNo) {
    this.orderNo = orderNo;
  }

  public String getGoods () {
    return goods;
  }

  public void setGoods (String goods) {
    this.goods = goods;
  }

  public long getUserId () {
    return userId;
  }

  public void setUserId (long userId) {
    this.userId = userId;
  }

  public User getUser () {
    return user;
  }

  public void setUser (User user) {
    this.user = user;
  }
}
