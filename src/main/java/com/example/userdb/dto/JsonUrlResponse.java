package com.example.userdb.dto;

public class JsonUrlResponse {
    private String jsonUrl;

    public JsonUrlResponse() {}
    public JsonUrlResponse(String jsonUrl) { this.jsonUrl = jsonUrl; }

    public String getJsonUrl() { return jsonUrl; }
    public void setJsonUrl(String jsonUrl) { this.jsonUrl = jsonUrl; }
}
