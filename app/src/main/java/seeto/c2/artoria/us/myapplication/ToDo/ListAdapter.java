package seeto.c2.artoria.us.myapplication.ToDo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;

public class ListAdapter extends RecyclerView.Adapter{

     ArrayList<ToDoFragment.TodoList> data;

     ListAdapter(ArrayList<ToDoFragment.TodoList> data) {
         this.data = data;
     }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.todo_item, parent, false
        );
        return new NoLimitItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ToDoFragment.TodoList todoList = data.get(position);
        NoLimitItemViewHolder item = (NoLimitItemViewHolder) holder;
        Log.e("xxx", item.header.toString());
        item.header.setText(todoList.header);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class NoLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header;

        NoLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.header);
        }

    }

    class CommonLimitItemViewHolder extends RecyclerView.ViewHolder {
        TextView header, leftDays, completeDegree;

        CommonLimitItemViewHolder(View itemView) {
            super(itemView);
            header = (TextView itemView.findViewById(R.id.header))
        }
    }

}
