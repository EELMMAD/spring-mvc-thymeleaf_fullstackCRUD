package se.lexicon.fullstack.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class StudentDto {
//    @Null(message = "Id should be null")
    private int id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 40)
    private String name;
    @Email(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",flags = Pattern.Flag.CASE_INSENSITIVE,message = "Email is not valid")
    private String email;
    @NotNull(message = "Required filed")
    @Size(min = 2,max = 20,message = "Invalid course value")
    private String course;
    private LocalDate registerDate;

    public StudentDto() {
    }

    public StudentDto(int id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public StudentDto(int id, String name, String email, String course, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", course='").append(course).append('\'');
        sb.append(", registerDate=").append(registerDate);
        sb.append('}');
        return sb.toString();
    }
}
