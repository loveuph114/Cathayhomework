package dev.reece.cathayhomework.main.areainfo.data;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.areainfo.AreaInfoAdapter;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoHeaderItem implements IAreaInfoItem<Area> {

    private Area mArea;

    private int mPicWidth;
    private int mPicHeight;

    public AreaInfoHeaderItem(Area area, int picWidth, int picHeight) {
        mArea = area;
        mPicWidth = picWidth;
        mPicHeight = picHeight;
    }

    @Override
    public int getViewType() {
        return AreaInfoAdapter.VIEW_TYPE_AREA_HEADER;
    }

    @Override
    public Area getData() {
        return mArea;
    }

    public int getPciHeight() {
        return mPicHeight;
    }

    public int getPicWidth() {
        return mPicWidth;
    }
}
