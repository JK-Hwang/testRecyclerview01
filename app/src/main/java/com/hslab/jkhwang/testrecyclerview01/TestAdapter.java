package com.hslab.jkhwang.testrecyclerview01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.Collections;

public class TestAdapter extends RecyclerView.Adapter<TestViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private ArrayList<Student> items = new ArrayList<>();
    private OnStartDragListener mDragStartListener;
    public RecyclerViewItemClickInterface delegate;

    private int lastPosition = -1;

    public TestAdapter(Context mContext, OnStartDragListener mDragStartListener) {
        this.context = mContext;
        this.mDragStartListener = mDragStartListener;
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
    public void onBindViewHolder(@NonNull final TestViewHolder holder, int position) {
        final Student item = items.get(position);
        holder.mStudentNameText.setText(item.getName());
        holder.mScoreText.setText(item.getScore());

        setAnimation(holder.itemView, position);

        holder.mMainCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.onItemClicked(String.valueOf(item.getName()));
            }
        });

        holder.mMainCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mDragStartListener.onStartDrag(holder);
                return false;
            }
        });

        /*
        holder.mMainCardView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
        */
    }

    @Override
    public void onItemMove(int fromIndex, int toIndex) {
        if (fromIndex < items.size() && toIndex < items.size()) {
            if (fromIndex < toIndex) {
                for (int i = fromIndex; i < toIndex; i++) {
                    Collections.swap(items, i, i + 1);
                }
            } else {
                for (int i = fromIndex; i > toIndex; i--) {
                    Collections.swap(items, i, i - 1);
                }
            }
            notifyItemMoved(fromIndex, toIndex);
        }
    }

    @Override
    public void onItemDismiss(int position) {
        if(items.size() < position) {
            items.remove(position);
            notifyItemRemoved(position);
        }
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
