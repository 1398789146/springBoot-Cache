package cn.liyang.springredis.pojo;


import java.io.Serializable;

public class Employee implements Serializable {

  private long id;
  private String yuangongname;
  private String word;
  private long lineManagerId;
  private java.sql.Timestamp entryTime;
  private long wage;
  private long bonus;
  private long bumenTableId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getYuangongname() {
    return yuangongname;
  }

  public void setYuangongname(String yuangongname) {
    this.yuangongname = yuangongname;
  }


  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }


  public long getLineManagerId() {
    return lineManagerId;
  }

  public void setLineManagerId(long lineManagerId) {
    this.lineManagerId = lineManagerId;
  }


  public java.sql.Timestamp getEntryTime() {
    return entryTime;
  }

  public void setEntryTime(java.sql.Timestamp entryTime) {
    this.entryTime = entryTime;
  }


  public long getWage() {
    return wage;
  }

  public void setWage(long wage) {
    this.wage = wage;
  }


  public long getBonus() {
    return bonus;
  }

  public void setBonus(long bonus) {
    this.bonus = bonus;
  }


  public long getBumenTableId() {
    return bumenTableId;
  }

  public void setBumenTableId(long bumenTableId) {
    this.bumenTableId = bumenTableId;
  }

  @Override
  public String toString () {
    return "EmployeeMapper{" + "id=" + id + ", yuangongname='" + yuangongname + '\'' + ", word='" + word + '\'' + ", lineManagerId=" + lineManagerId + ", entryTime=" + entryTime + ", wage=" + wage + ", bonus=" + bonus + ", bumenTableId=" + bumenTableId + '}';
  }
}
