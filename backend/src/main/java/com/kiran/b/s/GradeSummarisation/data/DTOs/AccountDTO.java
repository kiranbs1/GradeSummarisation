package com.kiran.b.s.GradeSummarisation.data.DTOs;

import java.util.List;

public class AccountDTO {

    //email + clientReg + oauthId = unique identifier to find userAccountId
    private Integer userAccountId;
    private Integer oauthId;
    private String email;
    private String clientReg;

    private List<CourseDTO> courses;

    public AccountDTO(String email, String clientReg, Integer oauthId) {
        this.email = email;
        this.clientReg = clientReg;
        this.oauthId = oauthId;
    }

    public AccountDTO() {
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

    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
