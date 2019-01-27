package dev.reece.cathayhomework.main;

import android.app.Fragment;
import android.content.Context;

import dev.reece.cathayhomework.main.navigator.IToolbarController;

/**
 * Created by reececheng on 2019/1/27.
 */

public abstract class BaseFragment extends Fragment {

    protected IToolbarController mToolbarController;

    protected abstract void onVisible();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof IToolbarController) {
            mToolbarController = (IToolbarController) context;
        }
    }

    protected void setToolbar(String title, boolean displayHomeAsUpEnabled) {
        if(mToolbarController != null) {
            mToolbarController.setToolbar(title, displayHomeAsUpEnabled);
        }
    }
}
