package dev.reece.cathayhomework.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaPlantData implements Parcelable{
    public ArrayList<Area> areaList;
    public ArrayList<Plant> plantList;

    public AreaPlantData(ArrayList<Area> areaList, ArrayList<Plant> plantList) {
        this.areaList = areaList;
        this.plantList = plantList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.areaList);
        dest.writeTypedList(this.plantList);
    }

    protected AreaPlantData(Parcel in) {
        this.areaList = in.createTypedArrayList(Area.CREATOR);
        this.plantList = in.createTypedArrayList(Plant.CREATOR);
    }

    public static final Creator<AreaPlantData> CREATOR = new Creator<AreaPlantData>() {
        @Override
        public AreaPlantData createFromParcel(Parcel source) {
            return new AreaPlantData(source);
        }

        @Override
        public AreaPlantData[] newArray(int size) {
            return new AreaPlantData[size];
        }
    };
}
