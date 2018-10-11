package seeto.c2.artoria.us.myapplication.Item;

public class TimeLineItem {
    private String category;
    private int firstline_int;
    private int secondline_int;
    private int thirdline_int;
    private String firstline_explain;
    private String secondline_explain;
    private String thirdline_explain;
    private int total_point;

    public TimeLineItem(String category, int firstline_int, int secondline_int, int thirdline_int
                        , String firstline_explain, String secondline_explain, String thirdline_explain
                        , int total_point)
    {
        this.category = category;
        this.firstline_int = firstline_int;
        this.secondline_int = secondline_int;
        this.thirdline_int = thirdline_int;
        this.firstline_explain = firstline_explain;
        this.secondline_explain = secondline_explain;
        this.thirdline_explain = thirdline_explain;
        this.total_point = total_point;
    }

    public String getCategory() {
        return category;
    }

    public int getFirstline_int() {
        return firstline_int;
    }

    public int getSecondline_int() {
        return secondline_int;
    }

    public int getThirdline_int() {
        return thirdline_int;
    }

    public String getFirstline_explain() {
        return firstline_explain;
    }

    public String getSecondline_explain() {
        return secondline_explain;
    }

    public String getThirdline_explain() {
        return thirdline_explain;
    }

    public int getTotal_point() {
        return total_point;
    }
}
