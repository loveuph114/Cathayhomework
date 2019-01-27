package dev.reece.cathayhomework.main.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import dev.reece.cathayhomework.R;

/**
 * Created by reececheng on 2019/1/27.
 */

public class Navigator {

    private Fragment mFragment;
    private boolean mIsAddToBack = false;
    private boolean mIsAnimate = false;

    public static Navigator newInstance() {
        return new Navigator();
    }

    public void navigate(Activity activity) {
        if(mFragment == null) {
            return;
        }

        FragmentManager fragmentManger =  activity.getFragmentManager();
        FragmentTransaction transaction = fragmentManger.beginTransaction();

        if(mIsAnimate) {
            transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
        }

        if(mIsAddToBack) {
            transaction.addToBackStack(mFragment.getClass().getName());
        }

        transaction.add(R.id.main_container, mFragment);
        transaction.commit();
    }

    public Navigator fragment(Fragment fragment) {
        mFragment = fragment;
        return this;
    }

    public Navigator isAddToBack(boolean isAddToBack) {
        mIsAddToBack = isAddToBack;
        return this;
    }

    public Navigator isAnimate(boolean isAnimate) {
        mIsAnimate = isAnimate;
        return this;
    }
}
