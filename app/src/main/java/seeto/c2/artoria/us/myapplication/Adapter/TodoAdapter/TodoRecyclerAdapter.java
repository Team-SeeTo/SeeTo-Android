package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.Model.TodoMainModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.MyRadioButton;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoDetailActivity;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoFragment;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<TodoMainModel.Todo> data;
    String expiration;
    long diffDays;

    public TodoRecyclerAdapter(ArrayList<TodoMainModel.Todo> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        String todoType;
        if(data.get(position) != null)
            todoType = data.get(position).getType();
        else
            todoType = "INFINITY";

        switch (todoType) {
            case "INFINITY":
                return 0;
            case "STANDARD":
                return 1;
            case "HARD":
                return 2;
            default:
                Log.d("TODO recyclerview switching failure", "default");
                return 0;
        }
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
        TodoMainModel.Todo todoList = data.get(position);
        ArrayList<TodoMainModel.milestone> milestones = todoList.getMilestones();
        ArrayList<TodoItem> milestoneTemp = new ArrayList<>();
        //TODO: 통신시 datetime check하고 텍스트뷰 색깔 변경
        switch (getItemViewType(position)) {
            case 0:
                NoLimitItemViewHolder item = (NoLimitItemViewHolder) holder;
                item.header.setText(todoList.getTitle());
                for(int i=0; i<milestones.size(); i++) {
                    milestoneTemp.add(new TodoItem(milestones.get(i).getName(), milestones.get(i).getCompleted()));
                }
                item.milestones = milestoneTemp;
                break;
            case 1:
                CommonLimitItemViewHolder commonItem = (CommonLimitItemViewHolder) holder;
                commonItem.header.setText(todoList.getTitle());
                commonItem.listInfo.setText(getDiffDays(todoList.getExpriation())+"");
                for(int i=0; i<milestones.size(); i++) {
                    milestoneTemp.add(new TodoItem(milestones.get(i).getName(), milestones.get(i).getCompleted()));
                }
                commonItem.milestones = milestoneTemp;
                break;
            default:
                HardLimitItemViewHolder hardItem = (HardLimitItemViewHolder) holder;
                hardItem.header.setText(todoList.getTitle());
                hardItem.listInfo.setText(getDiffDays(todoList.getExpriation())+"");
                for(int i=0; i<milestones.size(); i++) {
                    milestoneTemp.add(new TodoItem(milestones.get(i).getName(), milestones.get(i).getCompleted()));
                }
                hardItem.milestones = milestoneTemp;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, TodoDetailActivity.class);
                intent.putParcelableArrayListExtra("milestones", milestoneTemp);
                intent.putExtra("expiration", todoList.getExpriation());
                intent.putExtra("type", todoList.getType());
                intent.putExtra("title", todoList.getTitle());
                intent.putExtra("id", todoList.getId());
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

    long getDiffDays(String dueDate) {
        SimpleDateFormat getSdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:sss");
        Calendar c = Calendar.getInstance();
        Date curDate = c.getTime();
        expiration  = dueDate;
        Date expirationDate;
        try {
            expirationDate = getSdf.parse(expiration);
            diffDays = (TimeUnit.DAYS.convert(expirationDate.getTime() - curDate.getTime(), TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
            diffDays = 1234;//TODO: 에러 처리 어케하지?
        }
        return diffDays;
    }

}

