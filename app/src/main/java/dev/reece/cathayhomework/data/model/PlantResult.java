package dev.reece.cathayhomework.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by reececheng on 2019/1/24.
 */

public class PlantResult implements Parcelable{
    @SerializedName("results")
    public ArrayList<Plant> plantList;

    public PlantResult() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.plantList);
    }

    protected PlantResult(Parcel in) {
        this.plantList = in.createTypedArrayList(Plant.CREATOR);
    }

    public static final Creator<PlantResult> CREATOR = new Creator<PlantResult>() {
        @Override
        public PlantResult createFromParcel(Parcel source) {
            return new PlantResult(source);
        }

        @Override
        public PlantResult[] newArray(int size) {
            return new PlantResult[size];
        }
    };
}
