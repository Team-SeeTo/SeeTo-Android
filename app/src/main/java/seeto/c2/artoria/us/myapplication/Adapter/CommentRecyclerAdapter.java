package seeto.c2.artoria.us.myapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Item.CommentItem;
import seeto.c2.artoria.us.myapplication.R;

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.CustomViewHolder> {
    private ArrayList<CommentItem> items;

    public CommentRecyclerAdapter(ArrayList<CommentItem> items){
        this.items = items;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.content.setText(items.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView content;

        public CustomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.comment_name);
            content = itemView.findViewById(R.id.comment_content);
        }
    }
}
