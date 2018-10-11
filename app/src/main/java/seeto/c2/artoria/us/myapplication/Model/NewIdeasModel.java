package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class NewIdeasModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data{
        @SerializedName("newIdea")
        NewIdea newIdea;

        public NewIdea getNewIdea() {
            return newIdea;
        }
    }

    public static class NewIdea{
        @SerializedName("result")
        Result result;

        public Result getResult() {
            return result;
        }
    }

    public static class Result{
        @SerializedName("isSuccess")
        Boolean isSuccess;

        @SerializedName("message")
        String message;

        public Boolean getSuccess() {
            return isSuccess;
        }

        public String getMessage() {
            return message;
        }
    }
}
