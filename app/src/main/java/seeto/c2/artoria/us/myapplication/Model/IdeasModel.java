package seeto.c2.artoria.us.myapplication.Model;

import android.content.Context;

public class IdeasModel {
    private String title;
    private String category;
    private String rank;
    private String like;
    private String comment;

    public IdeasModel(String title, String category, String rank, String like, String comment){
        this.title = title;
        this.category = category;
        this.rank = rank;
        this.like = like;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getRank() {
        return rank;
    }

    public String getLike() {
        return like;
    }

    public String getComment() {
        return comment;
    }
}