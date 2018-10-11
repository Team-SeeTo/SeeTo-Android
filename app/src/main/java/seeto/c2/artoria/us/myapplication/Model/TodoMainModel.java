package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TodoMainModel {

    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data {
        @SerializedName("todo")
        Todo[] todos;

        public Todo[] getTodos() {
            return todos;
        }
    }

    public static class Todo {
        @SerializedName("id")
        String id;
        @SerializedName("title")
        String title;
        @SerializedName("type")
        String type;
        @SerializedName("createdAt")
        String createdAt;
        @SerializedName("milestones")
        ArrayList<milestone> milestones;
        @SerializedName("expiration")
        String expriation;
        @SerializedName("isCompleted")
        Boolean isCompleted;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public ArrayList<milestone> getMilestones() {
            return milestones;
        }

        public String getExpriation() {
            return expriation;
        }

        public Boolean getCompleted() {
            return isCompleted;
        }
    }

    public static class milestone {
        @SerializedName("name")
        String name;
        @SerializedName("isCompleted")
        Boolean isCompleted;
        @SerializedName("id")
        String id;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Boolean getCompleted() {
            return isCompleted;
        }
    }
}
