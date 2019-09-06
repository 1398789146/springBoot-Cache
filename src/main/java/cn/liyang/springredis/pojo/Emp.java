package cn.liyang.springredis.pojo;


public class Emp {

  private long bumenTableid;
  private String bumenTablename;
  private String bumenTableaddress;


  public long getBumenTableid() {
    return bumenTableid;
  }

  public void setBumenTableid(long bumenTableid) {
    this.bumenTableid = bumenTableid;
  }


  public String getBumenTablename() {
    return bumenTablename;
  }

  public void setBumenTablename(String bumenTablename) {
    this.bumenTablename = bumenTablename;
  }


  public String getBumenTableaddress() {
    return bumenTableaddress;
  }

  public void setBumenTableaddress(String bumenTableaddress) {
    this.bumenTableaddress = bumenTableaddress;
  }

  @Override
  public String toString () {
    return "Emp{" + "bumenTableid=" + bumenTableid + ", bumenTablename='" + bumenTablename + '\'' + ", bumenTableaddress='" + bumenTableaddress + '\'' + '}';
  }
}
