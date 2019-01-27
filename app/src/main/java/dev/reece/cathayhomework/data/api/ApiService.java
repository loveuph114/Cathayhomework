package dev.reece.cathayhomework.data.api;

import dev.reece.cathayhomework.data.model.AreaData;
import dev.reece.cathayhomework.data.model.PlantData;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by reececheng on 2019/1/24.
 */

public interface ApiService {

    @GET("/opendata/datalist/apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14")
    Flowable<PlantData> getPlantData();

    @GET("/opendata/datalist/apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    Flowable<AreaData> getAreaData();
}
