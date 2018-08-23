package seeto.c2.artoria.us.myapplication.QM;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import seeto.c2.artoria.us.myapplication.R;

import static android.media.CamcorderProfile.get;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Item> item;

    public MyAdapter(ArrayList<Item> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.activity_cardviewmemo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item items = item.get(position);
        holder.previewText.setText(items.getPreviewText());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewMemoActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton settingButton;
        TextView previewText;
        LinearLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            settingButton = itemView.findViewById(R.id.settingButton);
            previewText = (TextView) itemView.findViewById(R.id.previewText);
            container = itemView.findViewById(R.id.cardViewMemo_container);
        }
    }


}