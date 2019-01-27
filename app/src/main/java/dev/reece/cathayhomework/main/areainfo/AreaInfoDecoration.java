package dev.reece.cathayhomework.main.areainfo;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, view.getResources().getDisplayMetrics());

        if(parent.getChildLayoutPosition(view) == 0) {
            outRect.top = 0;
            outRect.left = 0;
            outRect.right = 0;
            outRect.bottom = padding;
        } else {
            outRect.left = padding;
            outRect.right = padding;
            outRect.bottom = padding;
        }
    }
}
