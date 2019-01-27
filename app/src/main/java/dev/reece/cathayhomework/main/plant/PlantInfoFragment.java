package dev.reece.cathayhomework.main.plant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.reece.cathayhomework.data.model.Plant;
import dev.reece.cathayhomework.main.BaseFragment;

/**
 * Created by reececheng on 2019/1/24.
 */

public class PlantInfoFragment extends BaseFragment {

    private static final String TAG = PlantInfoFragment.class.getSimpleName();
    private static final String ARGS_KEY_PLANT_DATA = TAG + "plant_data";

    private PlantInfoView mView;
    private Plant mPlant;

    public static PlantInfoFragment newInstance(Plant plant) {
        PlantInfoFragment fragment = new PlantInfoFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARGS_KEY_PLANT_DATA, plant);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = new PlantInfoView(getActivity());
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPlant = getArguments().getParcelable(ARGS_KEY_PLANT_DATA);
        mView.showPlantInfo(mPlant);
    }

    @Override
    protected void onVisible() {
        if(mPlant != null) {
            setToolbar(mPlant.nameCh, true);
        }
    }
}
