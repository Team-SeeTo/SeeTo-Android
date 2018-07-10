package seeto.c2.artoria.us.myapplication.Store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Model.StoreModel;
import seeto.c2.artoria.us.myapplication.R;

public class StoreRecyclerAdapter extends RecyclerView.Adapter<StoreRecyclerAdapter.CustomView>{
    private ArrayList<StoreModel> items;
    private Context context;

    public StoreRecyclerAdapter(ArrayList<StoreModel> items, Context context){
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.content.setText(items.get(position).getContent());
        holder.price.setText(items.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomView extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private TextView price;

        public CustomView(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_store_title);
            content = itemView.findViewById(R.id.item_store_content);
            price = itemView.findViewById(R.id.item_store_price);
        }
    }
}
