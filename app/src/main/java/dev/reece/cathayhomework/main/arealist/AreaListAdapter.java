package dev.reece.cathayhomework.main.arealist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.navigator.OnToAreaPageListener;


/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaListAdapter extends RecyclerView.Adapter<AreaListItemViewHolder> {

    public interface OnAreaListItemClickListener {
        void onClick(Area area);
    }

    private ArrayList<Area> mData = new ArrayList<>();
    private OnToAreaPageListener mOnToAreaPageListener;

    private int mLastPosition = -1;

    @Override
    public AreaListItemViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_list_item, parent, false);

        AreaListItemViewHolder viewHolder = new AreaListItemViewHolder(view);
        viewHolder.setOnAreaListItemClickListener(new OnAreaListItemClickListener() {
            @Override
            public void onClick(Area area) {
                mOnToAreaPageListener.toArea(area);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AreaListItemViewHolder holder, int position) {
        holder.onBind(mData.get(position));

        if(holder.getAdapterPosition() > mLastPosition) {
            Animation a = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.item_animation_up);
            holder.itemView.startAnimation(a);

            mLastPosition = holder.getAdapterPosition();
        } else {
            holder.itemView.clearAnimation();
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnToAreaPageListener(OnToAreaPageListener listener) {
        mOnToAreaPageListener = listener;
    }

    public void setData(ArrayList<Area> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
