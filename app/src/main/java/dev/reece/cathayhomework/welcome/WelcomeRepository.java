package dev.reece.cathayhomework.welcome;

import java.util.ArrayList;

import dev.reece.cathayhomework.data.api.ApiService;
import dev.reece.cathayhomework.data.api.LoadException;
import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.data.model.AreaData;
import dev.reece.cathayhomework.data.model.AreaPlantData;
import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.data.model.PlantData;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by reececheng on 2019/1/24.
 */

public class WelcomeRepository {

    private final ApiService mApiService;

    WelcomeRepository(ApiService apiService) {
        mApiService = apiService;
    }

    Single<AreaPlantData> loadData() {
        return Flowable.zip(
                mApiService.getAreaData().map(new Function<AreaData, ArrayList<Area>>() {
                    @Override
                    public ArrayList<Area> apply(AreaData area) throws Exception {
                        if(area != null && area.result != null && area.result.areaList != null) {
                            return area.result.areaList;
                        } else {
                            return new ArrayList<>();
                        }
                    }
                }),
                mApiService.getPlantData().map(new Function<PlantData, ArrayList<Plant>>() {
                    @Override
                    public ArrayList<Plant> apply(PlantData plant) throws Exception {
                        if(plant != null && plant.result != null && plant.result.plantList != null) {
                            return plant.result.plantList;
                        } else {
                            return new ArrayList<>();
                        }
                    }
                }),
                new BiFunction<ArrayList<Area>, ArrayList<Plant>, AreaPlantData>() {
                    @Override
                    public AreaPlantData apply(ArrayList<Area> areas, ArrayList<Plant> plants) throws Exception {
                        if(areas.isEmpty()) {
                            throw new LoadException(LoadException.ErrorCode.EMPTY);
                        }

                        if(plants.isEmpty()) {
                            throw new LoadException(LoadException.ErrorCode.EMPTY);
                        }

                        return new AreaPlantData(areas, plants);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .single(new AreaPlantData(new ArrayList<Area>(), new ArrayList<Plant>()));
    }
}
