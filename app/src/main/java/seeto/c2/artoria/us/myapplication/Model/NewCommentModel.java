package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class NewCommentModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data{
        @SerializedName("newComment")
        NewComment newcomment;

        public NewComment getNewcomment() {
            return newcomment;
        }
    }

    public static class NewComment{
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
