package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class TokenModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data {
        @SerializedName("auth")
        Auth auth;

        public Auth getAuth() {
            return auth;
        }
    }

    public static class Auth {
        @SerializedName("result")
        Result result;

        public Result getResult() {
            return result;
        }
    }

    public static class Result {
        @SerializedName("accessToken")
        String accessToken;
        @SerializedName("refreshToken")
        String refreshToken;
        @SerializedName("message")
        String message;

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public String getMessage() {
            return message;
        }
    }
}
