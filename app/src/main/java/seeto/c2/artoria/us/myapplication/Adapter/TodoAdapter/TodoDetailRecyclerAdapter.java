package seeto.c2.artoria.us.myapplication.Adapter.TodoAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Item.TodoItem;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class TodoDetailRecyclerAdapter extends RecyclerView.Adapter<TodoDetailRecyclerAdapter.CustomViewholder>{
    ArrayList<TodoItem> todoItems;
    String type, id;
    Context context;

    public TodoDetailRecyclerAdapter(ArrayList<TodoItem> todoItems, String type, String id){
        this.todoItems = todoItems;
        this.type = type;
        this.id = id;
    }


    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int res;
        context = parent.getContext();
        switch (type) {
            case "normal":
                res = R.layout.item_deail_normal_todo;
                break;
            case "hard":
                res = R.layout.item_detail_hard_todo;
                break;
            default:
                res = R.layout.item_deail_normal_todo;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(res, parent,false);
        return new CustomViewholder(view, type);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
        if(holder==null) Log.d("TODO detail holder is", (holder==null)+"");
        holder.todoText.setText(todoItems.get(holder.getAdapterPosition()).getText());
        holder.todoCheckBox.setChecked(todoItems.get(holder.getAdapterPosition()).getChecked());

        if(holder.todoCheckBox.isChecked()) {
            switch (type) {
                case "normal":
                    holder.todoText.setTextColor(R.color.stdComplete);
                    Log.d("TODO normal checked",""+holder.todoCheckBox.isChecked());
                    break;
                case "hard":
                    holder.todoText.setTextColor(R.color.hardComplete);
                    Log.d("TODO hard checked",""+holder.todoCheckBox.isChecked());
                    break;
            }
            todoItems.get(holder.getAdapterPosition()).setChecked(true);
        }else {
            holder.todoText.setTextColor(Color.BLACK);
            todoItems.get(holder.getAdapterPosition()).setChecked(false);
        }

        holder.todoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switch (type) {
                        case "normal":
                            holder.todoText.setTextColor(R.color.stdComplete);
                            Log.d("TODO normal checked",""+isChecked);
                            break;
                        case "hard":
                            holder.todoText.setTextColor(R.color.hardComplete);
                            Log.d("TODO hard checked",""+isChecked);
                            break;
                    }
                    todoItems.get(holder.getAdapterPosition()).setChecked(true);
                    Log.d("TODO mile id", todoItems.get(position).getMilestoneId());
                    setMilestoneState(todoItems.get(position).getMilestoneId(), context);
                }else {
                    holder.todoCheckBox.setChecked(true);
                }
            }
        });

        holder.todoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String curText = s.toString();
                todoItems.get(holder.getAdapterPosition()).setText(curText);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    void setMilestoneState(String milestoneId, Context context) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("todoId", id)
                .putVariable("milestoneId", milestoneId)
                .putVariable("token", SharedPreferenceKt.getToken(context,true));
        new Connector(context).getClient().CompleteMilestone(queryContainerBuilder)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.d("TODO-milestone", "Request-successed");
                        Log.d("TODO-milestone-response", response.message());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("TODO-milestone", "Request-failed");
                    }
                });
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    class CustomViewholder extends RecyclerView.ViewHolder{
        private TextView todoText;
        private CheckBox todoCheckBox;

        public CustomViewholder(View itemView, String type) {
            super(itemView);
            switch (type) {
                case "normal":
                    todoText = itemView.findViewById(R.id.todo_detail_normal_text);
                    todoCheckBox = itemView.findViewById(R.id.todo_detail_normal_check_box);
                    break;
                case "hard":
                    todoText = itemView.findViewById(R.id.todo_detail_hard_text);
                    todoCheckBox = itemView.findViewById(R.id.todo_detail_hard_check_box);
                    break;
                default:
                    todoText = itemView.findViewById(R.id.todo_detail_normal_text);
                    todoCheckBox = itemView.findViewById(R.id.todo_detail_normal_check_box);
                    break;
            }
        }
    }
}