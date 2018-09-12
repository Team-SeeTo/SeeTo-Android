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
import seeto.c2.artoria.us.myapplication.baseline.baseline.Item.LeaderBoardItem;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.CustomViewHolder>{

    ArrayList<LeaderBoardItem> items;
    Context context;

    public LeaderBoardAdapter(ArrayList<LeaderBoardItem> items, Context context){
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(
                parent.getContext()
        ).inflate(R.layout.item_rankers, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.userName.setText(items.get(position).getUserName());
        holder.rank.setText("#" + String.valueOf(items.get(position).getRank()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView userName;
        private TextView rank;

        public CustomViewHolder(View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.rank);
            userName = itemView.findViewById(R.id.ranker_name);
        }
    }
}
