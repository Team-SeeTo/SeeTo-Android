package seeto.c2.artoria.us.myapplication.UI.Mirror;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.MirrorAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.MirrorModel;
import seeto.c2.artoria.us.myapplication.Model.TimeLineModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class MirrorActivity extends AppCompatActivity {
    private LinkedHashMap<String, ParentInfo> increaseList = new LinkedHashMap<String, ParentInfo>();
    private ArrayList<ParentInfo> deptList = new ArrayList<ParentInfo>();
    private MirrorAdapter listAdapter;
    private ExpandableListView explist;

    String t_date,w_date,m_date,y_date;
    int t_tp, w_tp, m_tp, y_tp
            ,t_t_newcreate, t_i_newcreate, w_t_newcrete, w_i_newcreate
            ,m_t_newcreate, m_i_newcreate, y_t_newcreate, y_i_newcreate;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);

        int week_date = day - 7;
        int month_date = month - 1;
        int year_date = year - 1;

        String weekago = year + "-" + month + "-0" + week_date;
        String monthago = year + "-0" + month_date + "-" + day;
        String yearago = year_date + "-" + month + "-" + day;

        getdata(SharedPreferenceKt.getToken(this, true),weekago, monthago, yearago);

        explist = (ExpandableListView)findViewById(R.id.mirror_listview);

    }

    public void getdata(String token, String weekago, String monthago, String yearago) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token",token)
                .putVariable("date_year_ago",yearago)
                .putVariable("date_month_ago",monthago)
                .putVariable("date_week_ago",weekago);

        new Connector(this).getClient().Mirror(queryContainerBuilder)
                .enqueue(new Callback<MirrorModel>() {
                    @Override
                    public void onResponse(Call<MirrorModel> call, Response<MirrorModel> response) {
                        MirrorModel mirrorModel = response.body();

                        t_date = mirrorModel.getData().getToday().getDate();
                        w_date = mirrorModel.getData().getWeekago().getDate();
                        m_date = mirrorModel.getData().getMonthago().getDate();
                        y_date = mirrorModel.getData().getYearago().getDate();

                        t_tp = mirrorModel.getData().getToday().getTotalPoint();
                        w_tp = mirrorModel.getData().getWeekago().getTotalPoint();
                        m_tp = mirrorModel.getData().getMonthago().getTotalPoint();
                        y_tp = mirrorModel.getData().getYearago().getTotalPoint();

                        t_t_newcreate = mirrorModel.getData().getToday().getTodo().getNewCreate();
                        t_i_newcreate = mirrorModel.getData().getToday().getIdeas().getNewCreate();
                        w_t_newcrete = mirrorModel.getData().getWeekago().getTodo().getNewCreate();
                        w_i_newcreate = mirrorModel.getData().getWeekago().getIdeas().getNewCreate();
                        m_t_newcreate = mirrorModel.getData().getMonthago().getTodo().getNewCreate();
                        m_i_newcreate = mirrorModel.getData().getMonthago().getIdeas().getNewCreate();
                        y_t_newcreate = mirrorModel.getData().getYearago().getTodo().getNewCreate();
                        y_i_newcreate = mirrorModel.getData().getYearago().getIdeas().getNewCreate();
                        Loaddata();
                    }

                    @Override
                    public void onFailure(Call<MirrorModel> call, Throwable t) {

                    }
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

    String buho (int val) {
        if(val>0) {
            return "+"+val;
        }else {
            return ""+val;
        }
    }

    private void Loaddata(){

        addData("Last Week","Todo activity increase");
        addData("Last Week", buho(t_t_newcreate-w_t_newcrete));
        addData("Last Week","Ideas activity increase");
        addData("Last Week",buho(t_i_newcreate-w_i_newcreate));
        addData("Last Week","Total activity increase");
        addData("Last Week",buho(t_t_newcreate-w_t_newcrete+t_i_newcreate-w_i_newcreate));

        addData("Last Month","Todo activity increase");
        addData("Last Month",buho(t_t_newcreate-m_t_newcreate));
        addData("Last Month","Ideas activity increase");
        addData("Last Month",buho(t_t_newcreate-m_i_newcreate));
        addData("Last Month","Total activity increase");
        addData("Last Month",buho(t_t_newcreate-m_t_newcreate+t_t_newcreate-m_i_newcreate));

        addData("Last Year","Todo activity increase");
        addData("Last Year",buho(t_t_newcreate-y_t_newcreate));
        addData("Last Year","Ideas activity increase");
        addData("Last Year",buho(t_t_newcreate-y_i_newcreate));
        addData("Last Year","Total activity increase");
        addData("Last Year",buho(t_t_newcreate-y_t_newcreate+t_t_newcreate-y_i_newcreate));

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
