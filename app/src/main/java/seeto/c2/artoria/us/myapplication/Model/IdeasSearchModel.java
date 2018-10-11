package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IdeasSearchModel {
    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public static class Data {
        @SerializedName("ideas")
        private List<IdeasSearchItem> ideas;

        public List<IdeasSearchItem> getIdeas() {
            return ideas;
        }
    }

    public static class IdeasSearchItem {
        @SerializedName("author")
        private String author;

        @SerializedName("title")
        private String title;

        @SerializedName("body")
        private String body;

        @SerializedName("comments")
        private Comments comments;

        @SerializedName("upvoter")
        private int upvoter;

        @SerializedName("category")
        private String category;

        @SerializedName("createdAt")
        private String createdAt;

        @SerializedName("id")
        private String id;

        public String getAuthor() {
            return author;
        }

        public String getBody() {
            return body;
        }

        public String getTitle() {
            return title;
        }

        public Comments getComments() {
            return comments;
        }

        public int getUpvoter() {
            return upvoter;
        }

        public String getCategory() {
            return category;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getId() {
            return id;
        }
    }

    public static class Comments{
        @SerializedName("comments")
        private List<CommentItem> comments;

        @SerializedName("commentsCount")
        private int commentsCount;

        public List<CommentItem> getComments() {
            return comments;
        }

        public int getCommentsCount() {
            return commentsCount;
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
