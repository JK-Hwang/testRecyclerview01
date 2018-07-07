package com.hslab.jkhwang.testrecyclerview01;

import android.support.v13.view.DragStartHelper;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {
    private ItemTouchHelper itemTouchHelper;

    TestAdapter mAdapter;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new TestAdapter(getApplicationContext());
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_test);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        addTestData();
    }

    public void addTestData() {
        for(int i=0; i<50; i++) {
            Student dataStudent = new Student();
            dataStudent.setName("Name"+i);
            dataStudent.setScore(String.valueOf(i));
            mAdapter.add(dataStudent);
        }
    }
}
