package ga.alili.register;

public class RequestForm {
    private String name;
    private String surname;
    private String student_id;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", student_id='" + student_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
