package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

import static seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity.viewPager;


public class SelectCategoryFragment extends Fragment {
    String todoType;
    SibalLom sibalLom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_category, container, false);
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        todoType = getArguments().getString("todoType");

        String[] categoryList = {
                "IT", "Life", "Food"
        };

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                categoryList
        );

        MaterialBetterSpinner materialBetterSpinner;

        materialBetterSpinner = view.findViewById(R.id.category_spinner);
        materialBetterSpinner.setAdapter(categoryAdapter);
        materialBetterSpinner.setText(categoryAdapter.getItem(0).toString());

        TextView nextText = (TextView) view.findViewById(R.id.category_next);
        nextText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sibalLom.getCategory().setValue(materialBetterSpinner.getText().toString());
                Log.d("TODO",sibalLom.getCategory().getValue());
                viewPager.setCurrentItem(getItem(1));
            }
        });
        return view;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public static SelectCategoryFragment newInstance(String todoType) {
        Bundle args = new Bundle();
        args.putString("todoType", todoType);

        SelectCategoryFragment fragment = new SelectCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    void setCategory(String category) {

    }

}
