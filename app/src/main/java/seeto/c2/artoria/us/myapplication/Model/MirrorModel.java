package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class MirrorModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data{
        @SerializedName("today")
        Today today;

        @SerializedName("week_ago")
        Weekago weekago;

        @SerializedName("month_ago")
        Monthago monthago;

        @SerializedName("year_ago")
        Yearago yearago;

        public Today getToday() {
            return today;
        }

        public Weekago getWeekago() {
            return weekago;
        }

        public Monthago getMonthago() {
            return monthago;
        }

        public Yearago getYearago() {
            return yearago;
        }
    }

    public static class Today{
        @SerializedName("date")
        String date;

        @SerializedName("totalPoint")
        int totalPoint;

        @SerializedName("todo")
        Todo todo;

        @SerializedName("ideas")
        Ideas ideas;

        public String getDate() {
            return date;
        }

        public int getTotalPoint() {
            return totalPoint;
        }

        public Todo getTodo() {
            return todo;
        }

        public Ideas getIdeas() {
            return ideas;
        }
    }
    public static class Weekago{
        @SerializedName("date")
        String date;

        @SerializedName("totalPoint")
        int totalPoint;

        @SerializedName("todo")
        Todo todo;

        @SerializedName("ideas")
        Ideas ideas;

        public String getDate() {
            return date;
        }

        public int getTotalPoint() {
            return totalPoint;
        }

        public Todo getTodo() {
            return todo;
        }

        public Ideas getIdeas() {
            return ideas;
        }
    }
    public static class Monthago{
        @SerializedName("date")
        String date;

        @SerializedName("totalPoint")
        int totalPoint;

        @SerializedName("todo")
        Todo todo;

        @SerializedName("ideas")
        Ideas ideas;

        public int getTotalPoint() {
            return totalPoint;
        }

        public String getDate() {
            return date;
        }
        public Todo getTodo() {
            return todo;
        }

        public Ideas getIdeas() {
            return ideas;
        }
    }
    public static class Yearago{
        @SerializedName("date")
        String date;

        @SerializedName("totalPoint")
        int totalPoint;

        @SerializedName("todo")
        Todo todo;

        @SerializedName("ideas")
        Ideas ideas;

        public String getDate() {
            return date;
        }

        public int getTotalPoint() {
            return totalPoint;
        }

        public Todo getTodo() {
            return todo;
        }

        public Ideas getIdeas() {
            return ideas;
        }
    }

    public static class Todo{
        @SerializedName("newCreate")
        int newCreate;

        public int getNewCreate() {
            return newCreate;
        }
    }

    public static class Ideas{
        @SerializedName("newCreate")
        int newCreate;

        public int getNewCreate() {
            return newCreate;
        }
    }
}
