package seeto.c2.artoria.us.myapplication.Item;

public class IdeasItem {
    private String title;
    private String category;
    private String rank;
    private String like;
    private String comment;
    private String id;
    private boolean vote;

    public IdeasItem(String title, String category, String rank, String like, String comment,String id, boolean vote){
        this.title = title;
        this.category = category;
        this.rank = rank;
        this.like = like;
        this.comment = comment;
        this.id = id;
        this.vote = vote;
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

    public String getId() {
        return id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }
}