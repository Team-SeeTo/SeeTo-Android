package seeto.c2.artoria.us.myapplication.UI.LeaderBoard;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.LeaderBoardAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.LeaderBoardModel;
import seeto.c2.artoria.us.myapplication.Model.TodoMainModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.LeaderBoardItem;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class LeaderBoardActivity extends AppCompatActivity {
    ArrayList<LeaderBoardItem> data = new ArrayList<>();
    RecyclerView leader_board_list;
    LeaderBoardAdapter adapter;
    LinearLayoutManager layoutManager;
    LeaderBoardModel leaderBoardModel;
    TextView my_rank, my_point, my_percent;
    int userLength, myRank;

    @SuppressLint("SetTextI18n")
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
        my_rank = findViewById(R.id.my_rank_num);
        my_point = findViewById(R.id.my_rank_total_num);
        my_percent = findViewById(R.id.my_rank_top_percent);

        myRank = Integer.parseInt(SharedPreferenceKt.getInfo(this,"rank"));
        my_rank.setText("#" + myRank);
        my_point.setText(SharedPreferenceKt.getInfo(this,"point") + "p");

        getLeaderBoardList();

        adapter.notifyDataSetChanged();
    }

    public void addData() {
        LeaderBoardModel.LeaderBoard[] leaderBoards = leaderBoardModel.getData().getLeaderBoards();
        Log.d("LeaderBoard: ", (leaderBoards==null)+"");
        for(LeaderBoardModel.LeaderBoard item: leaderBoards) {
            data.add(new LeaderBoardItem(item.getRank(), item.getName()));
            Log.d("DEBUG", String.valueOf(item.getRank()));
        }
        adapter.notifyDataSetChanged();
//        data.add(new LeaderBoardItem(1,"asdf"));
    }

    void getLeaderBoardList() {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token", SharedPreferenceKt.getToken(this,true));
        new Connector(this).getClient().LeaderBoardMain(queryContainerBuilder)
                .enqueue(new Callback<LeaderBoardModel>() {
                    @Override
                    public void onResponse(Call<LeaderBoardModel> call, Response<LeaderBoardModel> response) {
                        Log.d("LeaderBoard", response.message());
                        leaderBoardModel = response.body();
                        if(leaderBoardModel.getData().getLeaderBoards() == null) {
                            Log.d("LeaderBoard is null","");
                            getLeaderBoardList();
                        }else {
                            Log.d("LeaderBoard isn't null","");
                            addData();
                            setUserList(leaderBoardModel.getData().getLeaderBoards());
                        }
                    }

                    @Override
                    public void onFailure(Call<LeaderBoardModel> call, Throwable t) {
                        Log.d("LeaderBoard get faild", t.getMessage());
                        getLeaderBoardList();
                    }
                });
    }

    void setUserList(LeaderBoardModel.LeaderBoard[] lists) {
        userLength = lists.length;
        TextView firstUserName = findViewById(R.id.first_grade_user);
        View secondUserView = findViewById(R.id.second_grade_profile);
        TextView secondUserName = findViewById(R.id.second_grade_user);
        TextView secondUserRank = findViewById(R.id.second_grade_rank);
        View thirdUserView = findViewById(R.id.third_grade_profile);
        TextView thirdUserName = findViewById(R.id.third_grade_user);
        TextView thirdUserRank = findViewById(R.id.third_grade_rank);
        switch (userLength) {
            case 1:
                firstUserName.setText(lists[0].getName());
                break;
            case 2:
                firstUserName.setText(lists[0].getName());
                secondUserName.setText(lists[1].getName());
                secondUserRank.setVisibility(View.VISIBLE);
                secondUserName.setVisibility(View.VISIBLE);
                secondUserView.setVisibility(View.VISIBLE);
                break;
            case 3:
            default:
                firstUserName.setText(lists[0].getName());
                secondUserName.setText(lists[1].getName());
                secondUserRank.setVisibility(View.VISIBLE);
                secondUserName.setVisibility(View.VISIBLE);
                secondUserView.setVisibility(View.VISIBLE);
                thirdUserName.setText(lists[2].getName());
                thirdUserName.setVisibility(View.VISIBLE);
                thirdUserRank.setVisibility(View.VISIBLE);
                thirdUserView.setVisibility(View.VISIBLE);
        }
        my_percent.setText((myRank/userLength*100)+"%");
    }
}
