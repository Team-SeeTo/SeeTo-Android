package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.Fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.SibalLom;

import static seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate.CreateTodoActivity.viewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectDueDateFragment extends Fragment {
    String editTodoExpiration;
    public SelectDueDateFragment() {
        // Required empty public constructor
    }
    SibalLom sibalLom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_select_due_date, container, false);
        sibalLom = ViewModelProviders.of(getActivity()).get(SibalLom.class);
        editTodoExpiration = getArguments().getString("editTodoExpiration");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat editTodoSdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");

        CalendarView calendarView = view.findViewById(R.id.due_calendar);
        if(editTodoExpiration == null) {
            try {
                calendarView.setDate(Calendar.getInstance().getTime());
            } catch (OutOfDateRangeException e) {
                e.printStackTrace();
            }
        }else {
            try {
                calendarView.setDate(editTodoSdf.parse(editTodoExpiration));
            } catch (OutOfDateRangeException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                String selectedDate = sdf.format(calendarView.getFirstSelectedDate().getTime());
                sibalLom.getExpiration().setValue(selectedDate);
                Log.d("TODO", selectedDate);
            }
        });

        TextView nextText = (TextView) view.findViewById(R.id.date_next);
        nextText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(+1));
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public static SelectDueDateFragment newInstance() {

        Bundle args = new Bundle();
        args.putString("editTodoExpiration", null);

        SelectDueDateFragment fragment = new SelectDueDateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static SelectDueDateFragment newInstance(String editTodoExpiration) {

        Bundle args = new Bundle();
        args.putString("editTodoExpiration", editTodoExpiration);

        SelectDueDateFragment fragment = new SelectDueDateFragment();
        fragment.setArguments(args);
        return fragment;
    }



}