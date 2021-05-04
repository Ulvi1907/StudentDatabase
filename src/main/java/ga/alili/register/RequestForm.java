package ga.alili.register;

import javax.validation.constraints.*;

public class RequestForm {
    @NotBlank
    @Size(min = 3 , max = 20)
    private String name;

    @NotBlank
    @Size(min = 3 , max = 20)
    private String surname;

    @NotBlank
    @Size(min = 7 , max = 10)
    private String student_id;

    @NotBlank
    @Size(min = 8 , max = 20)
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
