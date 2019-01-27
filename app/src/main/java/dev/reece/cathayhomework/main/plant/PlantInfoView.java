package dev.reece.cathayhomework.main.plant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Plant;

/**
 * Created by reececheng on 2019/1/27.
 */

public class PlantInfoView extends ScrollView implements PlantInfoContract.View {

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

        mImg = findViewById(R.id.plant_info_img);
        mInfo = findViewById(R.id.plant_info_info);

        setFillViewport(true);
    }

    @Override
    public void showPlantInfo(Plant plant) {
        if(plant.picUrl != null && !plant.picUrl.isEmpty()) {
            Picasso.get().load(plant.picUrl).into(mImg);
        }

        mInfo.setText(getInfoString(plant));
    }

    private String getInfoString(Plant plant) {
        StringBuilder builder = new StringBuilder();

        append(builder, plant.nameCh);
        appendNewline(builder);
        append(builder, plant.nameEn);
        appendNewline(builder);
        appendNewline(builder);
        append(builder, getContext().getString(R.string.plant_info_also_known));
        appendNewline(builder);
        append(builder, plant.alsoKnown);
        appendNewline(builder);
        appendNewline(builder);
        append(builder, getContext().getString(R.string.plant_info_brief));
        appendNewline(builder);
        append(builder, plant.brief);
        appendNewline(builder);
        appendNewline(builder);
        append(builder, getContext().getString(R.string.plant_info_feature));
        appendNewline(builder);
        append(builder, plant.feature);
        appendNewline(builder);
        appendNewline(builder);
        append(builder, getContext().getString(R.string.plant_info_function_application));
        appendNewline(builder);
        append(builder, plant.functionAndApplication);
        appendNewline(builder);
        appendNewline(builder);
        append(builder, getContext().getString(R.string.plant_info_update, plant.update));
        appendNewline(builder);

        return builder.toString();
    }

    private void append(StringBuilder builder, String string) {
        if(!"".equals(string)) {
            builder.append(string);
        }
    }

    private void appendNewline(StringBuilder builder) {
        builder.append("\n");
    }
}
