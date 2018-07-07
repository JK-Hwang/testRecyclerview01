package com.hslab.jkhwang.testrecyclerview01;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TestViewHolder extends RecyclerView.ViewHolder {
    public TextView mStudentNameText, mScoreText;

    public TestViewHolder(View itemView) {
        super(itemView);
        mStudentNameText = (TextView)itemView.findViewById(R.id.nameText);
        mScoreText = (TextView)itemView.findViewById(R.id.scoreText);
    }
}
