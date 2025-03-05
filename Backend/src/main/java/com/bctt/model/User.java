package com.bctt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private String maUser;
    private String emailDN;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private User_profile userProfile;

    public User_profile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(User_profile userProfile) {
        this.userProfile = userProfile;
    }

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
