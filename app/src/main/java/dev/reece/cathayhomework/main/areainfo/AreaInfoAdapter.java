package dev.reece.cathayhomework.main.areainfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;
import dev.reece.cathayhomework.main.areainfo.viewholder.AreaInfoHeaderItemViewHolder;
import dev.reece.cathayhomework.main.areainfo.viewholder.AreaInfoPlantItemTitleViewHolder;
import dev.reece.cathayhomework.main.areainfo.viewholder.AreaInfoPlantItemViewHolder;
import dev.reece.cathayhomework.main.areainfo.viewholder.AreaInfoViewHolder;
import dev.reece.cathayhomework.main.navigator.OnToPlantPageListener;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoAdapter extends RecyclerView.Adapter<AreaInfoViewHolder> {

    public static final int VIEW_TYPE_AREA_HEADER = 0;
    public static final int VIEW_TYPE_AREA_PLANT = 1;
    public static final int VIEW_TYPE_AREA_PLANT_TITLE = 2;

    public interface OnAreaInfoPlantItemClickListener {
        void onClick(Plant plant);
    }

    private ArrayList<IAreaInfoItem> mData = new ArrayList<>();
    private OnToPlantPageListener mOnToPlantPageListener;

    private int mLastPosition = -1;

    @Override
    public AreaInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_AREA_HEADER: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.area_info_header_item, parent, false);

                return new AreaInfoHeaderItemViewHolder(view);
            }

            case VIEW_TYPE_AREA_PLANT: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.area_info_plant_item, parent, false);

                AreaInfoPlantItemViewHolder viewHolder = new AreaInfoPlantItemViewHolder(view);
                viewHolder.setOnAreaInfoPlantItemClickListener(new OnAreaInfoPlantItemClickListener() {
                    @Override
                    public void onClick(Plant plant) {
                        mOnToPlantPageListener.toPlant(plant);
                    }
                });

                return viewHolder;
            }

            case VIEW_TYPE_AREA_PLANT_TITLE :{
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.area_info_plant_title_item, parent, false);

                return new AreaInfoPlantItemTitleViewHolder(view);
            }
        }

        return null;
    }

    @Override
    public void onBindViewHolder(AreaInfoViewHolder holder, int position) {
        holder.onBind(mData.get(position));

        if (holder.getAdapterPosition() > mLastPosition) {
            Animation animation;

            if (holder instanceof AreaInfoHeaderItemViewHolder) {
                animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.item_animation_pop);
            } else {
                animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.item_animation_up);
            }

            holder.itemView.startAnimation(animation);

            mLastPosition = holder.getAdapterPosition();
        } else {
            holder.itemView.clearAnimation();
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getViewType();
    }

    public void setOnToPlantPageListener(OnToPlantPageListener listener) {
        mOnToPlantPageListener = listener;
    }

    public void setData(ArrayList<IAreaInfoItem> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
