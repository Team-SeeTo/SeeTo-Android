package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class TimeLineModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data{
        @SerializedName("timeline")
        TimeLine timeLine;

        public TimeLine getTimeLine() {
            return timeLine;
        }
    }

    public static class TimeLine{
        @SerializedName("todo")
        Todo todo;

        @SerializedName("ideas")
        Ideas ideas;

        @SerializedName("date")
        String date;

        @SerializedName("totalPoint")
        int totalPoint;

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

        @SerializedName("todoComplete")
        int todoComplete;

        @SerializedName("totalPoint")
        int totalPoint;

        @SerializedName("milestoneComplete")
        int milestoneComplete;

        public int getNewCreate() {
            return newCreate;
        }

        public int getMilestoneComplete() {
            return milestoneComplete;
        }

        public int getTodoComplete() {
            return todoComplete;
        }

        public int getTotalPoint() {
            return totalPoint;
        }
    }

    public static class Ideas{
        @SerializedName("newVote")
        int newVote;

        @SerializedName("newComment")
        int newComment;

        @SerializedName("newCreate")
        int newCreate;

        @SerializedName("totalPoint")
        int totalPoint;

        public int getTotalPoint() {
            return totalPoint;
        }

        public int getNewCreate() {
            return newCreate;
        }

        public int getNewComment() {
            return newComment;
        }

        public int getNewVote() {
            return newVote;
        }
    }


}
