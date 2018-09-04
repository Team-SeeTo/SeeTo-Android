package seeto.c2.artoria.us.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.Item.InventoryItem;

public class InventoryRecyclerAdapter extends RecyclerView.Adapter<InventoryRecyclerAdapter.CustomViewHolder> {
    ArrayList<InventoryItem> items;
    Context context;

    public InventoryRecyclerAdapter(ArrayList<InventoryItem> items, Context context){
        this.items = items;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.content.setText(items.get(position).getContent());
        holder.use_button.setOnClickListener(view -> Toast.makeText(context, "use button clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
       private TextView title;
       private TextView content;
       private ConstraintLayout use_button;

        public CustomViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_inventory_title);
            content = itemView.findViewById(R.id.item_inventory_content);
            use_button = itemView.findViewById(R.id.item_inventory_button);
        }
    }
}
