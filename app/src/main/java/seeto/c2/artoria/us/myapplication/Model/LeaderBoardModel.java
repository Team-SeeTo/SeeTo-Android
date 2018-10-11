package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class LeaderBoardModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data {
        @SerializedName("leaderboards")
        LeaderBoard[] leaderBoards;

        public LeaderBoard[] getLeaderBoards() {
            return leaderBoards;
        }
    }

    public static class LeaderBoard {
        @SerializedName("rank")
        int rank;
        @SerializedName("point")
        int point;
        @SerializedName("name")
        String name;

        public String getName() {
            return name;
        }

        public int getRank() {
            return rank;
        }

        public int getPoint() {
            return point;
        }
    }

}
