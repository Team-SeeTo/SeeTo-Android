package seeto.c2.artoria.us.myapplication.Ideas.IdeasRecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Model.IdeasModel;
import seeto.c2.artoria.us.myapplication.R;

public class IdeasRecyclerAdapter extends RecyclerView.Adapter<IdeasRecyclerAdapter.CustomViewHolder> {
    private ArrayList<IdeasModel> items;
    private Context context;

    public IdeasRecyclerAdapter(ArrayList<IdeasModel> items, Context context){
        this.items = items;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ideas,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.category.setText(items.get(position).getCategory());
        holder.rank.setText(items.get(position).getRank());
        holder.like.setText(items.get(position).getLike());
        holder.comment.setText(items.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView category;
        private TextView rank;
        private TextView like;
        private TextView comment;

        public CustomViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_ideas_title);
            category = itemView.findViewById(R.id.item_ideas_category);
            rank = itemView.findViewById(R.id.item_ideas_rank_text);
            like = itemView.findViewById(R.id.item_ideas_like_text);
            comment = itemView.findViewById(R.id.item_ideas_comment_text);
        }
    }
}
