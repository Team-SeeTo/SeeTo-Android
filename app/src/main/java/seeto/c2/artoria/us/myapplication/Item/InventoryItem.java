package seeto.c2.artoria.us.myapplication.Item;

public class InventoryItem {
    private String title;
    private String content;

    public InventoryItem(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
