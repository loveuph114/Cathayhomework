package dev.reece.cathayhomework.main.areainfo.data;

/**
 * Created by reececheng on 2019/1/26.
 */

public interface IAreaInfoItem<T> {
    int getViewType();
    T getData();
}
