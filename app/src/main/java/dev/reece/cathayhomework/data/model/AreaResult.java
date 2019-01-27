package dev.reece.cathayhomework.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaResult implements Parcelable{
    @SerializedName("results")
    public ArrayList<Area> areaList;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.areaList);
    }

    public AreaResult() {
    }

    protected AreaResult(Parcel in) {
        this.areaList = in.createTypedArrayList(Area.CREATOR);
    }

    public static final Creator<AreaResult> CREATOR = new Creator<AreaResult>() {
        @Override
        public AreaResult createFromParcel(Parcel source) {
            return new AreaResult(source);
        }

        @Override
        public AreaResult[] newArray(int size) {
            return new AreaResult[size];
        }
    };
}
