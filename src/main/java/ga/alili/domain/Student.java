package ga.alili.domain;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private String surname;
    private int point;

//    public Student(long id, String name, String surname, int point) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.point = point;
//
//    }
//
//    public Student() {
//        this(0, "", "", 0);
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getPoint() {
//        return point;
//    }
//
//    public void setPoint(int point) {
//        this.point = point;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", point='" + point + '\'' +
//                '}';
//    }
}
