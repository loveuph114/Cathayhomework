package dev.reece.cathayhomework.data.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reececheng on 2019/1/24.
 */

public class ApiClient {

    private static ApiClient sInstance;
    private ApiService mApiService;

    private static ApiClient getApiClient() {
        if(sInstance == null) {
            synchronized (ApiClient.class) {
                if(sInstance == null) {
                    sInstance = new ApiClient();
                }
            }
        }

        return sInstance;
    }

    private ApiClient() {
        mApiService = initApiService();
    }

    private ApiService initApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://data.taipei")
                .build();

        return retrofit.create(ApiService.class);
    }

    public static ApiService getApiService() {
        return getApiClient().mApiService;
    }

}
