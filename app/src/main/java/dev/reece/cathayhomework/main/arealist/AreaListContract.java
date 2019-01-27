package dev.reece.cathayhomework.main.arealist;

import java.util.ArrayList;

import dev.reece.cathayhomework.data.model.Area;

/**
 * Created by reececheng on 2019/1/24.
 */

public interface AreaListContract {
    interface View {
        void showList(ArrayList<Area> data);
    }

    interface Presenter {
        void getListData();
    }
}
