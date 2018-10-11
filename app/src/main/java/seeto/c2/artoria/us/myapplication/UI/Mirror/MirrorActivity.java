package seeto.c2.artoria.us.myapplication.UI.Mirror;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import seeto.c2.artoria.us.myapplication.Adapter.MirrorAdapter;
import seeto.c2.artoria.us.myapplication.R;

public class MirrorActivity extends AppCompatActivity {
    private LinkedHashMap<String, ParentInfo> increaseList = new LinkedHashMap<String, ParentInfo>();
    private ArrayList<ParentInfo> deptList = new ArrayList<ParentInfo>();
    private MirrorAdapter listAdapter;
    private ExpandableListView explist;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror);

        Loaddata();

        explist = (ExpandableListView)findViewById(R.id.mirror_listview);
        listAdapter = new MirrorAdapter(MirrorActivity.this, deptList);
        explist.setAdapter(listAdapter);

        explist.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            ParentInfo headerInfo = deptList.get(groupPosition);
            ChildInfo DetailInfo = headerInfo.getList().get(childPosition);

            return false;
        });

        explist.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            ParentInfo headerInfo = deptList.get(groupPosition);

            return false;
        });
    }

    private void expandall() {
        int count = listAdapter.getGroupCount();
        for(int i=0; i<count; i++){
            explist.expandGroup(i);
        }
    }

    private void callapseall(){
        int count = listAdapter.getGroupCount();
        for(int i=0; i<count; i++){
            explist.collapseGroup(i);
        }
    }

    private void Loaddata(){

        addData("Last Week","Todo activity increase");
        addData("Last Week","0%");
        addData("Last Week","Ideas activity increase");
        addData("Last Week","0%");
        addData("Last Week","Total activity increase");
        addData("Last Week","0%");

        addData("Last Month","Todo activity increase");
        addData("Last Month","0%");
        addData("Last Month","Ideas activity increase");
        addData("Last Month","0%");
        addData("Last Month","Total activity increase");
        addData("Last Month","0%");

        addData("Last Year","Todo activity increase");
        addData("Last Year","0%");
        addData("Last Year","Ideas activity increase");
        addData("Last Year","0%");
        addData("Last Year","Total activity increase");
        addData("Last Year","0%");
    }

    private int addData(String department, String increase){
        int groupPosition = 0;
        ArrayList<ParentInfo> arrayList;
        ParentInfo headerInfo = increaseList.get(department);

        if(headerInfo == null){
            headerInfo = new ParentInfo();
            headerInfo.setTitle(department);

            increaseList.put(department,headerInfo);
            deptList.add(headerInfo);
        }

        ArrayList<ChildInfo> increaseList = headerInfo.getList();

        int listsize = increaseList.size();
        listsize++;

        ChildInfo DetailInfo = new ChildInfo();
        DetailInfo.setTitle(increase);
        increaseList.add(DetailInfo);

        groupPosition = deptList.indexOf(headerInfo);

        return groupPosition;
    }
}