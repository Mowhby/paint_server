package com.example.userdb.dto;

public class UpdateJsonUrlRequest extends AuthRequest {
    private String jsonUrl;

    public UpdateJsonUrlRequest() {}

    public UpdateJsonUrlRequest(String username, String password, String jsonUrl) {
        super(username, password);
        this.jsonUrl = jsonUrl;
    }

    public String getJsonUrl() { return jsonUrl; }
    public void setJsonUrl(String jsonUrl) { this.jsonUrl = jsonUrl; }
}
