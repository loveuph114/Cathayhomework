package dev.reece.cathayhomework.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 {
 "E_Pic_URL": "http://www.zoo.gov.tw/iTAP/05_Exhibit/10_PenguinHouse.jpg",
 "E_Geo": "MULTIPOINT ((121.5911959 24.9929758))",
 "E_Info": "企鵝館是「國王企鵝」及「黑腳企鵝」的家，牠們是不會飛的水生鳥類，牠們全是游泳的專家，在水裡潛泳可以「飛」得又快又好。在觀賞可愛的企鵝之餘，也可以在企鵝館了解牠們的分布、形態特徵、生活習性及繁殖求偶行為喔！",
 "E_no": "10",
 "E_Category": "室內區",
 "E_Name": "企鵝館",
 "E_Memo": "每月第二個週一休館",
 "_id": 10,
 "E_URL": "http://www.zoo.taipei.gov.tw/ct.asp?xItem=73533151&ctNode=71656&mp=104031"
 },
 *
 * Created by reececheng on 2019/1/24.
 */

public class Area implements Parcelable{
    @SerializedName("E_Pic_URL")
    public String picUrl;

    @SerializedName("E_Info")
    public String info;

    @SerializedName("E_Category")
    public String category;

    @SerializedName("E_Name")
    public String name;

    @SerializedName("E_Memo")
    public String memo;

    @SerializedName("E_URL")
    public String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.picUrl);
        dest.writeString(this.info);
        dest.writeString(this.category);
        dest.writeString(this.name);
        dest.writeString(this.memo);
        dest.writeString(this.url);
    }

    public Area() {
    }

    protected Area(Parcel in) {
        this.picUrl = in.readString();
        this.info = in.readString();
        this.category = in.readString();
        this.name = in.readString();
        this.memo = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Area> CREATOR = new Creator<Area>() {
        @Override
        public Area createFromParcel(Parcel source) {
            return new Area(source);
        }

        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }
    };
}


