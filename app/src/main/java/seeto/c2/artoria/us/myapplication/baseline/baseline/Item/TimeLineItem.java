package seeto.c2.artoria.us.myapplication.baseline.baseline.Item;

public class TimeLineItem {
    private String category;
    private String firstline_int;
    private String secondline_int;
    private String thirdline_int;
    private String firstline_explain;
    private String secondline_explain;
    private String thirdline_explain;
    private String total_point;

    public TimeLineItem(String category, String firstline_int, String secondline_int, String thirdline_int
                        ,String firstline_explain, String secondline_explain, String thirdline_explain
                        ,String total_point)
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

    public String getFirstline_int() {
        return firstline_int;
    }

    public String getSecondline_int() {
        return secondline_int;
    }

    public String getThirdline_int() {
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

    public String getTotal_point() {
        return total_point;
    }
}
