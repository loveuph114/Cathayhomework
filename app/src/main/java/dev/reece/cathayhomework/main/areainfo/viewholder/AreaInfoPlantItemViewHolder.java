package dev.reece.cathayhomework.main.areainfo.viewholder;

import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.main.areainfo.AreaInfoAdapter;
import dev.reece.cathayhomework.main.areainfo.data.AreaInfoPlantItem;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoPlantItemViewHolder extends AreaInfoViewHolder<IAreaInfoItem> {

    private ImageView mImg;
    private TextView mName;
    private TextView mAlsoKnown;

    private Plant mPlant;

    public AreaInfoPlantItemViewHolder(View view) {
        super(view);

        mImg = view.findViewById(R.id.area_info_plant_img);
        mName = view.findViewById(R.id.area_info_plant_name);
        mAlsoKnown = view.findViewById(R.id.area_info_plant_alsoknown);
    }

    @Override
    public void onBind(IAreaInfoItem data) {
        if(data instanceof AreaInfoPlantItem) {
            mPlant = ((AreaInfoPlantItem) data).getData();

            if(mPlant.picUrl != null && !mPlant.picUrl.isEmpty()) {
                int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 110, itemView.getResources().getDisplayMetrics());
                Picasso.get()
                        .load(mPlant.picUrl)
                        .resize(size, size)
                        .centerCrop()
                        .error(R.drawable.image_error)
                        .placeholder(R.drawable.image_place_holder)
                        .into(mImg);
            } else {
                mImg.setImageResource(R.drawable.image_error);
            }

            mName.setText(mPlant.nameCh);
            mAlsoKnown.setText(mPlant.alsoKnown);
        }
    }

    public void setOnAreaInfoPlantItemClickListener(final AreaInfoAdapter.OnAreaInfoPlantItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(mPlant);
            }
        });
    }
}
