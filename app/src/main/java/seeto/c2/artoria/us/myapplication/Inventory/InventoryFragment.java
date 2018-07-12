package seeto.c2.artoria.us.myapplication.Inventory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.baseline.baseline.Item.InventoryItem;

public class InventoryFragment extends Fragment implements InventoryContract.View {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inventory,container,false);

        ArrayList<InventoryItem> data = new ArrayList<>();
        RecyclerView inventory_list = rootView.findViewById(R.id.inventory_recycler);

        data.add(new InventoryItem("Streak Freeze","You can rest today!"));
        data.add(new InventoryItem("Ideas Bonus","double today's\nIdea point"));

        InventoryAdapter adapter = new InventoryAdapter(data,getActivity());
        inventory_list.setAdapter(adapter);

        return rootView;
    }
}
