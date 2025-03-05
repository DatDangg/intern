package com.bctt.dto.request;

import lombok.*;

public class UserRequest {
    private String maUser;
    private String emailDN;
    private String password;

    public String getEmailDN() {
        return emailDN;
    }

    public void setEmailDN(String emailDN) {
        this.emailDN = emailDN;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }
}
