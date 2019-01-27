package dev.reece.cathayhomework.main.areainfo.data;

import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.main.areainfo.AreaInfoAdapter;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoPlantItem implements IAreaInfoItem<Plant> {

    private Plant mPlant;

    public AreaInfoPlantItem(Plant plant) {
        mPlant = plant;
    }

    @Override
    public int getViewType() {
        return AreaInfoAdapter.VIEW_TYPE_AREA_PLANT;
    }

    @Override
    public Plant getData() {
        return mPlant;
    }
}
