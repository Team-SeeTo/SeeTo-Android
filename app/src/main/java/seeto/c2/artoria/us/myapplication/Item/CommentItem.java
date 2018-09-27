package seeto.c2.artoria.us.myapplication.Item;

public class CommentItem {
    private String name;
    private String content;

    public CommentItem(String name, String content){
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
