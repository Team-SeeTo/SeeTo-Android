package seeto.c2.artoria.us.myapplication.QM;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import seeto.c2.artoria.us.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quickmemo);
        ArrayList<Item> item=new ArrayList<>();
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        MyAdapter myAdapter = new MyAdapter(item);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
        item.add(new Item("sdfsdsdfsds"));
    }
}