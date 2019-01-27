package dev.reece.cathayhomework.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 {
 "F_Name_Latin": "Tabebuia chrysantha",
 "F_pdf02_ALT": "",
 "F_Location": "臺灣動物區；兒童動物區；非洲動物區；保育大道(主軸)",
 "F_pdf01_ALT": "",
 "F_Summary": "",
 "F_Pic01_URL": "http://www.zoo.gov.tw/iTAP/04_Plant/Bignoniaceae/chrysantha/chrysantha_1.jpg",
 "F_pdf02_URL": "",
 "F_Pic02_URL": "",
 "F_Keywords": "",
 "F_Code": "",
 "F_Geo": "MULTIPOINT ((121.5804577 24.9979216), (121.582185 24.9984662), (121.5867072 24.9945377), (121.5831023 24.9970222))",
 "F_Pic03_URL": "",
 "F_Voice01_ALT": "",
 "F_AlsoKnown": "黃鐘木、伊蓓樹、依蓓樹",
 "F_Voice02_ALT": "",
 "F_Name_Ch": "黃花風鈴木",
 "F_Pic04_ALT": "",
 "F_Name_En": "Golden bell tree、Golden trumpet tree",
 "F_Brief": "原產於中南美洲墨西哥、巴西、烏拉圭等國家，為巴西國花，偏好高溫氣候，臺灣目前大多種植於中南部，中南部開花狀況優於北部。花期3月，僅持續10天左右。",
 "F_Pic04_URL": "",
 "F_Voice01_URL": "",
 "F_Feature": "喬木，高度4~5公尺，在冬季會落葉。葉片呈手掌狀，分裂成5枚小葉，小葉呈卵形或長橢圓形，邊緣呈稀疏鋸齒狀，整片葉布滿褐色毛，觸感粗糙。花朵長度5~8公分，呈漏斗狀或風鈴狀，有5枚花瓣，呈金黃色，邊緣皺曲。果實細長，成熟後會裂開，表面佈滿褐色絨毛，有利傳播種子。葉片及果實表面的細毛有輕微毒性，皮膚接觸可能發癢。",
 "F_Pic02_ALT": "",
 "F_Family": "紫葳科Bignoniaceae",
 "F_Voice03_ALT": "",
 "F_Function&Application": "1. 常作為庭園造景及行道樹。",
 "F_Voice02_URL": "",
 "F_Pic03_ALT": "",
 "F_Pic01_ALT": "黃花風鈴木",
 "F_CID": "",
 "F_pdf01_URL": "",
 "F_Vedio_URL": "",
 "F_Genus": "風鈴木屬Tabebuia",
 "F_Voice03_URL": "",
 "F_Update": "2017/9/4",
 "_id": 77
 }
 *
 * Created by reececheng on 2019/1/24.
 */

public class Plant implements Parcelable{
    @SerializedName("F_Name_Latin")
    public String nameLatin;

    @SerializedName("F_Location")
    public String location;

    @SerializedName("F_Pic01_URL")
    public String picUrl;

    @SerializedName("F_AlsoKnown")
    public String alsoKnown;

    @SerializedName("F_Name_Ch")
    public String nameCh;

    @SerializedName("F_Name_En")
    public String nameEn;

    @SerializedName("F_Brief")
    public String brief;

    @SerializedName("F_Feature")
    public String feature;

    @SerializedName("F_Family")
    public String family;

    @SerializedName("F_Function&Application")
    public String functionAndApplication;

    @SerializedName("F_Pic01_ALT")
    public String picAlt;

    @SerializedName("F_Genus")
    public String genus;

    @SerializedName("F_Update")
    public String update;

    public Plant() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameLatin);
        dest.writeString(this.location);
        dest.writeString(this.picUrl);
        dest.writeString(this.alsoKnown);
        dest.writeString(this.nameCh);
        dest.writeString(this.nameEn);
        dest.writeString(this.brief);
        dest.writeString(this.feature);
        dest.writeString(this.family);
        dest.writeString(this.functionAndApplication);
        dest.writeString(this.picAlt);
        dest.writeString(this.genus);
        dest.writeString(this.update);
    }

    protected Plant(Parcel in) {
        this.nameLatin = in.readString();
        this.location = in.readString();
        this.picUrl = in.readString();
        this.alsoKnown = in.readString();
        this.nameCh = in.readString();
        this.nameEn = in.readString();
        this.brief = in.readString();
        this.feature = in.readString();
        this.family = in.readString();
        this.functionAndApplication = in.readString();
        this.picAlt = in.readString();
        this.genus = in.readString();
        this.update = in.readString();
    }

    public static final Creator<Plant> CREATOR = new Creator<Plant>() {
        @Override
        public Plant createFromParcel(Parcel source) {
            return new Plant(source);
        }

        @Override
        public Plant[] newArray(int size) {
            return new Plant[size];
        }
    };
}
