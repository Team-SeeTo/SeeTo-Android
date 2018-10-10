package seeto.c2.artoria.us.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.TimeLineItem;

public class TimeLineRecyclerAdapter extends RecyclerView.Adapter<TimeLineRecyclerAdapter.CustomViewHolder> {
    private ArrayList<TimeLineItem> datas;
    private Context context;

    public TimeLineRecyclerAdapter(ArrayList<TimeLineItem> datas , Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.category.setText(datas.get(position).getCategory());
        holder.firstline_int.setText(String.valueOf(datas.get(position).getFirstline_int()));
        holder.secondline_int.setText(String.valueOf(datas.get(position).getSecondline_int()));
        holder.thirdline_int.setText(String.valueOf(datas.get(position).getThirdline_int()));
        holder.firstline_explain.setText(datas.get(position).getFirstline_explain());
        holder.secondline_explain.setText(datas.get(position).getSecondline_explain());
        holder.thirdline_explain.setText(datas.get(position).getThirdline_explain());
        holder.total_point.setText(String.valueOf(datas.get(position).getTotal_point()) + "p");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView firstline_int;
        private TextView secondline_int;
        private TextView thirdline_int;
        private TextView total_point;
        private TextView category;
        private TextView firstline_explain;
        private TextView secondline_explain;
        private TextView thirdline_explain;

        public CustomViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.item_timeline_category);
            firstline_int = itemView.findViewById(R.id.item_timeline_firstline_int);
            secondline_int = itemView.findViewById(R.id.item_timeline_secondline_int);
            thirdline_int = itemView.findViewById(R.id.item_timeline_thirdline_int);
            firstline_explain = itemView.findViewById(R.id.item_timeline_firstline_explain);
            secondline_explain = itemView.findViewById(R.id.item_timeline_secondline_explain);
            thirdline_explain = itemView.findViewById(R.id.item_timeline_thirdline_explain);
            total_point = itemView.findViewById(R.id.item_timeline_total_point);
        }
    }
}

