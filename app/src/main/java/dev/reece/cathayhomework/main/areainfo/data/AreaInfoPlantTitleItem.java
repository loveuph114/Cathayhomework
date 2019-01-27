package dev.reece.cathayhomework.main.areainfo.data;

import dev.reece.cathayhomework.main.areainfo.AreaInfoAdapter;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoPlantTitleItem implements IAreaInfoItem {

    public AreaInfoPlantTitleItem() {
    }

    @Override
    public int getViewType() {
        return AreaInfoAdapter.VIEW_TYPE_AREA_PLANT_TITLE;
    }

    @Override
    public Object getData() {
        return null;
    }
}
