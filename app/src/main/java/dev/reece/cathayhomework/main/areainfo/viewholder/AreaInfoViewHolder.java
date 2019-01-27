package dev.reece.cathayhomework.main.areainfo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by reececheng on 2019/1/26.
 */

public abstract class AreaInfoViewHolder<T> extends RecyclerView.ViewHolder {
    public AreaInfoViewHolder(View view) {
        super(view);
    }

    public abstract void onBind(T data);
}
