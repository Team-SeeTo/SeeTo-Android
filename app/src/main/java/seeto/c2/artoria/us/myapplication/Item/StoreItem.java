package seeto.c2.artoria.us.myapplication.Item;

public class StoreItem {
    private String title;
    private String content;
    private String price;

    public StoreItem(String title, String content, String price){
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPrice() {
        return price;
    }
}
