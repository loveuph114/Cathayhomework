package dev.reece.cathayhomework.main.arealist;

import java.util.ArrayList;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.DataManager;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaListPresenter implements AreaListContract.Presenter {

    private AreaListContract.View mView;
    private ArrayList<Area> mData = new ArrayList<>();

    AreaListPresenter(AreaListContract.View view) {
        mView = view;
    }

    @Override
    public void getListData() {
        if(mData.isEmpty()) {
            mData = DataManager.getInstance().getAreaList();
            mView.showList(mData);
        }
    }


}