package com.library.Book.Library.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.Book.Library.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="users")
@Data
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "UserRole default USER")
    private UserRole role;

    public User(String firstName, String lastName, Date dateOfBirth, String email, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
