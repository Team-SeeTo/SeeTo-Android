//package seeto.c2.artoria.us.myapplication.Mirror;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.Display;
//import android.widget.ExpandableListAdapter;
//import android.widget.ExpandableListView;
//import android.widget.LinearLayout;
//
//import java.util.ArrayList;
//import seeto.c2.artoria.us.myapplication.R;
//
//public class MirrorActivity extends AppCompatActivity {
//    private RecyclerView recyclerview;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mirror);
//
//        recyclerview = (RecyclerView)findViewById(R.id.mirror_recycler);
//        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true));
//        List<ExpandableListAdapter.Item> data = new ArrayList<>();
//
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "LastWeek"));
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "ToDo activity increase"));
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "120%"));
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Ideas activity increase"));
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "85%"));
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Total activity increase"));
//        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "102%"));
//
//        recyclerview.setAdapter(new ExpandableListAdapter(data));
//}