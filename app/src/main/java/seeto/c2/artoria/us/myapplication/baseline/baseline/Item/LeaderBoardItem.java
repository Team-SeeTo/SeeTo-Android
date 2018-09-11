package seeto.c2.artoria.us.myapplication.baseline.baseline.Item;

public class LeaderBoardItem {
    private int rank;
    private String userName;

    public LeaderBoardItem(int rank, String userName) {
        this.rank = rank;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getRank() {
        return rank;
    }
}
