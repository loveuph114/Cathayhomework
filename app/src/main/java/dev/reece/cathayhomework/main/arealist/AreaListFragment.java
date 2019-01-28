package dev.reece.cathayhomework.main.arealist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.BaseFragment;
import dev.reece.cathayhomework.main.areainfo.AreaInfoFragment;
import dev.reece.cathayhomework.main.navigator.Navigator;
import dev.reece.cathayhomework.main.navigator.OnToAreaPageListener;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaListFragment extends BaseFragment {

    private AreaListPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        setToolbar(getString(R.string.main_title), false);

        AreaListView view = new AreaListView(getActivity());
        view.setOnToAreaPageListener(new OnToAreaPageListener() {
            @Override
            public void toArea(Area area) {
                Fragment fragment = AreaInfoFragment.newInstance(area);
                Navigator.newInstance()
                        .fragment(fragment)
                        .isAddToBack(true)
                        .navigate(getActivity());
            }
        });

        mPresenter = new AreaListPresenter(view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getListData();
    }

    @Override
    protected void onVisible() {
        setToolbar(getString(R.string.main_title), false);
    }
}
