package seeto.c2.artoria.us.myapplication.Adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import seeto.c2.artoria.us.myapplication.Model.IdeasMainModel;
import seeto.c2.artoria.us.myapplication.R;

public class IdeasListAdapter extends PagedListAdapter<IdeasMainModel,IdeasListAdapter.CustomViewHoleder> {


    protected IdeasListAdapter(@NonNull DiffUtil.ItemCallback<IdeasMainModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CustomViewHoleder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ideas,parent,false);
        return new CustomViewHoleder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHoleder holder, int position) {

    }

    class CustomViewHoleder extends RecyclerView.ViewHolder{
    public CustomViewHoleder(View itemView) {
        super(itemView);
    }
}
}
