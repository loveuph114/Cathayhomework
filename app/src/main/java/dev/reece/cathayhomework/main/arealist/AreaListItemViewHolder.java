package dev.reece.cathayhomework.main.arealist;

import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Area;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaListItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImg;
    private TextView mName;
    private TextView mInfo;
    private TextView mMemo;

    private Area mArea;

    public AreaListItemViewHolder(View view) {
        super(view);

        mImg = view.findViewById(R.id.area_list_img);
        mName = view.findViewById(R.id.area_list_name);
        mInfo = view.findViewById(R.id.area_list_info);
        mMemo = view.findViewById(R.id.area_list_memo);
    }

    public void onBind(Area area) {
        mArea = area;

        if(area.picUrl != null && !area.picUrl.isEmpty()) {
            int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 110, itemView.getResources().getDisplayMetrics());
            Picasso.get()
                    .load(area.picUrl)
                    .resize(size, size)
                    .centerCrop()
                    .error(R.drawable.image_error)
                    .placeholder(R.drawable.image_place_holder)
                    .into(mImg);
        } else {
            mImg.setImageResource(R.drawable.image_error);
        }

        mName.setText(area.name);
        mInfo.setText(area.info);

        if(area.memo.trim().equals("")) {
            mMemo.setText(R.string.area_list_item_no_memo);
        } else {
            mMemo.setText(area.memo);
        }
    }

    public void setOnAreaListItemClickListener(final AreaListAdapter.OnAreaListItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(mArea);
            }
        });
    }
}
