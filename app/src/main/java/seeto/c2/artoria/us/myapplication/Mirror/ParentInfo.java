package seeto.c2.artoria.us.myapplication.Mirror;

import java.util.ArrayList;

public class ParentInfo {
    public String title;

    public ArrayList<ChildInfo> List = new ArrayList<ChildInfo>();
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ChildInfo> getList() {
        return List;
    }

    public void setList(ArrayList<ChildInfo> list) {
        List = list;
    }

}
