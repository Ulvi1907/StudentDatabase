package ga.alili.domain;

public class Employee {
    private long id;
    private String name;
    private String surname;
    private String student_id;

    public Employee(long id, String name, String surname, String student_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.student_id = student_id;

    }

    public Employee() {
        this(0, "", "", "");
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", student_id='" + student_id + '\'' +
                '}';
    }
}
