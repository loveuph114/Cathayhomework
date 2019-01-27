package dev.reece.cathayhomework.main.areainfo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.main.BaseFragment;
import dev.reece.cathayhomework.main.navigator.Navigator;
import dev.reece.cathayhomework.main.navigator.OnToPlantPageListener;
import dev.reece.cathayhomework.main.plant.PlantInfoFragment;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaInfoFragment extends BaseFragment {

    private static final String TAG = AreaInfoFragment.class.getSimpleName();
    private static final String ARGS_KEY_AREA_DATA = TAG + "area_data";

    private AreaInfoPresenter mPresenter;
    private Area mArea;

    public static AreaInfoFragment newInstance(Area area) {
        AreaInfoFragment fragment = new AreaInfoFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARGS_KEY_AREA_DATA, area);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("REECE", "AreaInfoFragment onCreateView()");
        AreaInfoView view = new AreaInfoView(getActivity());
        view.setOnToPlantPageListener(new OnToPlantPageListener() {
            @Override
            public void toPlant(Plant plant) {
                Fragment fragment = PlantInfoFragment.newInstance(plant);
                Navigator.newInstance()
                        .fragment(fragment)
                        .isAddToBack(true)
                        .isAnimate(true)
                        .navigate(getActivity());
            }
        });

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mPresenter = new AreaInfoPresenter(view, compositeDisposable);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mArea = getArguments().getParcelable(ARGS_KEY_AREA_DATA);
        mPresenter.processAreaInfo(mArea);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void onVisible() {
        if(mArea != null) {
            setToolbar(mArea.name, true);
        }
    }
}
