package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.MyRadioButton;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoDetailActivity;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoFragment;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> data;

    public TodoRecyclerAdapter(ArrayList<Object> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
        // TODO: 2018-07-03 서버 연동시 타입 검사
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        switch (viewType) {
            case 0:
                item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_todo_hard_limit, parent, false
                );
                return new NoLimitItemViewHolder(item);
            case 1:
                item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_todo_common_limit, parent, false
                );
                return new CommonLimitItemViewHolder(item);
            case 2:
                item = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_todo_hard_list, parent, false
                );
                return new HardLimitItemViewHolder(item);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object todoList = data.get(position);
        ArrayList<TodoItem> milestoneTemp;
        //TODO: 통신시 datetime check하고 텍스트뷰 색깔 변경
        switch (position % 3) {
            case 0:
                NoLimitItemViewHolder item = (NoLimitItemViewHolder) holder;
                item.header.setText(((TodoFragment.NoLimitList) todoList).header);
                item.milestones = milestoneTemp = ((TodoFragment.NoLimitList) todoList).milestones;
                break;
            case 1:
                CommonLimitItemViewHolder commonItem = (CommonLimitItemViewHolder) holder;
                commonItem.header.setText(((TodoFragment.CommonLimitList) todoList).header);
                commonItem.listInfo.setText(((TodoFragment.CommonLimitList) todoList).listInfo);
                commonItem.milestones = milestoneTemp =((TodoFragment.CommonLimitList) todoList).milestones;
                break;
            default:
                HardLimitItemViewHolder hardItem = (HardLimitItemViewHolder) holder;
                hardItem.header.setText(((TodoFragment.HardLimitList) todoList).header);
                hardItem.listInfo.setText(((TodoFragment.HardLimitList) todoList).listInfo);
                hardItem.milestones = milestoneTemp =((TodoFragment.HardLimitList) todoList).milestones;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, TodoDetailActivity.class);
                intent.putParcelableArrayListExtra("milestones", milestoneTemp);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class NoLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        public MyRadioButton radioButton;
        boolean flag;
        ArrayList<TodoItem> milestones;

        NoLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.no_limit_header);

            radioButton = (MyRadioButton) itemView.findViewById(R.id.no_limit_radioButton);
        }
    }


    public class CommonLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header, listInfo;
        ArrayList<TodoItem> milestones;

        CommonLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.common_header);
            listInfo = (TextView) itemView.findViewById(R.id.common_list_info);
        }
    }

    public class HardLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header, listInfo;
        ArrayList<TodoItem> milestones;

        HardLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.hard_header);
            listInfo = (TextView) itemView.findViewById(R.id.hard_list_info);
        }
    }

}

