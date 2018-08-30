package seeto.c2.artoria.us.myapplication.LeaderBoard;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.baseline.baseline.Item.LeaderBoardItem;

public class LeaderBoardActivity extends AppCompatActivity {
    ArrayList<LeaderBoardItem> data = new ArrayList<>();
    RecyclerView leader_board_list;
    LeaderBoardAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        Toolbar toolbar = (Toolbar) findViewById(R.id.leader_board_toolbar);
        setSupportActionBar(toolbar);

        adapter = new LeaderBoardAdapter(data, this);
        leader_board_list = (RecyclerView) findViewById(R.id.leader_board_recycler);

        layoutManager = new LinearLayoutManager(this);
        leader_board_list.setAdapter(adapter);
        leader_board_list.setLayoutManager(layoutManager);
        leader_board_list.setItemAnimator(new DefaultItemAnimator());

        addData();
        adapter.notifyDataSetChanged();
    }

    public void addData() {
        for(int i=0; i<20; i++) {
            data.add(new LeaderBoardItem(i+1,"Lewis"));
        }
    }
}
