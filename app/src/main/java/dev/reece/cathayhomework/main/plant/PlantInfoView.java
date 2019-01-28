package dev.reece.cathayhomework.main.plant;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Plant;

/**
 * Created by reececheng on 2019/1/27.
 */

public class PlantInfoView extends ScrollView implements PlantInfoContract.View {

    private ProgressBar mProgressBar;

    private ImageView mImg;
    private TextView mInfo;

    public PlantInfoView(Context context) {
        super(context);
        init();
    }

    public PlantInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlantInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.plant_info_layout, this);

        mProgressBar = findViewById(R.id.plant_info_progressbar);

        mImg = findViewById(R.id.plant_info_img);
        mInfo = findViewById(R.id.plant_info_info);

        setFillViewport(true);
    }

    @Override
    public void showPlantInfo(Plant plant) {
        if(plant.picUrl != null && !plant.picUrl.isEmpty()) {
            Picasso.get().load(plant.picUrl).memoryPolicy(MemoryPolicy.NO_CACHE).into(mImg, new Callback() {
                @Override
                public void onSuccess() {
                    mProgressBar.setVisibility(GONE);
                    mImg.setVisibility(VISIBLE);
                    mInfo.setVisibility(VISIBLE);
                }

                @Override
                public void onError(Exception e) {
                    mProgressBar.setVisibility(GONE);
                    mImg.setVisibility(VISIBLE);
                    mInfo.setVisibility(VISIBLE);
                }
            });
        } else {
            mProgressBar.setVisibility(GONE);
            mImg.setVisibility(VISIBLE);
            mInfo.setVisibility(VISIBLE);
        }

        mInfo.setText(getInfoString(plant));
    }

    private String getInfoString(Plant plant) {
        StringBuilder builder = new StringBuilder();

        builder.append(plant.nameCh);
        builder.append("\n");
        builder.append(plant.nameEn);
        builder.append("\n");
        builder.append("\n");
        builder.append(getContext().getString(R.string.plant_info_also_known));
        builder.append("\n");
        builder.append(plant.alsoKnown);
        builder.append("\n");
        builder.append("\n");
        builder.append(getContext().getString(R.string.plant_info_brief));
        builder.append("\n");
        builder.append(plant.brief);
        builder.append("\n");
        builder.append("\n");
        builder.append(getContext().getString(R.string.plant_info_feature));
        builder.append("\n");
        builder.append(plant.feature);
        builder.append("\n");
        builder.append("\n");
        builder.append(getContext().getString(R.string.plant_info_function_application));
        builder.append("\n");;
        builder.append(plant.functionAndApplication);
        builder.append("\n");
        builder.append("\n");
        builder.append(getContext().getString(R.string.plant_info_update, plant.update));
        builder.append("\n");

        return builder.toString();
    }
}
