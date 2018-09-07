package seeto.c2.artoria.us.myapplication.Model;


import com.google.gson.JsonObject;

public class TokenModel {
    String accessToken;
    String refreshToken;
    JsonObject data;
    JsonObject auth;

    public JsonObject getData() {
        return data;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
