package seeto.c2.artoria.us.myapplication.UI.TimeLine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.TimeLineRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.TimeLineModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.TimeLineItem;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class TimeLineFragment extends Fragment implements TImeLineContract.View {

    ArrayList<TimeLineItem> datas = new ArrayList<>();
    RecyclerView timeline_item_list;
    TimeLineRecyclerAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment_timeline,container,false);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH) + 1;
        int day = cal.get(cal.DATE);

        String date = year + "-" + month + "-" + day;

        timeline_item_list = rootView.findViewById(R.id.timeline_recycler);

        getTimelineData(SharedPreferenceKt.getToken(Objects.requireNonNull(getActivity()),true),date);

        return rootView;
    }

    public static TimeLineFragment newInstance(){
        Bundle args = new Bundle();
        TimeLineFragment fragment = new TimeLineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setData() {
        datas.clear();
    }

    public void getTimelineData(String token, String date) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token",token)
                .putVariable("date",date);

        new Connector(getActivity()).getClient().TimelineMain(queryContainerBuilder)
                .enqueue(new Callback<TimeLineModel>() {
                    @Override
                    public void onResponse(Call<TimeLineModel> call, Response<TimeLineModel> response) {
                        TimeLineModel data = response.body();

                        datas.clear();

                            datas.add(new TimeLineItem("Todo",
                                    data.getData().getTimeLine().getTodo().getMilestoneComplete(),
                                    data.getData().getTimeLine().getTodo().getTodoComplete(),
                                    data.getData().getTimeLine().getTodo().getNewCreate(),"milestones completed",
                                    "Todos completed", "Todos created",
                                    data.getData().getTimeLine().getTodo().getTotalPoint()));


                            datas.add(new TimeLineItem("Ideas",
                                    data.getData().getTimeLine().getIdeas().getNewVote(),
                                    data.getData().getTimeLine().getIdeas().getNewComment(),
                                    data.getData().getTimeLine().getIdeas().getNewCreate(),"Ideas voted",
                                    "Ideas commented", "Ideas created",
                                    data.getData().getTimeLine().getIdeas().getTotalPoint()));


                        adapter = new TimeLineRecyclerAdapter(datas,getContext());
                        timeline_item_list.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TimeLineModel> call, Throwable t) {

                    }
                });
    }


}
