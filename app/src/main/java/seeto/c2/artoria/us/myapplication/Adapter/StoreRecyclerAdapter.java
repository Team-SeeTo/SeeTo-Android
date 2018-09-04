package seeto.c2.artoria.us.myapplication.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Item.StoreItem;
import seeto.c2.artoria.us.myapplication.R;

public class StoreRecyclerAdapter extends RecyclerView.Adapter<StoreRecyclerAdapter.CustomView>{
    private ArrayList<StoreItem> items;
    private Context context;

    public StoreRecyclerAdapter(ArrayList<StoreItem> items, Context context){
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
        holder.item.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(context);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_store,null);
            View cancel = view.findViewById(R.id.dialog_store_cancel);
            View purchase = view.findViewById(R.id.dialog_store_purchase);
            dialog.setContentView(view);
            dialog.show();

            cancel.setOnClickListener(v1 -> dialog.dismiss());

            purchase.setOnClickListener(v1 ->{
                Toast.makeText(context, "purchase button clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomView extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private TextView price;
        private ConstraintLayout item;

        public CustomView(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_store_title);
            content = itemView.findViewById(R.id.item_store_content);
            price = itemView.findViewById(R.id.item_store_price);
            item = itemView.findViewById(R.id.item_store_item);
        }
    }
}
