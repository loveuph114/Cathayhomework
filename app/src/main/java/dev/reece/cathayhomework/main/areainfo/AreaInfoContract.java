package dev.reece.cathayhomework.main.areainfo;

import java.util.ArrayList;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;

/**
 * Created by reececheng on 2019/1/26.
 */

public interface AreaInfoContract {

    interface View {
        void showAreaInfo(ArrayList<IAreaInfoItem> data);
        void showError();
    }

    interface Presenter {
        void processAreaInfo(Area area);
        void onDestroy();
    }
}
