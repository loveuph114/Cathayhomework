package dev.reece.cathayhomework.main.areainfo.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.areainfo.data.AreaInfoHeaderItem;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoHeaderItemViewHolder extends AreaInfoViewHolder<IAreaInfoItem> {

    private ImageView mImg;
    private TextView mInfo;
    private TextView mMemo;
    private TextView mCategory;
    private TextView mUrl;

    public AreaInfoHeaderItemViewHolder(View view) {
        super(view);

        mImg = view.findViewById(R.id.area_info_header_img);
        mInfo = view.findViewById(R.id.area_info_header_info);
        mMemo = view.findViewById(R.id.area_info_header_memo);
        mCategory = view.findViewById(R.id.area_info_header_category);
        mUrl = view.findViewById(R.id.area_info_header_url);
    }

    @Override
    public void onBind(IAreaInfoItem data) {
        if(data instanceof AreaInfoHeaderItem) {
            final Area area = ((AreaInfoHeaderItem) data).getData();

            if(area.picUrl != null && !area.picUrl.isEmpty()) {
                mImg.getLayoutParams().height = calculatePicHeight((AreaInfoHeaderItem) data);
                Picasso.get().load(area.picUrl).into(mImg);
            }

            mInfo.setText(area.info);
            mCategory.setText(area.category);

            if(area.memo.trim().equals("")) {
                mMemo.setText(R.string.area_list_item_no_memo);
            } else {
                mMemo.setText(area.memo);
            }

            mUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(area.url));
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    private int calculatePicHeight(AreaInfoHeaderItem data) {
        int screenWidth = itemView.getResources().getDisplayMetrics().widthPixels;

        float width = data.getPicWidth();
        float height = data.getPciHeight();

        float scale = width / height;

        return (int) (screenWidth / scale);
    }
}
