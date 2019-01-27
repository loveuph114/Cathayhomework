package dev.reece.cathayhomework.main.arealist;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaListDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, view.getResources().getDisplayMetrics());

        if(parent.getChildLayoutPosition(view) == 0) {
            outRect.top = padding;
        }

        outRect.left = padding;
        outRect.right = padding;
        outRect.bottom = padding;
    }
}
