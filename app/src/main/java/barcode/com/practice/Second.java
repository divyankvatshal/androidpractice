package barcode.com.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import myinterface.RecyclerViewClickListener;

import static barcode.com.practice.R.styleable.RecyclerView;

public class Second extends AppCompatActivity implements RecyclerViewClickListener {
    RecyclerView recyclerView;
    EditText etname;
    Button btnAdd;
    LinearLayoutManager mLinearLayoutManager;
    MyAdapter adapter;

    List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = (RecyclerView) findViewById(R.id.mylist);
        etname = (EditText) findViewById(R.id.ename);
        btnAdd = (Button) findViewById(R.id.addname);

        //building layout manager to control layout view either vertical or horizontal
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //attaching layoutmanager to recyclerview
        recyclerView.setLayoutManager(mLinearLayoutManager);

        //initializing my nameList
        nameList = new ArrayList<>();
        //initialising adapter
        adapter = new MyAdapter(nameList,this, this);

        //attaching adapter to recyclerView
        recyclerView.setAdapter(adapter);


        //setting on click listener on button

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etname.getText().toString();
                if(text.trim().length() > 0){
                    nameList.add(text);
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    public void onClickListener(String name) {
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
    }
}


