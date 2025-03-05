package com.bctt.dto.reponse;

public class UserResponse {
    private String maUser;
    private String emailDN;
    private String password;
    private UserProfileResponse userProfileResponse;

    public UserResponse(){}
    public UserResponse(String maUser, String emailDN, String password, UserProfileResponse userProfileResponse) {
        this.maUser = maUser;
        this.emailDN = emailDN;
        this.password = password;
        this.userProfileResponse = userProfileResponse;
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
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

    public UserProfileResponse getUserProfileResponse() {
        return userProfileResponse;
    }

    public void setUserProfileResponse(UserProfileResponse userProfileResponse) {
        this.userProfileResponse = userProfileResponse;
    }
}
