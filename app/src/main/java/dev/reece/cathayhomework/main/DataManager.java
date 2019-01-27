package dev.reece.cathayhomework.main;

import java.util.ArrayList;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.data.model.AreaPlantData;
import dev.reece.cathayhomework.data.model.Plant;

/**
 * Created by reececheng on 2019/1/26.
 */

public class DataManager {

    private static DataManager sInstance;

    private AreaPlantData mData;

    public static DataManager getInstance() {
        if(sInstance == null) {
            synchronized (DataManager.class) {
                if(sInstance == null) {
                    sInstance = new DataManager();
                }
            }
        }

        return sInstance;
    }


    public void setData(AreaPlantData mData) {
        this.mData = mData;
    }

    public AreaPlantData getData() {
        return mData;
    }

    public ArrayList<Area> getAreaList() {
        return mData.areaList;
    }

    public ArrayList<Plant> getPlantList() {
        return mData.plantList;
    }
}
