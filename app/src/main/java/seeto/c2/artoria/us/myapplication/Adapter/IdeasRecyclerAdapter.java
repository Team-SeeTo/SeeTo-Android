package seeto.c2.artoria.us.myapplication.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.IdeasMainModel;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.Ideas.IdeasViewDetailActivity;
import seeto.c2.artoria.us.myapplication.Item.IdeasItem;
import seeto.c2.artoria.us.myapplication.R;

public class IdeasRecyclerAdapter extends RecyclerView.Adapter<IdeasRecyclerAdapter.CustomViewHolder> {
    private ArrayList<IdeasItem> items;
    private Context context;
    boolean like_flag = false;

    public IdeasRecyclerAdapter(ArrayList<IdeasItem> items, Context context){
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
        holder.like_text.setText(String.valueOf(items.get(position).getLike()));
        holder.comment.setText(items.get(position).getComment());
        holder.item.setOnClickListener(v -> {
            String id = items.get(position).getId();
            Log.d("ID",id);
            Intent intent = new Intent(context, IdeasViewDetailActivity.class);
            intent.putExtra("id",id);
            context.startActivity(intent);
        });
        holder.like_btn.setOnClickListener(v -> {
            if (!items.get(position).isVote()){
                    items.get(position).setVote(true);
                    holder.like_btn.setImageResource(R.drawable.ic_fill_favorite);
                    holder.like_text.setTextColor(Color.parseColor("#ff0000"));
                    holder.like_text.setText(String.valueOf(items.get(position).getLike() + 1));
                    Toast.makeText(context, "이 게시물에 좋아요를 표시했습니다.", Toast.LENGTH_SHORT).show();
                    setvote(SharedPreferenceKt.getToken(context,true),items.get(position).getId());
            } else{
                    items.get(position).setVote(false);
                    holder.like_btn.setImageResource(R.drawable.ic_favorite);
                    holder.like_text.setTextColor(Color.parseColor("#757575"));
                    holder.like_text.setText(String.valueOf("0"));
                    Toast.makeText(context, "이 게시물에 좋아요를 취소했습니다.", Toast.LENGTH_SHORT).show();
            }

//                if(!like_flag){
//                    like_flag = true;
//                    holder.like_btn.setImageResource(R.drawable.ic_fill_favorite);
//                    holder.like_text.setTextColor(Color.parseColor("#ff0000"));
//                    holder.like_text.setText("1");
//                    Toast.makeText(context, "이 게시물에 좋아요를 표시했습니다.", Toast.LENGTH_SHORT).show();
//                } else {
//                    like_flag = false;
//                    holder.like_btn.setImageResource(R.drawable.ic_favorite);
//                    holder.like_text.setTextColor(Color.parseColor("#757575"));
//                    holder.like_text.setText("0");
//                    Toast.makeText(context, "이 게시물에 좋아요를 취소했습니다.", Toast.LENGTH_SHORT).show();
//                }
        });
    }

    public void setvote(String token, String id) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token",token)
                .putVariable("id",id);

        new Connector(context).getClient().Vote(queryContainerBuilder)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItemMore(ArrayList<IdeasItem> lst){
        notifyItemRangeChanged(0 ,items.size());
    }



    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView category;
        private TextView rank;
        private TextView like_text;
        private TextView comment;
        private ConstraintLayout item;
        private ImageView like_btn;

        public CustomViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_ideas_title);
            category = itemView.findViewById(R.id.item_ideas_category);
            rank = itemView.findViewById(R.id.item_ideas_rank_text);
            like_text = itemView.findViewById(R.id.item_ideas_like_text);
            comment = itemView.findViewById(R.id.item_ideas_comment_text);
            item = itemView.findViewById(R.id.item_ideas);
            like_btn = item.findViewById(R.id.item_ideas_like_img);

        }
    }
}
