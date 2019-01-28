package dev.reece.cathayhomework.welcome;

import android.util.Log;

import dev.reece.cathayhomework.data.api.LoadException;
import dev.reece.cathayhomework.data.model.AreaPlantData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by reececheng on 2019/1/24.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {
    private static String TAG = WelcomePresenter.class.getSimpleName();

    private final WelcomeContract.View mView;
    private final WelcomeRepository mRepository;
    private final CompositeDisposable mCompositeDisposable;

    WelcomePresenter(WelcomeContract.View view, WelcomeRepository repository, CompositeDisposable compositeDisposable) {
        mView = view;
        mRepository = repository;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void loadData() {
        mCompositeDisposable.add(mRepository.loadData().subscribeWith(new DisposableSingleObserver<AreaPlantData>(){
            @Override
            public void onSuccess(AreaPlantData areaPlantData) {
                mView.loadCompleted(areaPlantData);
            }

            @Override
            public void onError(Throwable e) {
                if(e instanceof LoadException) {
                    LoadException.ErrorCode code = ((LoadException) e).errorCode;
                    if(code == LoadException.ErrorCode.EMPTY) {
                        Log.e(TAG, "DATA IS EMPTY!!!!!");
                    } else {
                        Log.e(TAG, "UNKNOWN ERROR!!!!!");
                    }
                } else {
                    e.printStackTrace();
                }

                mView.showError();
            }
        }));
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
    }
}
