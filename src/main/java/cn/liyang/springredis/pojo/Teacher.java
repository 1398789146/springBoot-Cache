package cn.liyang.springredis.pojo;


import java.util.List;

public class Teacher {

  private long id;
  private String name;
  private String className;
  private List<Student> students;

  @Override
  public String toString () {
    return "Teacher{" + "id=" + id + ", name='" + name + '\'' + ", className='" + className + '\'' + ", students=" + students + '}';
  }

  public List<Student> getStudents () {
    return students;
  }

  public void setStudents (List<Student> students) {
    this.students = students;
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


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

}