package com.bctt.dto.reponse;

public class AuthResponse {
    private String token;
    private String message;
    private String maUser;  // ✅ Thêm maUser vào response

    public AuthResponse(String token, String message, String maUser) { // ✅ Cập nhật constructor
        this.token = token;
        this.message = message;
        this.maUser = maUser;
    }


    public AuthResponse() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }
}
