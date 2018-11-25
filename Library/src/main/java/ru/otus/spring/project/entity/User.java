package ru.otus.spring.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "spring_project_otus", catalog = "")
public class User {

    private Long id;
    private String userName;
    private String password;
    private String role;

    @Id
    @Column(name = "userid")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
