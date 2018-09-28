package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public class IdeasMainModel {
    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public static class Data {
        @SerializedName("ideas")
        private List<IdeasMainItem> ideas;

        public List<IdeasMainItem> getIdeas() {
            return ideas;
        }
    }

    public static class IdeasMainItem {
        @SerializedName("author")
        private String author;

        @SerializedName("title")
        private String title;

        @SerializedName("body")
        private String body;

        @SerializedName("comments")
        private List<CommentItem> comments;

        @SerializedName("upvoter")
        private int upvoter;

        public String getAuthor() {
            return author;
        }

        public String getBody() {
            return body;
        }

        public String getTitle() {
            return title;
        }

        public List<CommentItem> getComments() {
            return comments;
        }

        public int getUpvoter() {
            return upvoter;
        }
    }

    public static class CommentItem {
        @SerializedName("author")
        private String comment_author;

        @SerializedName("body")
        private String comment_body;

        public String getComment_author() {
            return comment_author;
        }

        public String getComment_body() {
            return comment_body;
        }
    }


}
