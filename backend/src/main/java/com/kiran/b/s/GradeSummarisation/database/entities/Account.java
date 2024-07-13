package com.kiran.b.s.GradeSummarisation.database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {

    //email + clientReg + oauthId = unique identifier to find userAccountId

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userAccountId;
    @Column(nullable = false)
    private int oauthId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String clientReg;

    @OneToMany(mappedBy = "userAccountId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Course> courses;

    public Account() {
    }

    public Account(int userAccountId, int oauthId, String email, String clientReg, List<Course> courses) {
        this.userAccountId = userAccountId;
        this.oauthId = oauthId;
        this.email = email;
        this.clientReg = clientReg;
        this.courses = courses;
    }

    public Account(String email, String clientReg, int oauthId) {
        this.email = email;
        this.clientReg = clientReg;
        this.oauthId = oauthId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientReg() {
        return clientReg;
    }

    public void setClientReg(String clientReg) {
        this.clientReg = clientReg;
    }

    public int getOauthId() {
        return oauthId;
    }

    public void setOauthId(int oauthId) {
        this.oauthId = oauthId;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
