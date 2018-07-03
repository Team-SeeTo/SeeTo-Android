package seeto.c2.artoria.us.myapplication.ToDo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.NodeList;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> data;

    ListAdapter(ArrayList<Object> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
        // TODO: 2018-07-03 타입 검사 필요 
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        Log.e("xxx", viewType + "");
        switch (viewType) {
            case 0:
                item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.todo_item, parent, false
                );
                return new NoLimitItemViewHolder(item);
            case 1:
                item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.todo_common_limit_item, parent, false
                );
                return new CommonLimitItemViewHolder(item);
            case 2:
                item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.todo_hard_list_item, parent, false
                );
                return new HardLimitItemViewHolder(item);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object todoList = data.get(position);


        switch (position % 3) {
            case 0:
                NoLimitItemViewHolder item = (NoLimitItemViewHolder) holder;
                item.header.setText(((ToDoFragment.NoLimitList) todoList).header);
                break;
            case 1:
                CommonLimitItemViewHolder commonItem = (CommonLimitItemViewHolder) holder;
                commonItem.header.setText(((ToDoFragment.CommonLimitList) todoList).header);
                commonItem.listInfo.setText(((ToDoFragment.CommonLimitList) todoList).listInfo);
                break;
            case 2:
                HardLimitItemViewHolder hardItem = (HardLimitItemViewHolder) holder;
                hardItem.header.setText(((ToDoFragment.HardLimitList) todoList).header);
                hardItem.listInfo.setText(((ToDoFragment.HardLimitList) todoList).listInfo);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class NoLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        public MyRadioButton radioButton;
        boolean flag;

        NoLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.no_limit_header);

            radioButton = (MyRadioButton) itemView.findViewById(R.id.no_limit_radioButton);
        }
    }


    class CommonLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header, listInfo;

        CommonLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.common_header);
            listInfo = (TextView) itemView.findViewById(R.id.common_list_info);
        }
    }

    class HardLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header, listInfo;

        HardLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.hard_header);
            listInfo = (TextView) itemView.findViewById(R.id.hard_list_info);
        }
    }

}
