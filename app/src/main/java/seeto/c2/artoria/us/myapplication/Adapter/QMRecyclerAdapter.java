package seeto.c2.artoria.us.myapplication.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Item.QMItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.QM.ViewMemoActivity;

import static android.media.CamcorderProfile.get;

public class QMRecyclerAdapter extends RecyclerView.Adapter<QMRecyclerAdapter.ViewHolder> {

    ArrayList<QMItem> QMItem;

    public QMRecyclerAdapter(ArrayList<QMItem> QMItem) {
        this.QMItem = QMItem;
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
        QMItem items = QMItem.get(position);
        holder.previewText.setText(items.getPreviewText());
        holder.container.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ViewMemoActivity.class);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return QMItem.size();
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