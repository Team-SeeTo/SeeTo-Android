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

        addData("LastWeek","Todo activity increase");
        addData("LastWeek","120%");
        addData("LastWeek","Ideas activity increase");
        addData("LastWeek","85%");
        addData("LastWeek","Total activity increase");
        addData("LastWeek","102%");

        addData("LastMonth","Todo activity increase");
        addData("LastMonth","120%");
        addData("LastMonth","Ideas activity increase");
        addData("LastMonth","85%");
        addData("LastMonth","Total activity increase");
        addData("LastMonth","102%");

        addData("LastYear","Todo activity increase");
        addData("LastYear","120%");
        addData("LastYear","Ideas activity increase");
        addData("LastYear","85%");
        addData("LastYear","Total activity increase");
        addData("LastYear","102%");

//        for(int i = 0; i<deptList.size(); i++){
//           if(deptList.indexOf(i) % 2 == 0){
//
//           }
//        }
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
        headerInfo.setTitle("Last week");

        groupPosition = deptList.indexOf(headerInfo);

        return groupPosition;
    }

}