package seeto.c2.artoria.us.myapplication.UI.QM;

public class Memo {
    private long id;
    private String text;

    public Memo() {
        this(0, null);
    }

    public Memo(String text) {
        this(0, text);
    }

    public Memo(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
