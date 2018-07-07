package com.hslab.jkhwang.testrecyclerview01;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {
    private Context context;
    private ArrayList<Student> items = new ArrayList<>();

    private int lastPosition = -1;

    public TestAdapter(Context mContext) {
        context = mContext;
    }

    public void add(Student data) {
        items.add(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_test, parent, false);
        return new TestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        Student item = items.get(position);
        holder.mStudentNameText.setText(item.getName());
        holder.mScoreText.setText(item.getScore());

        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void setAnimation(View viewToAnimate, int position) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
    }
}
