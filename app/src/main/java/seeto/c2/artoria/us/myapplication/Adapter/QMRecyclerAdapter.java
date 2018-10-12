package seeto.c2.artoria.us.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import java.util.ArrayList;
import seeto.c2.artoria.us.myapplication.Item.QMItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.QM.DatabaseHelper;
import seeto.c2.artoria.us.myapplication.UI.QM.Memo;
import seeto.c2.artoria.us.myapplication.UI.QM.QuickMemoContract;
import seeto.c2.artoria.us.myapplication.UI.QM.ViewMemoActivity;

public class QMRecyclerAdapter extends RecyclerView.Adapter<QMRecyclerAdapter.ViewHolder> {

    ArrayList<Memo> QMItem;
    Context context;

    public QMRecyclerAdapter(ArrayList<Memo> QMItem, Context context) {
        this.QMItem = QMItem;
        this.context = context;
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
        Memo items = QMItem.get(position);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewMemoActivity.class);
                intent.putExtra("memo", items.getText());
                intent.putExtra("id", items.getId());
                v.getContext().startActivity(intent);
            }
        });

        holder.previewText.setText(items.getText());
        holder.settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(v.getContext());
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.qm_recycler_menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.qm_menu) {
                            db.deleteRow(items.getText());
                            QMItem.remove(position);
                            notifyItemRemoved(position);
                            notifyDataSetChanged();
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return QMItem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView settingButton;
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