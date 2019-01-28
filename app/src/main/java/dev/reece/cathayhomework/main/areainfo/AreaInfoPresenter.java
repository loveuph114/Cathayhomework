package dev.reece.cathayhomework.main.areainfo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.main.DataManager;
import dev.reece.cathayhomework.main.areainfo.data.AreaInfoHeaderItem;
import dev.reece.cathayhomework.main.areainfo.data.AreaInfoPlantItem;
import dev.reece.cathayhomework.main.areainfo.data.AreaInfoPlantTitleItem;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoPresenter implements AreaInfoContract.Presenter {

    private AreaInfoContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    private ArrayList<IAreaInfoItem> mAreaItems = new ArrayList<>();

    public AreaInfoPresenter(AreaInfoContract.View view, CompositeDisposable compositeDisposable) {
        mView = view;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void processAreaInfo(Area area) {
        if(mAreaItems.isEmpty()) {
            startProcess(area);
        }
    }

    private void startProcess(final Area area) {
        Picasso.get().load(area.picUrl).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                AreaInfoHeaderItem item = new AreaInfoHeaderItem(area, bitmap.getWidth(), bitmap.getHeight());
                mAreaItems.add(item);
                searchPlantDataByArea(area);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                AreaInfoHeaderItem item = new AreaInfoHeaderItem(area, 0, 0);
                mAreaItems.add(item);
                searchPlantDataByArea(area);
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    private void searchPlantDataByArea(Area area) {
        ArrayList<String> areaNameList = getAreaNameList(area);
        ArrayList<Plant> plantList = DataManager.getInstance().getPlantList();

        mCompositeDisposable.add(searchPlantInBackground(areaNameList, plantList)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ArrayList<IAreaInfoItem>>(){
                    @Override
                    public void onSuccess(ArrayList<IAreaInfoItem> items) {
                        if(!items.isEmpty()) {
                            mAreaItems.add(new AreaInfoPlantTitleItem());
                            mAreaItems.addAll(items);
                        }
                        mView.showAreaInfo(mAreaItems);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError();
                    }
                }));
    }

    /**
     * 處理部分 location 資料 mapping 不起來的問題
     */
    private ArrayList<String> getAreaNameList(Area area) {
        String areaName = area.name;
        ArrayList<String> areaMappingList = new ArrayList<>();

        areaMappingList.add(areaName);

        if("熱帶雨林區".equals(areaName)) {
            areaMappingList.add("亞洲熱帶雨林區");
        } else if("鳥園區".equals(areaName)) {
            areaMappingList.add("鳥園");
        } else if("昆蟲館".equals(areaName)) {
            areaMappingList.add("蟲蟲探索谷");
        } else if("穿山甲館(熱帶雨林館)".equals(areaName)) {
            areaMappingList.add("亞洲熱帶雨林區");
        }

        return areaMappingList;
    }

    private Single<ArrayList<IAreaInfoItem>> searchPlantInBackground(final ArrayList<String> areaNameList, final ArrayList<Plant> plantList) {
        return  Flowable.zip(Flowable.just(areaNameList), Flowable.just(plantList),
                new BiFunction<ArrayList<String>, ArrayList<Plant>, ArrayList<IAreaInfoItem>>() {
                    @Override
                    public ArrayList<IAreaInfoItem> apply(ArrayList<String> names, ArrayList<Plant> plants) throws Exception {
                        ArrayList<IAreaInfoItem> items = new ArrayList<>();

                        PlantLoop:
                        for(Plant plant : plants) {
                            for(String name : names) {
                                if(plant.location.contains(name)) {
                                    items.add(new AreaInfoPlantItem(plant));
                                    continue PlantLoop;
                                }
                            }
                        }

                        return items;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .single(new ArrayList<IAreaInfoItem>());
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
    }


}
