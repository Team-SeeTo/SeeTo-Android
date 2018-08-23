package seeto.c2.artoria.us.myapplication.ToDo.TodoCreate.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import seeto.c2.artoria.us.myapplication.R;

import static seeto.c2.artoria.us.myapplication.ToDo.TodoCreate.CreateTodoActivity.viewPager;


public class SelectCategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_category, container, false);
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
                viewPager.setCurrentItem(getItem(1));
            }
        });
        return view;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public static SelectCategoryFragment newInstance() {
        SelectCategoryFragment fragment = new SelectCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}
