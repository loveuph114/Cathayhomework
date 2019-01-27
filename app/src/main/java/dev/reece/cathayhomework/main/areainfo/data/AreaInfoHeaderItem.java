package dev.reece.cathayhomework.main.areainfo.data;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.areainfo.AreaInfoAdapter;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoHeaderItem implements IAreaInfoItem<Area> {

    private Area mArea;

    public AreaInfoHeaderItem(Area area) {
        mArea = area;
    }

    @Override
    public int getViewType() {
        return AreaInfoAdapter.VIEW_TYPE_AREA_HEADER;
    }

    @Override
    public Area getData() {
        return mArea;
    }
}
