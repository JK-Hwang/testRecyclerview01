package com.hslab.jkhwang.testrecyclerview01;

public interface ItemTouchHelperAdapter {
    void onItemMove(int fromIndex, int toIndex);
    void onItemDismiss(int position);
}
