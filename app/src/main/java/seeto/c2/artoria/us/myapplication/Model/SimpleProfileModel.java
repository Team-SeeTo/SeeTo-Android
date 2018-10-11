package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class SimpleProfileModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data{
        @SerializedName("profile")
        Profile profile;

        public Profile getProfile() {
            return profile;
    }

    }


    public static class Profile{
        @SerializedName("imgPath")
        String imgPath;

        @SerializedName("email")
        String email;

        @SerializedName("username")
        String username;

        @SerializedName("rank")
        int rank;

        @SerializedName("point")
        int point;

        @SerializedName("registerOn")
        String registerOn;

        public String getImgPath() {
            return imgPath;
        }

        public String getEmail() {
            return email;
        }

        public String getUsername() {
            return username;
        }

        public int getRank() {
            return rank;
        }

        public int getPoint() {
            return point;
        }

        public String getRegisterOn() {
            return registerOn;
        }
    }
}
