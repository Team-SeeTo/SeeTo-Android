package seeto.c2.artoria.us.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IdeasDetailModel {
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }

    public static class Data{
        @SerializedName("ideas")
        List<IdeasDetailItems> ideas;

        public List<IdeasDetailItems> getIdeas() {
            return ideas;
        }
    }

    public static class IdeasDetailItems{
        @SerializedName("id")
        String id;

        @SerializedName("author")
        String author;

        @SerializedName("title")
        String title;

        @SerializedName("body")
        String body;

        @SerializedName("createdAt")
        String createdAt;

        @SerializedName("category")
        String category;

        @SerializedName("comments")
        Comments comments;

        @SerializedName("upvoter")
        String upvoter;

        @SerializedName("voteChecked")
        Boolean voteChecked;

        public String getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getCategory() {
            return category;
        }

        public Comments getComments() {
            return comments;
        }

        public Boolean getVoteChecked() {
            return voteChecked;
        }
    }

    public static class Comments{
        @SerializedName("comments")
        List<CommentItem> comment;

        @SerializedName("commentCount")
        int commentCount;

        public List<CommentItem> getComment() {
            return comment;
        }

        public int getCommentCount() {
            return commentCount;
        }
    }


    public static class CommentItem{
        @SerializedName("author")
        String author;

        @SerializedName("body")
        String body;

        public String getAuthor() {
            return author;
        }

        public String getBody() {
            return body;
        }
    }
}
